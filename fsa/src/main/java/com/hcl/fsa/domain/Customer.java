package com.hcl.fsa.domain;

import com.hcl.fsa.common.IConstants;

public class Customer implements IDomain{
	private Long customerId;
	private String name;
	private Long phNum;
	private String mailId;
	private String status = IConstants.ACTIVE;

	public Customer() {
	}
	public void lockCustomer() {
		status=IConstants.LOCK;
	}
	
	public boolean isActive(){
		return status.equals(IConstants.ACTIVE);
	}
	public Customer(Long customerId, String name, Long phNum, String mailId) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phNum = phNum;
		this.mailId = mailId;
	}

	public Customer(Long customerId, String name, Long phNum, String mailId, String status) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phNum = phNum;
		this.mailId = mailId;
		this.status = status;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhNum() {
		return phNum;
	}

	public void setPhNum(Long phNum) {
		this.phNum = phNum;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
