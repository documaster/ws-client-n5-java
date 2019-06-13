package com.documaster.rms.noark.ws.client.handlers;

import java.io.OutputStream;

import org.apache.http.entity.ContentType;

public class OutputStreamResponse extends Response {

	private final OutputStream outputStream;

	public OutputStreamResponse(
			ContentType contenType, int statusCode, String statusMessage, OutputStream outputStream) {

		super(contenType, statusCode, statusMessage);
		this.outputStream = outputStream;
	}

	public OutputStream getOutputStream() {

		return outputStream;
	}

}
