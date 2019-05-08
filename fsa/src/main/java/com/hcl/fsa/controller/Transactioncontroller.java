package com.hcl.fsa.controller;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
import com.hcl.fsa.dto.MonthlyResponseDto;
import com.hcl.fsa.dto.TransactionReqDto;
import com.hcl.fsa.exception.CustomException;
import com.hcl.fsa.exception.MessageCode;
import com.hcl.fsa.service.TransactionService;

import io.swagger.annotations.ApiOperation;

@RestController
public class Transactioncontroller {

	@Autowired
	TransactionService tservice;

	@PostMapping(path = "customers/{cid}/credit")
	Transaction credits(@PathVariable Long cid, @RequestBody TransactionReqDto trd) {
		Transaction t = new Transaction(0L, cid, trd.getDesription(), trd.getAmount(), 0D, IConstants.CREDIT,
				Util.getCurrentTime());
		return tservice.credits(t);
	}

	@PostMapping(path = "customers/{cid}/debit")
	Transaction debits(@PathVariable Long cid, @RequestBody TransactionReqDto trd) {
		Transaction t = new Transaction(0L, cid, trd.getDesription(), trd.getAmount(), 0D, IConstants.DEBIT,
				Util.getCurrentTime());
		return tservice.credits(t);
	}

	@GetMapping(path = "customers/{cid}/balance")
	Ledger getCustomerbalance(@PathVariable Long cid) {
		return tservice.getBalanceOfCustomer(cid);
	}

	@GetMapping(path = "customers/{cid}/report/{month}")
	MonthlyResponseDto getMonthlyReport(@PathVariable Long cid, @PathVariable int month) {
		if (month < 1 || month > 12) {
			throw new CustomException(MessageCode.Invalid_Month);
		}
		Date date = new Date();
		date.setMonth(month - 1);
		return tservice.getMonthlyReport(cid, date);
	}

}
