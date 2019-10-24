package com.documaster.rms.noark.ws.client.handlers;

import java.io.IOException;

import org.apache.http.HttpResponse;

public class VoidResponseHandler extends BaseResponseHandler<VoidResponse> {

	public VoidResponseHandler() {

		this(new ErrorResponseHandler());
	}

	public VoidResponseHandler(ErrorResponseHandler errorHandler) {

		super(errorHandler);
	}

	@Override
	protected VoidResponse handleResponseInternal(final HttpResponse response) throws IOException {

		return new VoidResponse(response.getStatusLine().getStatusCode(), response.getStatusLine().getReasonPhrase());
	}
}
