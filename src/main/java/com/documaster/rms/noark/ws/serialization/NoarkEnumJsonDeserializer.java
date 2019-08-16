package com.documaster.rms.noark.ws.serialization;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.documaster.rms.noark.ws.constants.NoarkEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class NoarkEnumJsonDeserializer extends JsonDeserializer<NoarkEnum> {

	@Override
	public NoarkEnum deserialize(
			JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, NoarkDeserializerException {

		if (jsonParser.currentToken() != JsonToken.VALUE_STRING) {

			throw new NoarkDeserializerException(
					String.format("Unexpected JsonToken: expected a string but got %s", jsonParser.currentToken()));
		}

		String code = jsonParser.readValueAs(String.class);
		String noarkEnumType = jsonParser.getCurrentName();

		if (!NoarkObjectMappings.INSTANCE.getCodeValueMappings().containsKey(noarkEnumType)) {

			// Unsupported CodeValue
			return null;
		}

		try {

			return createFromType(noarkEnumType, code);

		} catch (Exception e) {

			throw new NoarkDeserializerException(
					String.format("Failed to create a NoarkEnum from property %s", noarkEnumType), e);
		}
	}

	private NoarkEnum createFromType(String type, String code)
			throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

		Constructor<? extends NoarkEnum> constructor = NoarkObjectMappings.INSTANCE.getCodeValueMappings()
				.get(type).asSubclass(NoarkEnum.class)
				.getConstructor(String.class);

		return constructor.newInstance(code);
	}
}
