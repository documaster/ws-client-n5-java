package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PresedensHjemmel extends NoarkEnum {

	public PresedensHjemmel(String code) {

		super(code);
	}

	public PresedensHjemmel(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public PresedensHjemmel(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
