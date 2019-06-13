package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Journalstatus extends NoarkEnum {

	public static final Journalstatus JOURNALFOERT = new Journalstatus("J", "Journalført");
	public static final Journalstatus FERDIGSTILT_FRA_SAKSBEHANDLER =
			new Journalstatus("F", "Ferdigstilt fra saksbehandler");
	public static final Journalstatus GODKJENT_AV_LEDER = new Journalstatus("G", "Godkjent av leder");
	public static final Journalstatus EKSPEDERT = new Journalstatus("E", "Ekspedert");
	public static final Journalstatus ARKIVERT = new Journalstatus("A", "Arkivert");
	public static final Journalstatus UTGAAR = new Journalstatus("U", "Utgår");
	public static final Journalstatus MIDLERTIDIG_REGISTRERING_AV_INNKOMMET_DOKUMENT =
			new Journalstatus("M", "Midlertidig registrering av innkommet dokument");
	public static final Journalstatus SAKSBEHANDLER_HAR_REGISTRERT_INNKOMMET_DOKUMENT =
			new Journalstatus("S", "Saksbehandler har registrert innkommet dokument");
	public static final Journalstatus RESERVERT_DOKUMENT = new Journalstatus("R", "Reservert dokument");

	public Journalstatus(String code) {

		super(code);
	}

	public Journalstatus(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Journalstatus(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
