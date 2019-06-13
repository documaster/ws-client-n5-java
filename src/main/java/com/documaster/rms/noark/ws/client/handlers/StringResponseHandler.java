package com.documaster.rms.noark.ws.client.handlers;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

public class StringResponseHandler implements ResponseHandler<StringResponse> {

	private final String encoding;
	private final ErrorResponseHandler errorHandler;

	public StringResponseHandler(String encoding) {

		this.encoding = encoding;
		this.errorHandler = new ErrorResponseHandler();
	}

	@Override
	public StringResponse handleResponse(final HttpResponse response) throws IOException {

		errorHandler.throwOnErrorResponse(response);

		final HttpEntity entity = response.getEntity();

		String content = "";

		if (entity != null) {

			content = EntityUtils.toString(entity, encoding);
		}

		return new StringResponse(
				ContentType.getOrDefault(entity), response.getStatusLine().getStatusCode(), response.getStatusLine()
				.getReasonPhrase(), content);
	}

}
