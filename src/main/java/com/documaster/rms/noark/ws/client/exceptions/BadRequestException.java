package com.documaster.rms.noark.ws.client.exceptions;

public class BadRequestException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public BadRequestException() {

		super();
	}

	public BadRequestException(ErrorMessage errorMessage) {

		super(errorMessage);
	}

	public BadRequestException(String message, ErrorMessage errorMessage) {

		super(message, errorMessage);
	}
}
