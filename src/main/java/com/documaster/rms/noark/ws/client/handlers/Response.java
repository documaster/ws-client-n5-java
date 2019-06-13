package com.documaster.rms.noark.ws.client.handlers;

import org.apache.http.entity.ContentType;

public abstract class Response {

	private final ContentType contentType;
	private final int statusCode;
	private final String statusMessage;

	public Response(int statusCode, String statusMessage) {

		this(null, statusCode, statusMessage);
	}

	public Response(ContentType contenType, int statusCode, String statusMessage) {

		this.contentType = contenType;
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public ContentType getContentType() {

		return contentType;
	}

	public int getStatusCode() {

		return statusCode;
	}

	public String getStatusMessage() {

		return statusMessage;
	}

}
