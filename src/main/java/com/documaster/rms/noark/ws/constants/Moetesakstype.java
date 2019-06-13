package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Moetesakstype extends NoarkEnum {

	public static final Moetesakstype POLITISK_SAK = new Moetesakstype("PS", "Politisk sak");
	public static final Moetesakstype DELEGERT_MOETESAK = new Moetesakstype("DS", "Delegert møtesak");
	public static final Moetesakstype REFERATSAK = new Moetesakstype("RS", "Referatsak");
	public static final Moetesakstype INTERPELLASJON = new Moetesakstype("FO", "Interpellasjon");
	public static final Moetesakstype UREGISTRERT_SAK = new Moetesakstype("U", "Uregistrert sak");

	public Moetesakstype(String code) {

		super(code);
	}

	public Moetesakstype(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Moetesakstype(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
