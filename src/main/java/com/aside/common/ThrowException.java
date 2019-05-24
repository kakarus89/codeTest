package com.aside.common;

import org.springframework.context.MessageSourceResolvable;


@SuppressWarnings("serial")
public class ThrowException extends RuntimeException implements MessageSourceResolvable {
	public ThrowException() {
		// TODO Auto-generated constructor stub
	}
	
	public ThrowException(String message) {
		super(message);
	}

	public String[] getCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] getArguments() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDefaultMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}
