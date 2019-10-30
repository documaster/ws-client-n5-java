package com.documaster.rms.noark.ws.client.handlers;

import java.io.IOException;

import com.documaster.rms.noark.ws.client.Bean;
import com.documaster.rms.noark.ws.client.exceptions.ServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.ContentType;

public class BeanResponseHandler<T extends Bean> extends BaseResponseHandler<BeanResponse<T>> {

	private final ObjectMapper mapper;
	private final Class<? extends Bean> beanClass;

	public BeanResponseHandler(ObjectMapper mapper, Class<T> beanClass) {

		this(mapper, beanClass, new ErrorResponseHandler());
	}

	public BeanResponseHandler(ObjectMapper mapper, Class<T> beanClass, ErrorResponseHandler errorHandler) {

		super(errorHandler);

		this.mapper = mapper;
		this.beanClass = beanClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected BeanResponse<T> handleResponseInternal(HttpResponse response) throws ClientProtocolException, IOException {

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
