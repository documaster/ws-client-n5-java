package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlytStatus extends NoarkEnum {

	public static final FlytStatus GODKJENT = new FlytStatus("G", "Godkjent");
	public static final FlytStatus IKKE_GODKJENT = new FlytStatus("I", "Ikke godkjent");
	public static final FlytStatus SENDT_TILBAKE_TIL_SAKSBEHANDLER_MED_KOMMENTARER =
			new FlytStatus("S", "Sendt tilbake til saksbehandler med kommentarer");

	public FlytStatus(String code) {

		super(code);
	}

	public FlytStatus(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public FlytStatus(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
