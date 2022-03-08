package com.example.demo.entity;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import format.info.FormatInfo;

import java.io.IOException;

/**
 * The json deserializer for {@link FormatInfo}.
 */
public class EnumDeserializer extends StdDeserializer<EnumClassTojson> {
    private static final long serialVersionUID = 1L;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    protected EnumDeserializer() {
        super(FormatInfo.class);
    }

    @Override
    public EnumClassTojson deserialize(
        JsonParser jsonParser,
        DeserializationContext deserializationContext
    ) throws IOException {
        ObjectMapper mapper =
            new ObjectMapper();
        String text = mapper.readTree(jsonParser).toString();
        return OBJECT_MAPPER.readValue(text, EnumClassTojson.class);
    }
}
