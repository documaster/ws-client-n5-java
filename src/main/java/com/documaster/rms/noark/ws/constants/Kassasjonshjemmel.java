package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Kassasjonshjemmel extends NoarkEnum {

	public Kassasjonshjemmel(String code) {

		super(code);
	}

	public Kassasjonshjemmel(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Kassasjonshjemmel(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
