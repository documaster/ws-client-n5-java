package com.documaster.rms.noark.ws.client.exceptions;

public class ConflictException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public ConflictException() {

		super();
	}

	public ConflictException(ErrorMessage errorMessage) {

		super(errorMessage);
	}
}
