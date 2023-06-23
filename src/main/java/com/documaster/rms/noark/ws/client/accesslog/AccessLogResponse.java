package com.documaster.rms.noark.ws.client.accesslog;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.documaster.rms.noark.ws.client.Bean;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessLogResponse implements Bean {

	private final List<AccessLogResult> results;

	private final boolean hasMore;

	@JsonCreator
	private AccessLogResponse(
			@JsonProperty("results") List<AccessLogResult> results,
			@JsonProperty("hasMore") boolean hasMore) {

		this.results = results.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
		this.hasMore = hasMore;
	}

	public List<AccessLogResult> getResults() {

		return results;
	}

	public boolean getHasMore() {

		return hasMore;
	}
}
