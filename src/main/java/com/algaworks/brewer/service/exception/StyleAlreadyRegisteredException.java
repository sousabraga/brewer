package com.algaworks.brewer.service.exception;

public class StyleAlreadyRegisteredException extends RuntimeException {

	private static final long serialVersionUID = -5090629785961723725L;

	public StyleAlreadyRegisteredException(String message) {
		super(message);
	}
	
}
