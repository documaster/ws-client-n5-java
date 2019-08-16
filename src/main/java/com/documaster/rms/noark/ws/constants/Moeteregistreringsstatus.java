package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Moeteregistreringsstatus extends NoarkEnum {

	public Moeteregistreringsstatus(String code) {

		super(code);
	}

	public Moeteregistreringsstatus(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Moeteregistreringsstatus(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
