package com.documaster.rms.noark.ws.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Skjerming extends NoarkEnum {

	private String authority;

	public Skjerming(String code) {

		this(code, null, null, null);
	}

	public Skjerming(String code, String name) {

		this(code, name, null, null);
	}

	public Skjerming(String code, String name, String description) {

		this(code, name, description, null);
	}

	@JsonCreator
	public Skjerming(
			@JsonProperty("code") String code,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description,
			@JsonProperty("authority") String authority) {

		super(code, name, description);

		this.authority = authority;
	}

	public String getAuthority() {

		return authority;
	}

	public void setAuthority(String authority) {

		this.authority = authority;
	}
}
