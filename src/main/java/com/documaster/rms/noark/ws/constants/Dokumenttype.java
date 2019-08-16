package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Dokumenttype extends NoarkEnum {

	public Dokumenttype(String code) {

		super(code);
	}

	public Dokumenttype(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Dokumenttype(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
