package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TilknyttetRegistreringSom extends NoarkEnum {

	public static final TilknyttetRegistreringSom HOVEDDOKUMENT = new TilknyttetRegistreringSom("H", "Hoveddokument");
	public static final TilknyttetRegistreringSom VEDLEGG = new TilknyttetRegistreringSom("V", "Vedlegg");

	public TilknyttetRegistreringSom(String code) {

		super(code);
	}

	public TilknyttetRegistreringSom(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public TilknyttetRegistreringSom(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
