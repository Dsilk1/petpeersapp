package com.hcl.fsa.exception;

public class CustomException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MessageCode ex;
	public CustomException() {
		ex=MessageCode.RECORD_NOT_FOUND;
	}
	
	public MessageCode getEx() {
		return ex;
	}
	public void setEx(MessageCode ex) {
		this.ex = ex;
	}
	public CustomException(MessageCode ex) {
		this.ex=ex;
		
	}

}
