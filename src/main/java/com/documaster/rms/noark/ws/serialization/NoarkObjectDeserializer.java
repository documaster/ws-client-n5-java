package com.documaster.rms.noark.ws.serialization;

import java.io.IOException;

import com.documaster.rms.noark.ws.StringUtils;
import com.documaster.rms.noark.ws.client.ResponseObject;
import com.documaster.rms.noark.ws.noarkentities.NoarkEntity;
import com.documaster.rms.noark.ws.noarkentities.UnknownNoarkEntity;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class NoarkObjectDeserializer extends JsonDeserializer<ResponseObject> {

	private static final String TYPE_KEY_NAME = "type";
	private static final String OBJECT_KEY_NAME = "fields";
	private static final String LINKS_KEY_NAME = "links";
	private static final String ID_KEY_NAME = "id";
	private static final String VERSION_KEY_NAME = "version";

	@Override
	public ResponseObject deserialize(
			JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, NoarkDeserializerException {

		if (jsonParser.currentToken() != JsonToken.START_OBJECT) {

			throw new NoarkDeserializerException(
					String.format("Unexpected JsonToken: expected an object but got %s", jsonParser.currentToken()));
		}

		ObjectNode jObject = jsonParser.readValueAsTree();

		if (!jObject.has(TYPE_KEY_NAME) || StringUtils.isBlank(jObject.get(TYPE_KEY_NAME).textValue())) {

			throw new NoarkDeserializerException(
					String.format("JSON object has no Noark type information: expected key is %s", TYPE_KEY_NAME));
		}

		if (!jObject.has(ID_KEY_NAME) || StringUtils.isBlank(jObject.get(ID_KEY_NAME).textValue())) {

			throw new NoarkDeserializerException(
					String.format("JSON object has no id key: expected key is %s", ID_KEY_NAME));
		}

		if (!jObject.has(VERSION_KEY_NAME) || StringUtils.isBlank(jObject.get(VERSION_KEY_NAME).textValue())) {

			throw new NoarkDeserializerException(
					String.format("JSON object has no version key: expected key is %s", VERSION_KEY_NAME));
		}

		if (!jObject.has(OBJECT_KEY_NAME)) {

			throw new NoarkDeserializerException(
					String.format("JSON object has no fields key: expected key is %s", OBJECT_KEY_NAME));
		}

		if (!jObject.has(LINKS_KEY_NAME)) {

			throw new NoarkDeserializerException(
					String.format("JSON object has no links key: expected key is %s", LINKS_KEY_NAME));
		}

		String rmsObjectType = jObject.get(TYPE_KEY_NAME).textValue();
		Class<? extends NoarkEntity> noarkClass = NoarkObjectMappings.INSTANCE.getTypeMappings().get(rmsObjectType);

		if (noarkClass == null) {

			// Unsupported NoarkEntity
			noarkClass = UnknownNoarkEntity.class;
		}

		try {

			ObjectNode noarkObject = (ObjectNode) jObject.get(OBJECT_KEY_NAME);
			noarkObject.put(ID_KEY_NAME, jObject.get(ID_KEY_NAME).textValue());
			noarkObject.put(VERSION_KEY_NAME, jObject.get(VERSION_KEY_NAME).textValue());
			noarkObject.set(LINKS_KEY_NAME, jObject.get(LINKS_KEY_NAME));

			ObjectReader reader = CustomObjectMapper.INSTANCE.getMapper().readerFor(noarkClass);

			return new ResponseObject(reader.readValue(noarkObject));

		} catch (Exception e) {

			throw new NoarkDeserializerException(
					String.format("Failed to create an NoarkEntity of type %s from %s", rmsObjectType,
							jObject.get(OBJECT_KEY_NAME)), e);
		}
	}
}
