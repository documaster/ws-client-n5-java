package com.documaster.rms.noark.ws.client.info;

import com.documaster.rms.noark.ws.client.Bean;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyInfoResponse implements Bean {

	private final String userId;

	@JsonCreator
	private MyInfoResponse(@JsonProperty("userId") String userId) {

		this.userId = userId;
	}

	public String getUserId() {

		return userId;
	}
}
