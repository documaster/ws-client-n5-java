package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Planstatus extends NoarkEnum {

	public Planstatus(String code) {

		super(code);
	}

	public Planstatus(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Planstatus(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
