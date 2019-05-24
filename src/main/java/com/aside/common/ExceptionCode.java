package com.aside.common;

public enum ExceptionCode {	
	SUCCESS(0)

	, FAIL(903);
	
	
	private final int value;

	public int value() {
		return this.value;
	}

	
	private ExceptionCode(int value) {
		this.value = value;
	}
}
