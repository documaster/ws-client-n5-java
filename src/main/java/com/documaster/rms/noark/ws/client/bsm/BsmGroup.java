package com.documaster.rms.noark.ws.client.bsm;

import com.documaster.rms.noark.ws.client.Bean;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BsmGroup implements Bean {

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String groupId;

	private String groupName;

	private String groupDescription;

	@JsonCreator
	BsmGroup() {

	}

	public BsmGroup(String groupId, String groupName) {

		this.groupId = groupId;
		this.groupName = groupName;
	}

	public String getGroupId() {

		return groupId;
	}

	public void setGroupId(String groupId) {

		this.groupId = groupId;
	}

	public String getGroupName() {

		return groupName;
	}

	public void setGroupName(String groupName) {

		this.groupName = groupName;
	}

	public String getGroupDescription() {

		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {

		this.groupDescription = groupDescription;
	}
}
