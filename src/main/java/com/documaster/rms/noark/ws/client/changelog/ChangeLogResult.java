package com.documaster.rms.noark.ws.client.changelog;

import java.time.ZonedDateTime;
import java.util.Map;

import com.documaster.rms.noark.ws.serialization.ZonedDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ChangeLogResult {

	private final String id;
	private final String systemId;
	private final String type;
	private final String revisionId;
	private final String revisionType;
	@JsonDeserialize(using = ZonedDateTimeDeserializer.class)
	private final ZonedDateTime modifiedDate;
	private final String modifiedBy;
	private final String modifiedByUserId;
	private final String modifiedField;
	private final String modifiedFieldType;

	private final Map<String, Object> newValue;
	private final Map<String, Object> oldValue;
	private final Map<String, Object> removedValue;
	private final Map<String, Object> previousParent;
	private final Map<String, Object> currentParent;

	@JsonCreator
	private ChangeLogResult(
			@JsonProperty("id") String id,
			@JsonProperty("systemId") String systemId,
			@JsonProperty("type") String type,
			@JsonProperty("revisionId") String revisionId,
			@JsonProperty("revisionType") String revisionType,
			@JsonProperty("modifiedDate") ZonedDateTime modifiedDate,
			@JsonProperty("modifiedBy") String modifiedBy,
			@JsonProperty("modifiedByUserId") String modifiedByUserId,
			@JsonProperty("modifiedField") String modifiedField,
			@JsonProperty("modifiedFieldType") String modifiedFieldType,
			@JsonProperty("newValue") Map<String, Object> newValue,
			@JsonProperty("oldValue") Map<String, Object> oldValue,
			@JsonProperty("removedValue") Map<String, Object> removedValue,
			@JsonProperty("previousParent") Map<String, Object> previousParent,
			@JsonProperty("currentParent") Map<String, Object> currentParent) {

		this.id = id;
		this.systemId = systemId;
		this.type = type;
		this.revisionId = revisionId;
		this.revisionType = revisionType;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.modifiedByUserId = modifiedByUserId;
		this.modifiedField = modifiedField;
		this.modifiedFieldType = modifiedFieldType;
		this.newValue = newValue;
		this.oldValue = oldValue;
		this.removedValue = removedValue;
		this.previousParent = previousParent;
		this.currentParent = currentParent;
	}

	public String getId() {

		return id;
	}

	public String getSystemId() {

		return systemId;
	}

	public String getType() {

		return type;
	}

	public String getRevisionId() {

		return revisionId;
	}

	public String getRevisionType() {

		return revisionType;
	}

	public ZonedDateTime getModifiedDate() {

		return modifiedDate;
	}

	public String getModifiedBy() {

		return modifiedBy;
	}

	public String getModifiedByUserId() {

		return modifiedByUserId;
	}

	public String getModifiedField() {

		return modifiedField;
	}

	public String getModifiedFieldType() {

		return modifiedFieldType;
	}

	public Map<String, Object> getNewValue() {

		return newValue;
	}

	public Map<String, Object> getOldValue() {

		return oldValue;
	}

	public Map<String, Object> getRemovedValue() {

		return removedValue;
	}

	public Map<String, Object> getPreviousParent() {

		return previousParent;
	}

	public Map<String, Object> getCurrentParent() {

		return currentParent;
	}
}
