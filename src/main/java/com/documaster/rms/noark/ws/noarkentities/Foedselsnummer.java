package com.documaster.rms.noark.ws.noarkentities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Foedselsnummer extends PersonIdentifikator<Foedselsnummer> {

	private String foedselsnummer;

	public Foedselsnummer(String foedselsnummer) {

		this.foedselsnummer = foedselsnummer;
	}

	@JsonCreator
	private Foedselsnummer(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getFoedselsnummer() {

		return foedselsnummer;
	}

	public void setFoedselsnummer(String foedselsnummer) {

		this.foedselsnummer = foedselsnummer;
	}
}
