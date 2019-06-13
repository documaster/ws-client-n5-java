package com.documaster.rms.noark.ws.client.codelist;

import java.util.List;

import com.documaster.rms.noark.ws.client.codelist.serialization.NoarkCodeListJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = NoarkCodeListJsonDeserializer.class)
public class CodeList {

	private final String type;
	private final String field;
	private final List<CodeValue> values;

	public CodeList(String type, String field, List<CodeValue> values) {

		this.type = type;
		this.field = field;
		this.values = values;
	}

	public String getType() {

		return type;
	}

	public String getField() {

		return field;
	}

	public List<CodeValue> getValues() {

		return values;
	}
}
