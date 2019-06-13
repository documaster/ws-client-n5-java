package com.documaster.rms.noark.ws.serialization;

import java.io.IOException;

import com.documaster.rms.noark.ws.constants.NoarkEnum;
import com.documaster.rms.noark.ws.serialization.NoarkDeserializerException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class NoarkEnumJsonSerializer extends JsonSerializer<NoarkEnum> {

	@Override
	public void serialize(
			NoarkEnum noarkEnum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, NoarkDeserializerException {

		jsonGenerator.writeString(noarkEnum.getCode());
	}
}
