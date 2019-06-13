package com.documaster.rms.noark.ws.client.codelist.serialization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.documaster.rms.noark.ws.StringUtils;
import com.documaster.rms.noark.ws.client.codelist.CodeList;
import com.documaster.rms.noark.ws.client.codelist.CodeValue;
import com.documaster.rms.noark.ws.noarkentities.NoarkEntity;
import com.documaster.rms.noark.ws.serialization.CustomObjectMapper;
import com.documaster.rms.noark.ws.serialization.NoarkDeserializerException;
import com.documaster.rms.noark.ws.serialization.NoarkObjectMappings;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class NoarkCodeListJsonDeserializer extends JsonDeserializer<CodeList> {

	private static final String TYPE_KEY_NAME = "type";
	private static final String FIELD_KEY_NAME = "field";
	private static final String VALUES_KEY_NAME = "values";

	@Override
	public CodeList deserialize(
			JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, NoarkDeserializerException {

		if (jsonParser.currentToken() != JsonToken.START_OBJECT) {

			throw new NoarkDeserializerException(
					String.format("Unexpected JsonToken: expected an object but got %s", jsonParser.currentToken()));
		}

		ObjectNode jObject = jsonParser.readValueAsTree();

		if (!jObject.has(TYPE_KEY_NAME) || StringUtils.isBlank(jObject.get(TYPE_KEY_NAME).textValue())) {

			throw new NoarkDeserializerException(
					String.format("JSON object has no Code List type key: expected key is %s", TYPE_KEY_NAME));
		}

		if (!jObject.has(FIELD_KEY_NAME) || StringUtils.isBlank(jObject.get(FIELD_KEY_NAME).textValue())) {

			throw new NoarkDeserializerException(
					String.format("JSON object has no Code List field key: expected key is %s", FIELD_KEY_NAME));
		}

		if (!jObject.has(VALUES_KEY_NAME)) {

			throw new NoarkDeserializerException(
					String.format("JSON object has no Code List values key: expected key is %s", VALUES_KEY_NAME));
		}

		String rmsObjectType = jObject.get(TYPE_KEY_NAME).textValue();
		Class<? extends NoarkEntity> noarkType = NoarkObjectMappings.INSTANCE.getTypeMappings().get(rmsObjectType);

		if (noarkType == null) {

			// Unsupported NoarkEntity
			return null;
		}

		String rmsObjectCodeListField = jObject.get(FIELD_KEY_NAME).textValue();
		Set<String> typeCodeValues = NoarkObjectMappings.INSTANCE.getTypeCodeValueMappings().get(rmsObjectType);

		if (typeCodeValues == null || !typeCodeValues.contains(rmsObjectCodeListField)) {

			// Unsupported CodeValue in the NoarkEntity
			return null;
		}

		Class<? extends CodeValue> codeListType =
				NoarkObjectMappings.INSTANCE.getCodeValueMappings().get(rmsObjectCodeListField);

		if (codeListType == null) {

			// Unsupported CodeValue
			return null;
		}

		ObjectReader reader = CustomObjectMapper.INSTANCE.getMapper().readerFor(codeListType);

		List<CodeValue> codeValues = new ArrayList<>();
		Iterator<JsonNode> codeValueJsonIterator = jObject.get(VALUES_KEY_NAME).elements();

		while (codeValueJsonIterator.hasNext()) {

			codeValues.add(reader.readValue(codeValueJsonIterator.next()));
		}

		return new CodeList(rmsObjectType, rmsObjectCodeListField, codeValues);
	}
}
