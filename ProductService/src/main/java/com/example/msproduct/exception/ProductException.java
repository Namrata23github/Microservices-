package com.example.msproduct.exception;


public class ProductException extends RuntimeException {

	public ProductException(String msg) {
		super(msg);
	}

	public ProductException(String msg, Throwable th) {
		super(msg, th);
	}

	public ProductException(Exception ex) {
		super(ex);
	}

}
