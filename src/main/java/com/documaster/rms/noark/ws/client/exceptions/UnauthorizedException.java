package com.documaster.rms.noark.ws.client.exceptions;

public class UnauthorizedException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public UnauthorizedException() {

		super();
	}

	public UnauthorizedException(ErrorMessage errorMessage) {

		super(errorMessage);
	}
}
