package com.documaster.rms.noark.ws.client.handlers;

import org.apache.http.entity.ContentType;

public class StringResponse extends Response {

	private final String response;

	public StringResponse(ContentType contenType, int statusCode, String statusMessage, String response) {

		super(contenType, statusCode, statusMessage);

		this.response = response;
	}

	public String getResponse() {

		return response;
	}
}
