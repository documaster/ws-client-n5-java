package com.documaster.rms.noark.ws.client.codelist;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.documaster.rms.noark.ws.client.Bean;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CodeListResponse implements Bean {

	private final List<CodeList> results;

	@JsonCreator
	private CodeListResponse(@JsonProperty("results") List<CodeList> results) {

		this.results = results.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}

	public List<CodeList> getResults() {

		return results;
	}
}
