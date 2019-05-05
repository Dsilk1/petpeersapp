package com.hcl.fsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity implements IEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PHNUMER")
	private Long phNum;
	@Column(name = "MAILID")
	private String mailId;
	@Column(name = "STATUS")
	private String status;

	public CustomerEntity() {
		// TODO Auto-generated constructor stub
	}

	public CustomerEntity(Long customerId, String name, Long phNum, String mailId, String status) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phNum = phNum;
		this.mailId = mailId;
		this.status = status;
	}

	public CustomerEntity(String name, Long phNum, String mailId, String status) {
		super();
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
