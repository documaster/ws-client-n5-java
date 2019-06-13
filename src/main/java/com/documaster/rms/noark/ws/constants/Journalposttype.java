package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Journalposttype extends NoarkEnum {

	public static final Journalposttype INNGAAENDE_DOKUMENT = new Journalposttype("I", "Inngående dokument");
	public static final Journalposttype UTGAAENDE_DOKUMENT = new Journalposttype("U", "Utgående dokument");
	public static final Journalposttype ORGANINTERNT_DOKUMENT_FOR_OPPFOELGING =
			new Journalposttype("N", "Organinternt dokument for oppfølging");
	public static final Journalposttype ORGANINTERNT_DOKUMENT_UTEN_OPPFOELGING =
			new Journalposttype("X", "Organinternt dokument uten oppfølging");
	public static final Journalposttype SAKSFRAMLEGG = new Journalposttype("S", "Saksframlegg");

	public Journalposttype(String code) {

		super(code);
	}

	public Journalposttype(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Journalposttype(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
