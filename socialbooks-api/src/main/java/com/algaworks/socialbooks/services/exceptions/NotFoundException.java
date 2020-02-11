package com.algaworks.socialbooks.services.exceptions;

public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6802230168213117302L;

	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
