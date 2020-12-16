package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Plantype extends NoarkEnum {

	public Plantype(String code) {

		super(code);
	}

	public Plantype(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Plantype(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
