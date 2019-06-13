package com.documaster.rms.noark.ws.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;

public class NoarkDeserializerException extends JsonProcessingException {

	public NoarkDeserializerException(String message) {

		super(message);
	}

	public NoarkDeserializerException(String message, Throwable throwable) {

		super(message, throwable);
	}
}
