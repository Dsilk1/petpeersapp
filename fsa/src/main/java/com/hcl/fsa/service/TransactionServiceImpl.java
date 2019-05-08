package com.hcl.fsa.service;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.fsa.common.IConstants;
import com.hcl.fsa.common.Util;
import com.hcl.fsa.converter.IConverter;
import com.hcl.fsa.domain.Customer;
import com.hcl.fsa.domain.Ledger;
import com.hcl.fsa.domain.Transaction;
import com.hcl.fsa.dto.MonthlyResponseDto;
import com.hcl.fsa.entity.LedgerEntity;
import com.hcl.fsa.entity.TransactionEntity;
import com.hcl.fsa.exception.CustomException;
import com.hcl.fsa.exception.MessageCode;
import com.hcl.fsa.repository.LedgerRepository;
import com.hcl.fsa.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	CustomerService customerService;
	@Autowired
	TransactionRepository transactionRepo;
	@Autowired
	LedgerRepository ledgerrepo;
	@Autowired
	IConverter<Ledger, LedgerEntity> ledgerConverter;

	@Autowired
	IConverter<Transaction, TransactionEntity> transactionConverter;

	@Override
	public Ledger getBalanceOfCustomer(Long cid) {
		verifyCustomer(cid);
		return getLedgerForCustomer(cid);
	}

	@Override
	public Transaction credits(Transaction t) {
		verifyCustomer(t.getCustomerId());
		Ledger l = getLedgerForCustomer(t.getCustomerId());
		l.updateledger(t);
		return saveLedgerAndTransaction(t, l);
	}

	@Override
	public Transaction debits(Transaction t) {
		verifyCustomer(t.getCustomerId());
		Ledger l = getLedgerForCustomer(t.getCustomerId());
		l.updateledger(t);
		return saveLedgerAndTransaction(t, l);
	}

	private void verifyCustomer(Long cid) {
		Customer c = customerService.getCustomerById(cid);
		if (!c.isActive()) {
			throw new CustomException(MessageCode.CUSTOMER_LOCKED);
		}
	}

	private Ledger getLedgerForCustomer(Long cid) {
		Optional<LedgerEntity> ledgerentity = ledgerrepo.findById(cid);
		if (ledgerentity.isPresent()) {
			return ledgerConverter.convert(ledgerentity.get());
		} else {
			return new Ledger(cid, 0D, Util.getCurrentTime());
		}

	}

	private Transaction saveLedgerAndTransaction(Transaction t, Ledger l) {
		Optional<LedgerEntity> ledgerEntity = ledgerrepo.findById(l.getCustomerId());
		Date date = Util.getCurrentTime();
		if (ledgerEntity.isPresent()) {
			ledgerEntity.get().setBalance(l.getBalance());
			ledgerEntity.get().setModified_at(l.getModified_at());
			ledgerEntity.get().setModified_at(date);
		} else {
			ledgerrepo.save(ledgerConverter.convert(l));
		}
		t.setDate(date);
		t.setCurrentBalance(l.getBalance());
		Transaction tres = transactionConverter.convert(transactionRepo.save(transactionConverter.convert(t)));
		return tres;
	}

	@Override
	public MonthlyResponseDto getMonthlyReport(Long cid, Date date) {
		List<Transaction> monthlyTransactions = transactionRepo.findAll().stream()
				.filter(x -> date.getMonth() == x.getDate().getMonth()).map(x -> transactionConverter.convert(x))
				.collect(Collectors.toList());
		if (monthlyTransactions.size() == 0)
			throw new CustomException(MessageCode.RECORD_NOT_FOUND);
		Double totalCredits = monthlyTransactions.stream()
				.filter(x -> x.getPaymentType().equalsIgnoreCase(IConstants.CREDIT)).map(x -> x.getAmount())
				.mapToDouble(Double::doubleValue).sum();
		Double totalDebits = monthlyTransactions.stream()
				.filter(x -> x.getPaymentType().equalsIgnoreCase(IConstants.DEBIT)).map(x -> x.getAmount())
				.mapToDouble(Double::doubleValue).sum();
		monthlyTransactions.sort(Comparator.comparing(Transaction::getDate));
		Double closingBlances = monthlyTransactions.get(monthlyTransactions.size()-1).getCurrentBalance();
		String month = new SimpleDateFormat("MMMM").format(date);
		return new MonthlyResponseDto(month, totalCredits, totalDebits, closingBlances);
	}

}
