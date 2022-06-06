package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Kassasjonsvedtak extends NoarkEnum {

	public static final Kassasjonsvedtak BEVARES = new Kassasjonsvedtak("B", "Bevares");
	public static final Kassasjonsvedtak KASSERES = new Kassasjonsvedtak("K", "Kasseres");
	public static final Kassasjonsvedtak VURDERES_SENERE = new Kassasjonsvedtak("V", "Vurderes senere");

	public Kassasjonsvedtak(String code) {

		super(code);
	}

	public Kassasjonsvedtak(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Kassasjonsvedtak(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
