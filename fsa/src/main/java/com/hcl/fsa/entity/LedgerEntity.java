package com.hcl.fsa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LEDGER")
public class LedgerEntity implements IEntity {

	@Id
	private Long customerId;

	@Column(name = "BALANCE")
	private Double balance;
	@Column(name = "MODIFEDAT")
	private Date modified_at;

	public LedgerEntity() {
	}

	public LedgerEntity(Long customerId, Double balance, Date modified_at) {
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
