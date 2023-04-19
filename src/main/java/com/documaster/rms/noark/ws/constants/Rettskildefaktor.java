package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rettskildefaktor extends NoarkEnum {

	public Rettskildefaktor(String code) {

		super(code);
	}

	public Rettskildefaktor(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Rettskildefaktor(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
