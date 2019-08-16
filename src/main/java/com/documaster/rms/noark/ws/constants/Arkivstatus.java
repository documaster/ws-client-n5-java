package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Arkivstatus extends NoarkEnum {

	public static final Arkivstatus OPPRETTET = new Arkivstatus("O", "Opprettet");
	public static final Arkivstatus AVSLUTTET = new Arkivstatus("A", "Avsluttet");

	public Arkivstatus(String code) {

		super(code);
	}

	public Arkivstatus(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Arkivstatus(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
