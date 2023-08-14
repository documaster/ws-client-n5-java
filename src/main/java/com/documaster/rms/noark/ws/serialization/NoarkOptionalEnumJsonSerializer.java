package com.documaster.rms.noark.ws.serialization;

import java.io.IOException;
import java.util.Optional;

import com.documaster.rms.noark.ws.constants.NoarkEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class NoarkOptionalEnumJsonSerializer extends JsonSerializer<Optional<NoarkEnum>> {

	@Override
	public void serialize(
			Optional<NoarkEnum> noarkEnum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		jsonGenerator.writeObject(noarkEnum.isPresent() ? noarkEnum.get().getCode() : Optional.empty());
	}
}
