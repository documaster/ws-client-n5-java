package com.documaster.rms.noark.ws.client.exceptions;

public class ResourceNotFoundException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {

		super();
	}

	public ResourceNotFoundException(String message, ErrorMessage errorMessage) {

		super(message, errorMessage);
	}

	public ResourceNotFoundException(ErrorMessage errorMessage) {

		super(errorMessage);
	}
}
