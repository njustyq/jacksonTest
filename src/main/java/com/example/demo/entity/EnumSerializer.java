package com.example.demo.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import format.info.BonFormatInfo;

import java.io.IOException;
import java.util.Map;

/**
 * The json serializer for {@link EnumClassTojson}.
 */
public class EnumSerializer extends StdSerializer<EnumClassTojson> {
    private static final long serialVersionUID = 1L;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    protected EnumSerializer() {
        super(EnumClassTojson.class);
    }

    @Override
    public void serialize(
            EnumClassTojson typeInfo,
        JsonGenerator jsonGenerator,
        SerializerProvider serializerProvider
    ) throws IOException {
        String text = OBJECT_MAPPER.writeValueAsString(typeInfo);
        ObjectMapper mapper =
            new ObjectMapper();
        Map<String, Object> tmpMap = mapper.readValue(text, Map.class);
        jsonGenerator.writeObject(tmpMap);
    }

}
