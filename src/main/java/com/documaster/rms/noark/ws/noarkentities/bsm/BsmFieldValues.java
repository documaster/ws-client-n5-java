package com.documaster.rms.noark.ws.noarkentities.bsm;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BsmFieldValues {

	private final Set<Object> values;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String type;

	public BsmFieldValues() {

		this(new HashSet<>());
	}

	public BsmFieldValues(Set<Object> values) {

		this.values = values;
	}

	public Set<Object> getValues() {

		return values;
	}

	public String getType() {

		return type;
	}

	private void setType() {

		this.type = type;
	}
}
