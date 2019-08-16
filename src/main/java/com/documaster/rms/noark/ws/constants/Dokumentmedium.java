package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Dokumentmedium extends NoarkEnum {

	public static final Dokumentmedium ELEKTRONISK_ARKIV = new Dokumentmedium("E", "Elektronisk arkiv");

	public Dokumentmedium(String code) {

		super(code);
	}

	public Dokumentmedium(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Dokumentmedium(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
