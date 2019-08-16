package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Korrespondanseparttype extends NoarkEnum {

	public static final Korrespondanseparttype AVSENDER = new Korrespondanseparttype("EA", "Avsender");
	public static final Korrespondanseparttype MOTTAKER = new Korrespondanseparttype("EM", "Mottaker");
	public static final Korrespondanseparttype KOPIMOTTAKER = new Korrespondanseparttype("EK", "Kopimottaker");
	public static final Korrespondanseparttype GRUPPEMOTTAKER = new Korrespondanseparttype("GM", "Gruppemottaker");
	public static final Korrespondanseparttype INTERN_AVSENDER = new Korrespondanseparttype("IA", "Intern avsender");
	public static final Korrespondanseparttype INTERN_MOTTAKER = new Korrespondanseparttype("IM", "Intern mottaker");
	public static final Korrespondanseparttype INTERN_KOPIMOTTAKER =
			new Korrespondanseparttype("IK", "Intern kopimottaker");

	public Korrespondanseparttype(String code) {

		super(code);
	}

	public Korrespondanseparttype(String code, String name) {

		super(code, name);
	}

	@JsonCreator
	public Korrespondanseparttype(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description) {

		super(code, name, description);
	}
}
