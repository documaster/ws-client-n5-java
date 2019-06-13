package com.documaster.rms.noark.ws.client.handlers;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

public class VoidResponseHandler implements ResponseHandler<VoidResponse> {

	private final ErrorResponseHandler errorHandler;

	public VoidResponseHandler() {

		this.errorHandler = new ErrorResponseHandler();
	}

	@Override
	public VoidResponse handleResponse(final HttpResponse response) throws IOException {

		errorHandler.throwOnErrorResponse(response);

		return new VoidResponse(response.getStatusLine().getStatusCode(), response.getStatusLine().getReasonPhrase());
	}
}
