package com.documaster.rms.noark.ws.client.bsm;

import java.util.List;

import com.documaster.rms.noark.ws.client.Bean;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BusinessSpecificMetadataInfo implements Bean {

	@JsonProperty("results")
	private final List<BsmGroupInfo> groups;

	@JsonCreator
	private BusinessSpecificMetadataInfo(@JsonProperty("results") List<BsmGroupInfo> groups) {

		this.groups = groups;
	}

	public List<BsmGroupInfo> getGroups() {

		return groups;
	}
}
