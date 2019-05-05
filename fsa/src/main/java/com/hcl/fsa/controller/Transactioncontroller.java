package com.hcl.fsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.fsa.common.IConstants;
import com.hcl.fsa.common.Util;
import com.hcl.fsa.domain.Ledger;
import com.hcl.fsa.domain.Transaction;
import com.hcl.fsa.dto.TransactionReqDto;
import com.hcl.fsa.service.TransactionService;

@RestController
public class Transactioncontroller {

	@Autowired
	TransactionService tservice;

	@PostMapping(path = "customers/{cid}/credit")
	Transaction credits(@PathVariable Long cid, @RequestBody TransactionReqDto trd) {
		Transaction t = new Transaction(0L, cid, trd.getDesription(), trd.getAmount(), IConstants.CREDIT,
				Util.getCurrentTime());
		return tservice.credits(t);
	}

	@PostMapping(path = "customers/{cid}/debit")
	Transaction debits(@PathVariable Long cid, @RequestBody TransactionReqDto trd) {
		Transaction t = new Transaction(0L, cid, trd.getDesription(), trd.getAmount(), IConstants.DEBIT,
				Util.getCurrentTime());
		return tservice.credits(t);
	}

	@GetMapping(path = "customers/{cid}/balance")
	Ledger getCustomerbalance(Long cid) {
		return tservice.getBalanceOfCustomer(cid);
	}

}
