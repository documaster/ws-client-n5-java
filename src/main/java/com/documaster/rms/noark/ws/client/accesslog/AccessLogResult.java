package com.documaster.rms.noark.ws.client.accesslog;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessLogResult {

	private final String objectUUID;
	private final String objectType;
	private final Integer version;
	private final String userName;
	private final String userId;
	private final Date createdDate;

	@JsonCreator
	private AccessLogResult(
			@JsonProperty("objectUUID") String objectUUID,
			@JsonProperty("objectType") String objectType,
			@JsonProperty("version") Integer version,
			@JsonProperty("userName") String userName,
			@JsonProperty("userId") String userId,
			@JsonProperty("createdDate") Date createdDate) {

		this.objectUUID = objectUUID;
		this.objectType = objectType;
		this.version = version;
		this.userName = userName;
		this.userId = userId;
		this.createdDate = createdDate;
	}

	public String getObjectUUID() {

		return objectUUID;
	}

	public String getObjectType() {

		return objectType;
	}

	public Integer getVersion() {

		return version;
	}

	public String getUserName() {

		return userName;
	}

	public String getUserId() {

		return userId;
	}

	public Date getCreatedDate() {

		return createdDate;
	}
}
