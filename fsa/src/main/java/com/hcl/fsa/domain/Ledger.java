package com.hcl.fsa.domain;

import java.util.Date;

import com.hcl.fsa.common.IConstants;
import com.hcl.fsa.exception.CustomException;
import com.hcl.fsa.exception.MessageCode;

public class Ledger implements IDomain{
	private Long customerId;
	private Double balance;
	private Date modified_at;
	
	public void updateledger(Transaction t) {
		if(t.getPaymentType().equalsIgnoreCase(IConstants.CREDIT)) {
			this.balance = this.balance +t.getAmount();
		}else {
			if(this.balance  - t.getAmount() < 0) {
				throw new CustomException(MessageCode.INSUFFICENT_FUNDS);
			}else
				this.balance = this.balance - t.getAmount();
		}
	}
	
	public Ledger() {
	}
	public Ledger(Long customerId, Double balance, Date modified_at) {
		super();
		this.customerId = customerId;
		this.balance = balance;
		this.modified_at = modified_at;
	}
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Date getModified_at() {
		return modified_at;
	}

	public void setModified_at(Date modified_at) {
		this.modified_at = modified_at;
	}

	

}
