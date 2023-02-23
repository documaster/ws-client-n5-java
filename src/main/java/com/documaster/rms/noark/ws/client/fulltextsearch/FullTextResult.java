package com.documaster.rms.noark.ws.client.fulltextsearch;

import java.util.List;
import java.util.Map;

import com.documaster.rms.noark.ws.client.fulltextsearch.serialization.FullTextResultJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = FullTextResultJsonDeserializer.class)
public class FullTextResult {

	private final Map<String, List<String>> ids;
	private final Map<String, List<Object>> expand;

	public FullTextResult(
			Map<String, List<String>> ids,
			Map<String, List<Object>> expand) {

		this.ids = ids;
		this.expand = expand;
	}

	public Map<String, List<String>> getIds() {

		return ids;
	}

	public Map<String, List<Object>> getExpand() {

		return expand;
	}
}
