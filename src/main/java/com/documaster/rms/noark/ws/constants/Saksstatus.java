package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Saksstatus extends NoarkEnum {

	public static final Saksstatus UNDER_BEHANDLING = new Saksstatus("B", "Under behandling");
	public static final Saksstatus AVSLUTTET = new Saksstatus("A", "Avsluttet");
	public static final Saksstatus UTGAAR = new Saksstatus("U", "Utgår");
	public static final Saksstatus OPPRETTET_AV_SAKSBEHANDLER = new Saksstatus("R", "Opprettet av saksbehandler");
	public static final Saksstatus UNNTATT_PROSESSTYRING = new Saksstatus("P", "Unntatt prosesstyring");
	public static final Saksstatus AVSLUTTET_AV_SAKSBEHANDLER = new Saksstatus("S", "Avsluttet av saksbehandler");
	public static final Saksstatus FERDIG_FRA_SAKSBEHANDLER = new Saksstatus("F", "Ferdig fra saksbehandler");

	public Saksstatus(String code) {

		super(code);
	}

	public Saksstatus(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Saksstatus(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
