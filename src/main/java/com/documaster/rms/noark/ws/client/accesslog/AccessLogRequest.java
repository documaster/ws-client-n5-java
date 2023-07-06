package com.documaster.rms.noark.ws.client.accesslog;

import java.util.Set;

import com.documaster.rms.noark.ws.client.Bean;

public class AccessLogRequest implements Bean {

	private String objectType;

	private Set<String> objectUUIDs;

	private Integer offset = 0;

	private Integer limit = 10;

	public String getObjectType() {

		return objectType;
	}

	public void setObjectType(String objectType) {

		this.objectType = objectType;
	}

	public Set<String> getObjectUUIDs() {

		return objectUUIDs;
	}

	public void setObjectUUIDs(Set<String> objectUUIDs) {

		this.objectUUIDs = objectUUIDs;
	}

	public Integer getOffset() {

		return offset;
	}

	public void setOffset(Integer offset) {

		this.offset = offset;
	}

	public Integer getLimit() {

		return limit;
	}

	public void setLimit(Integer limit) {

		this.limit = limit;
	}
}
