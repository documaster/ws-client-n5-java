package com.documaster.rms.noark.ws.client.handlers;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.ContentType;

public class OutputStreamResponseHandler extends BaseResponseHandler<OutputStreamResponse> {

	private final OutputStream os;

	public OutputStreamResponseHandler(OutputStream os) {

		this(os, new ErrorResponseHandler());
	}

	public OutputStreamResponseHandler(OutputStream os, ErrorResponseHandler errorHandler) {

		super(errorHandler);
		this.os = os;
	}

	@Override
	protected OutputStreamResponse handleResponseInternal(HttpResponse response)
			throws ClientProtocolException, IOException {

		final HttpEntity entity = response.getEntity();

		IOUtils.copyLarge(entity.getContent(), os);

		OutputStreamResponse content = new OutputStreamResponse(
				ContentType.getOrDefault(entity), response.getStatusLine().getStatusCode(), response.getStatusLine()
				.getReasonPhrase(), os);

		return content;
	}

}
