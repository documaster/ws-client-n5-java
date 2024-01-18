package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Variantformat extends NoarkEnum {

	public static final Variantformat PRODUKSJONSFORMAT = new Variantformat("P", "Produksjonsformat");
	public static final Variantformat ARKIVFORMAT = new Variantformat("A", "Arkivformat");
	public static final Variantformat OFFENTLIG = new Variantformat("O", "Offentlig");

	public Variantformat(String code) {

		super(code);
	}

	public Variantformat(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Variantformat(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
