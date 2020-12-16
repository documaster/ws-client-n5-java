package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Lovreferanse extends NoarkEnum {

	public Lovreferanse(String code) {

		super(code);
	}

	public Lovreferanse(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Lovreferanse(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
