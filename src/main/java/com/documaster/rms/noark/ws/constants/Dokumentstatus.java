package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Dokumentstatus extends NoarkEnum {

	public static final Dokumentstatus DOKUMENTET_ER_UNDER_REDIGERING =
			new Dokumentstatus("B", "Dokumentet er under redigering");
	public static final Dokumentstatus DOKUMENTET_ER_FERDIGSTILT = new Dokumentstatus("F", "Dokumentet er ferdigstilt");

	public Dokumentstatus(String code) {

		super(code);
	}

	public Dokumentstatus(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Dokumentstatus(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
