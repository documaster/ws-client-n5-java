package com.documaster.rms.noark.ws.client.fulltextsearch;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Doctype {

	ARKIVDEL("Arkivdel"),
	KORRESPONDANSEPART("Korrespondansepart"),
	MAPPE("Mappe"),
	REGISTRERING("Registrering"),
	TEKST("Tekst");

	private final String value;

	private Doctype(String value) {

		this.value = value;
	}

	@JsonValue
	public String getValue() {

		return value;
	}
}
