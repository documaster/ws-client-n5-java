package com.documaster.rms.noark.ws.client.changelog;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.documaster.rms.noark.ws.client.Bean;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangeLogResponse implements Bean {

	private final List<ChangeLogResult> results;

	private final Integer total;

	@JsonCreator
	private ChangeLogResponse(
			@JsonProperty("results") List<ChangeLogResult> results,
			@JsonProperty("total") Integer total) {

		this.results = results.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
		this.total = total;
	}

	public List<ChangeLogResult> getResults() {

		return results;
	}

	public Integer getTotal() {

		return total;
	}
}
