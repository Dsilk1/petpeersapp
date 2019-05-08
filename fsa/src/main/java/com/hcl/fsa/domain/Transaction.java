package com.hcl.fsa.domain;

import java.util.Date;

public class Transaction implements IDomain {
	private Long transactionId;
	private Long customerId;
	private String desription;
	private Double amount;
	private Double currentBalance;
	private String paymentType;
	private Date date;

	public Transaction() {
	}

	public Transaction(Long transactionId, Long customerId, String desription, Double amount,Double currentBalance, String paymentType,
			Date date) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.desription = desription;
		this.amount = amount;
		this.paymentType = paymentType;
		this.date = date;
		this.currentBalance=currentBalance;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

}
