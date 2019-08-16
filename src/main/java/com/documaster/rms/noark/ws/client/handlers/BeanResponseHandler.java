package com.documaster.rms.noark.ws.client.handlers;

import java.io.IOException;

import com.documaster.rms.noark.ws.client.Bean;
import com.documaster.rms.noark.ws.client.exceptions.ServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;

public class BeanResponseHandler<T extends Bean> implements ResponseHandler<BeanResponse<T>> {

	private final ObjectMapper mapper;
	private final Class<? extends Bean> beanClass;
	private final ErrorResponseHandler errorHandler;

	public BeanResponseHandler(ObjectMapper mapper, Class<T> beanClass) {

		this.mapper = mapper;
		this.beanClass = beanClass;
		this.errorHandler = new ErrorResponseHandler();
	}

	@SuppressWarnings("unchecked")
	@Override
	public BeanResponse<T> handleResponse(HttpResponse response) throws ClientProtocolException, IOException {

		errorHandler.throwOnErrorResponse(response);

		final HttpEntity entity = response.getEntity();

		T bean;

		try {

			bean = (T) mapper.readValue(entity.getContent(), beanClass);

		} catch (Exception ex) {

			throw new ServiceException("Cannot deserialize server response", ex);
		}

		return new BeanResponse<>(
				ContentType.getOrDefault(entity), response.getStatusLine().getStatusCode(), response.getStatusLine()
				.getReasonPhrase(), bean);
	}

}
