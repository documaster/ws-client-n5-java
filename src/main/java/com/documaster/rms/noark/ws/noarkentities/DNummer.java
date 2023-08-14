package com.documaster.rms.noark.ws.noarkentities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DNummer extends PersonIdentifikator<DNummer> {

	private String dnummer;

	public DNummer(String dnummer) {

		this.dnummer = dnummer;
	}

	@JsonCreator
	private DNummer(
			@JsonProperty("id") String id,
			@JsonProperty("uuid") String uuid,
			@JsonProperty("version") String version) {

		super(id, uuid, version);
	}

	public String getDnummer() {

		return dnummer;
	}

	public void setDnummer(String dnummer) {

		this.dnummer = dnummer;
	}
}
