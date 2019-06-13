package com.documaster.rms.noark.ws.client.transaction;

import java.util.HashMap;
import java.util.Map;

import com.documaster.rms.noark.ws.client.Bean;
import com.documaster.rms.noark.ws.client.ResponseObject;
import com.documaster.rms.noark.ws.noarkentities.NoarkEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionResponse implements Bean {

	@JsonProperty
	private final Map<String, ResponseObject> saved;

	@JsonCreator
	public TransactionResponse(@JsonProperty("saved") Map<String, ResponseObject> saved) {

		this.saved = saved;
	}

	@JsonIgnore
	public Map<String, NoarkEntity> getSaved() {

		Map<String, NoarkEntity> savedEntities = new HashMap<>();
		for (Map.Entry<String, ResponseObject> entry : this.saved.entrySet()) {

			savedEntities.put(entry.getKey(), entry.getValue().getEntity());
		}

		return savedEntities;
	}
}
