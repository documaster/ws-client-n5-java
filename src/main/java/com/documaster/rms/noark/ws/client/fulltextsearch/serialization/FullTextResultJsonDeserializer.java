package com.documaster.rms.noark.ws.client.fulltextsearch.serialization;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.documaster.rms.noark.ws.client.fulltextsearch.FullTextResult;
import com.documaster.rms.noark.ws.serialization.NoarkDeserializerException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FullTextResultJsonDeserializer extends JsonDeserializer<FullTextResult> {

	private static final String IDS_KEY_NAME = "ids";
	private static final String EXPAND_KEY_NAME = "expand";

	@Override
	public FullTextResult deserialize(
			JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, NoarkDeserializerException {

		if (jsonParser.currentToken() != JsonToken.START_OBJECT) {

			throw new NoarkDeserializerException(
					String.format("Unexpected JsonToken: expected an object but got %s", jsonParser.currentToken()));
		}

		ObjectNode jObject = jsonParser.readValueAsTree();

		if (!jObject.has(IDS_KEY_NAME)) {

			throw new NoarkDeserializerException(
					String.format("JSON object has no results ids key: expected key is %s", IDS_KEY_NAME));
		}

		if (!jObject.has(EXPAND_KEY_NAME)) {

			throw new NoarkDeserializerException(
					String.format("JSON object has no results expand key: expected key is %s", EXPAND_KEY_NAME));
		}

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<Map<String, List<String>>> idsTypeReference =
				new TypeReference<Map<String, List<String>>>() {

				};
		TypeReference<Map<String, List<Object>>> expandTypeReference =
				new TypeReference<Map<String, List<Object>>>() {

				};

		Map<String, List<String>> ids =
				mapper.convertValue(jObject.get(IDS_KEY_NAME), idsTypeReference);
		Map<String, List<Object>> expand =
				mapper.convertValue(jObject.get(EXPAND_KEY_NAME), expandTypeReference);

		return new FullTextResult(ids, expand);
	}
}
