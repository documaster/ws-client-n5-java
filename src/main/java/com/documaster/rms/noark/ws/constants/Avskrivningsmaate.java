package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Avskrivningsmaate extends NoarkEnum {

	public static final Avskrivningsmaate TATT_TIL_ETTERRETNING = new Avskrivningsmaate("TE", "Tatt til etterretning");
	public static final Avskrivningsmaate BESVART_MED_BREV = new Avskrivningsmaate("BU", "Besvart med brev");
	public static final Avskrivningsmaate BESVART_MED_E_POST = new Avskrivningsmaate("BE", "Besvart med e-post");
	public static final Avskrivningsmaate TATT_TIL_ORIENTERING = new Avskrivningsmaate("TO", "Tatt til orientering");
	public static final Avskrivningsmaate BESVART_PA_TELEFON = new Avskrivningsmaate("TLF", "Besvart på telefon");
	public static final Avskrivningsmaate SAK_AVSLUTTET = new Avskrivningsmaate("SA", "Sak avsluttet");

	public Avskrivningsmaate(String code) {

		super(code);
	}

	public Avskrivningsmaate(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Avskrivningsmaate(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
