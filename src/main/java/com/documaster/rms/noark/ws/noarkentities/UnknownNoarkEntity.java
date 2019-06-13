package com.documaster.rms.noark.ws.noarkentities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UnknownNoarkEntity implements NoarkEntity {

	private final String id;
	private final String version;

	@JsonCreator
	protected UnknownNoarkEntity(
			@JsonProperty("id") String id,
			@JsonProperty("version") String version) {

		this.id = id;
		this.version = version;
	}

	@Override
	public String getId() {

		return id;
	}

	@Override
	public String getVersion() {

		return version;
	}
}
