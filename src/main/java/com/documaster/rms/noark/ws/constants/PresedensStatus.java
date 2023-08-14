package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PresedensStatus extends NoarkEnum {

	public static final PresedensStatus FORELDET = new PresedensStatus("F", "Foreldet");
	public static final PresedensStatus GJELDENDE = new PresedensStatus("G", "Gjeldende");

	public PresedensStatus(String code) {

		super(code);
	}

	public PresedensStatus(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public PresedensStatus(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
