package com.documaster.rms.noark.ws.serialization;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

	@Override
	public ZonedDateTime deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		String value = jp.readValueAs(String.class);

		if (value == null) {

			return null;

		} else {

			return ZonedDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}
	}
}
