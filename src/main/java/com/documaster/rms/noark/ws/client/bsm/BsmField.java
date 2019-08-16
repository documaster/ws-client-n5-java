package com.documaster.rms.noark.ws.client.bsm;

import java.util.Set;

import com.documaster.rms.noark.ws.client.Bean;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BsmField implements Bean {

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String fieldId;

	private String fieldName;

	private String fieldDescription;

	private FieldType fieldType;

	private Set<Object> fieldValues;

	@JsonCreator
	private BsmField() {

	}

	public BsmField(String fieldId, String fieldName, FieldType fieldType) {

		this.fieldId = fieldId;
		this.fieldName = fieldName;
		this.fieldType = fieldType;
	}

	public String getFieldId() {

		return fieldId;
	}

	public void setFieldId(String fieldId) {

		this.fieldId = fieldId;
	}

	public String getFieldName() {

		return fieldName;
	}

	public void setFieldName(String fieldName) {

		this.fieldName = fieldName;
	}

	public String getFieldDescription() {

		return fieldDescription;
	}

	public void setFieldDescription(String fieldDescription) {

		this.fieldDescription = fieldDescription;
	}

	public FieldType getFieldType() {

		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {

		this.fieldType = fieldType;
	}

	public Set<Object> getFieldValues() {

		return fieldValues;
	}

	public void setFieldValues(Set<Object> fieldValues) {

		this.fieldValues = fieldValues;
	}
}
