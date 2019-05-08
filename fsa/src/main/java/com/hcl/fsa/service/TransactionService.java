package com.hcl.fsa.service;

import java.util.Date;

import com.hcl.fsa.domain.Ledger;
import com.hcl.fsa.domain.Transaction;
import com.hcl.fsa.dto.MonthlyResponseDto;

public interface TransactionService {

	Ledger getBalanceOfCustomer(Long cid);
	Transaction  credits (Transaction t);
	Transaction  debits (Transaction t);
	MonthlyResponseDto getMonthlyReport(Long cid,Date date);
}
