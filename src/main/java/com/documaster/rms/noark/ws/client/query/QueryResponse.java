package com.documaster.rms.noark.ws.client.query;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.documaster.rms.noark.ws.client.Bean;
import com.documaster.rms.noark.ws.client.ResponseObject;
import com.documaster.rms.noark.ws.noarkentities.NoarkEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QueryResponse<TEntity extends NoarkEntity> implements Bean {

	private boolean hasMore;

	@JsonProperty
	private List<ResponseObject> results;

	public boolean getHasMore() {

		return hasMore;
	}

	@JsonIgnore
	public Collection<TEntity> getResults() {

		if (results == null) {

			return null;
		}

		return results.stream()
				.map(o -> (TEntity) o.getEntity())
				.collect(Collectors.toCollection(LinkedList::new));
	}
}
