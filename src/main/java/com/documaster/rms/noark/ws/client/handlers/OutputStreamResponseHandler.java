package com.documaster.rms.noark.ws.client.handlers;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;

public class OutputStreamResponseHandler implements ResponseHandler<OutputStreamResponse> {

	private final OutputStream os;
	private final ErrorResponseHandler errorHandler;

	public OutputStreamResponseHandler(OutputStream os) {

		this.os = os;
		this.errorHandler = new ErrorResponseHandler();
	}

	@Override
	public OutputStreamResponse handleResponse(HttpResponse response) throws ClientProtocolException, IOException {

		errorHandler.throwOnErrorResponse(response);

		final HttpEntity entity = response.getEntity();

		IOUtils.copyLarge(entity.getContent(), os);

		OutputStreamResponse content = new OutputStreamResponse(
				ContentType.getOrDefault(entity), response.getStatusLine().getStatusCode(), response.getStatusLine()
				.getReasonPhrase(), os);

		return content;
	}

}
