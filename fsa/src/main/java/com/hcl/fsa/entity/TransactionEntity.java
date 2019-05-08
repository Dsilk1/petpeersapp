package com.hcl.fsa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity implements IEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	@Column(name = "DESCRIPTION")
	private String desription;
	@Column(name = "AMOUNT")
	private Double amount;
	@Column(name = "CURRENTBALANCE")
	private Double currentbalance;
	@Column(name = "PAYMENTTYPE")
	private String paymentType;
	@Column(name = "TRANSACTION_DATE")
	private Date date;
	public TransactionEntity() {
		// TODO Auto-generated constructor stub
	}
	public TransactionEntity(Long transactionId, Long customerId, String desription, Double amount, Double currentbalance,String paymentType,
			Date date) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.desription = desription;
		this.amount = amount;
		this.paymentType = paymentType;
		this.date = date;
		this.currentbalance=currentbalance;
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
	public Double getCurrentbalance() {
		return currentbalance;
	}
	public void setCurrentbalance(Double currentbalance) {
		this.currentbalance = currentbalance;
	}
	
	
	
}
