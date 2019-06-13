package com.documaster.rms.noark.ws.client.query;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Order {

	@JsonProperty("asc")
	ASCENDING,

	@JsonProperty("desc")
	DESCENDING
}
