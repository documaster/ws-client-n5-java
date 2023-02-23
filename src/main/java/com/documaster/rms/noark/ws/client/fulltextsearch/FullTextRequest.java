package com.documaster.rms.noark.ws.client.fulltextsearch;

import java.util.LinkedHashSet;
import java.util.Set;

import com.documaster.rms.noark.ws.client.Bean;

public class FullTextRequest implements Bean {

	private Doctype doctype;

	private String query;

	private boolean publicUse = true;

	private Set<String> expand = new LinkedHashSet<>();

	private Integer offset;

	private Integer limit;

	public Doctype getDoctype() {

		return doctype;
	}

	public void setDoctype(Doctype doctype) {

		this.doctype = doctype;
	}

	public String getQuery() {

		return query;
	}

	public void setQuery(String query) {

		this.query = query;
	}

	public boolean isPublicUse() {

		return publicUse;
	}

	public void setPublicUse(boolean publicUse) {

		this.publicUse = publicUse;
	}

	public Set<String> getExpand() {

		return expand;
	}

	public void setExpand(Set<String> expand) {

		this.expand = expand;
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
