package com.documaster.rms.noark.ws.client.fulltextsearch;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.documaster.rms.noark.ws.client.Bean;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FullTextResponse implements Bean {

	private final List<FullTextResult> results;

	private final Long total;

	@JsonCreator
	private FullTextResponse(
			@JsonProperty("results") List<FullTextResult> results,
			@JsonProperty("total") Long total) {

		this.results = results.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
		this.total = total;
	}

	public List<FullTextResult> getResults() {

		return results;
	}

	public Long getTotal() {

		return total;
	}
}
