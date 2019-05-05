package com.hcl.fsa.service;

import com.hcl.fsa.domain.Ledger;
import com.hcl.fsa.domain.Transaction;

public interface TransactionService {

	Ledger getBalanceOfCustomer(Long cid);
	Transaction  credits (Transaction t);
	Transaction  debits (Transaction t);
}
