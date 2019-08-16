package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Arkivdelstatus extends NoarkEnum {

	public static final Arkivdelstatus AKTIV_PERIODE = new Arkivdelstatus("A", "Aktiv periode");
	public static final Arkivdelstatus OVERLAPPINGSPERIODE = new Arkivdelstatus("O", "Overlappingsperiode");
	public static final Arkivdelstatus AVSLUTTET_PERIODE = new Arkivdelstatus("P", "Avsluttet periode");
	public static final Arkivdelstatus UAKTUELLE_MAPPER = new Arkivdelstatus("U", "Uaktuelle mapper");

	public Arkivdelstatus(String code) {

		super(code);
	}

	public Arkivdelstatus(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Arkivdelstatus(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
