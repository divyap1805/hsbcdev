package com.hsbc.exceptions;

public class StudentAlreadyExistsException extends RuntimeException {

	public StudentAlreadyExistsException(String msg, Throwable e) {
		
		super(msg,e);
	}

}
