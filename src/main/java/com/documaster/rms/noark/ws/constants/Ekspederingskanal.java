package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ekspederingskanal extends NoarkEnum {

	public Ekspederingskanal(String code) {

		super(code);
	}

	public Ekspederingskanal(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Ekspederingskanal(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
