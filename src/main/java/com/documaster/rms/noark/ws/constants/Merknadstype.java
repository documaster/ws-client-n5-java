package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Merknadstype extends NoarkEnum {

	public static final Merknadstype MERKNAD = new Merknadstype("MER", "Merknad");
	public static final Merknadstype INTERN_MERKNAD = new Merknadstype("IMER", "Intern Merknad");

	public Merknadstype(String code) {

		super(code);
	}

	public Merknadstype(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Merknadstype(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
