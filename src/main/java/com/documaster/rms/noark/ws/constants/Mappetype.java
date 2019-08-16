package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Mappetype extends NoarkEnum {

	public Mappetype(String code) {

		super(code);
	}

	public Mappetype(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Mappetype(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
