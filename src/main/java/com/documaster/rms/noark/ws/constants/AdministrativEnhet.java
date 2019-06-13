package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AdministrativEnhet extends NoarkEnum {

	public AdministrativEnhet(String code) {

		super(code);
	}

	public AdministrativEnhet(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public AdministrativEnhet(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
