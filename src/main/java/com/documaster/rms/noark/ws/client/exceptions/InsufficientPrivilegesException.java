package com.documaster.rms.noark.ws.client.exceptions;

public class InsufficientPrivilegesException extends ServiceException {

	private static final long serialVersionUID = 2867587934258734L;

	public InsufficientPrivilegesException() {

		super();
	}

	public InsufficientPrivilegesException(ErrorMessage errorMessage) {

		super(errorMessage);
	}
}
