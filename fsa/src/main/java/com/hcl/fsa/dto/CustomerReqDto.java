package com.hcl.fsa.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.lang.NonNull;

public class CustomerReqDto {

	@NonNull
	private String name;
	@NonNull
	@Min(value = 10, message = "Mobile numer should be valid")
    @Max(value = 10, message = "Mobile numer should be valid")
	private Long phNum;
	@NonNull
	@Email(message = "Email should be valid")
	private String mailId;

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

}
