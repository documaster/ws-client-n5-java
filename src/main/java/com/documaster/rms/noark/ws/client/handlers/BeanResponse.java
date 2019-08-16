package com.documaster.rms.noark.ws.client.handlers;

import com.documaster.rms.noark.ws.client.Bean;
import org.apache.http.entity.ContentType;

public class BeanResponse<T extends Bean> extends Response {

	private final T bean;

	public BeanResponse(ContentType contenType, int statusCode, String statusMessage, T bean) {

		super(contenType, statusCode, statusMessage);

		this.bean = bean;
	}

	public T getBean() {

		return bean;
	}

}
