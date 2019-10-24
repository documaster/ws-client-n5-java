package com.documaster.rms.noark.ws.client.handlers;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

public class StringResponseHandler extends BaseResponseHandler<StringResponse> {

	private final String encoding;

	public StringResponseHandler(String encoding) {

		this(encoding, new ErrorResponseHandler());
	}

	public StringResponseHandler(String encoding, ErrorResponseHandler errorHandler) {

		super(errorHandler);

		this.encoding = encoding;
	}

	@Override
	protected StringResponse handleResponseInternal(final HttpResponse response) throws IOException {

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
