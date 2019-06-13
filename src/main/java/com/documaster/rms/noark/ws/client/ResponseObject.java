package com.documaster.rms.noark.ws.client;

import com.documaster.rms.noark.ws.noarkentities.NoarkEntity;
import com.documaster.rms.noark.ws.serialization.NoarkObjectDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = NoarkObjectDeserializer.class)
public class ResponseObject {

	private final NoarkEntity entity;

	public ResponseObject(NoarkEntity entity) {

		this.entity = entity;
	}

	public NoarkEntity getEntity() {

		return entity;
	}
}
