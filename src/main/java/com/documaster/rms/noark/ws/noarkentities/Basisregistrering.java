package com.documaster.rms.noark.ws.noarkentities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Basisregistrering extends RegistreringBase<Basisregistrering> {

	public Basisregistrering(String tittel) {

		setTittel(tittel);
	}

	@JsonCreator
	private Basisregistrering(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}
}
