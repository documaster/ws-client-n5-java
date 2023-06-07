package com.documaster.rms.noark.ws.client.bsm;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FieldType {

	@JsonProperty("string")
	STRING,

	@JsonProperty("long")
	LONG,

	@JsonProperty("double")
	DOUBLE,

	@JsonProperty("timestamp")
	TIMESTAMP,

	@JsonProperty("encrypted")
	ENCRYPTED,

	@JsonProperty("uri")
	URI,

	@JsonProperty("boolean")
	BOOLEAN,
}
