package com.hcl.fsa.exception;

public class MessageCode {

	private int code;
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageCode(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public static MessageCode RECORD_NOT_FOUND = new MessageCode(101, "Record not found");
	public static MessageCode INSUFFICENT_FUNDS = new MessageCode(102, "Insufficent Funds");
	public static MessageCode USER_RECORD_NOT_FOUND = new MessageCode(103, "Customer not found");
	public static MessageCode TRANSACTION_NOT_FOUND = new MessageCode(104, "Transaction not found");
	public static MessageCode CUSTOMER_LOCKED = new MessageCode(105, "CustomerLocked");
	public static MessageCode Invalid_Month = new MessageCode(106, "Month valid from 1 to 12");
}
