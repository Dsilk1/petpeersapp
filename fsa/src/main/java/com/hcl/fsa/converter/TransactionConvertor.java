package com.hcl.fsa.converter;

import org.springframework.stereotype.Component;

import com.hcl.fsa.domain.Transaction;
import com.hcl.fsa.entity.TransactionEntity;

@Component
public class TransactionConvertor implements IConverter<Transaction, TransactionEntity> {

	@Override
	public TransactionEntity convert(Transaction d) {
		// TODO Auto-generated method stub
		return new TransactionEntity(d.getTransactionId(), d.getCustomerId(), d.getDesription(), d.getAmount(), d.getPaymentType(), d.getDate());
	}

	@Override
	public Transaction convert(TransactionEntity d) {
		// TODO Auto-generated method stub
		return new Transaction(d.getTransactionId(), d.getCustomerId(), d.getDesription(), d.getAmount(), d.getPaymentType(), d.getDate());
	}

	
	

}
