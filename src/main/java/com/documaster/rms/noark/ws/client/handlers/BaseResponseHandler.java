package com.documaster.rms.noark.ws.client.handlers;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

public abstract class BaseResponseHandler<T> implements ResponseHandler<T> {

	private final ErrorResponseHandler errorHandler;

	public BaseResponseHandler(ErrorResponseHandler errorHandler) {

		this.errorHandler = errorHandler == null ? new ErrorResponseHandler() : errorHandler;
	}

	@Override
	public final T handleResponse(HttpResponse response) throws ClientProtocolException, IOException {

		errorHandler.throwOnErrorResponse(response);

		return handleResponseInternal(response);
	}

	protected abstract T handleResponseInternal(HttpResponse response) throws ClientProtocolException, IOException;
}
