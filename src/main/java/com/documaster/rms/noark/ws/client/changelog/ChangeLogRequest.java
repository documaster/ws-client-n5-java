package com.documaster.rms.noark.ws.client.changelog;

import com.documaster.rms.noark.ws.client.Bean;

public class ChangeLogRequest implements Bean {

	private String type;

	private String id;

	private boolean includeChildChanges = true;

	private boolean nestChildChanges = true;

	private Integer offset = 0;

	private Integer limit = 10;

	public String getType() {

		return type;
	}

	public void setType(String type) {

		this.type = type;
	}

	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}

	public boolean getIncludeChildChanges() {

		return includeChildChanges;
	}

	public void setIncludeChildChanges(boolean includeChildChanges) {

		this.includeChildChanges = includeChildChanges;
	}

	public boolean getNestChildChanges() {

		return nestChildChanges;
	}

	public void setNestChildChanges(boolean nestChildChanges) {

		this.nestChildChanges = nestChildChanges;
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
