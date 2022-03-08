package format.info;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Map;

/**
 * The json serializer for {@link FormatInfo}.
 */
public class FormatInfoSerializer extends StdSerializer<FormatInfo> {
    private static final long serialVersionUID = 1L;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    protected FormatInfoSerializer() {
        super(FormatInfo.class);
    }

    @Override
    public void serialize(
        FormatInfo typeInfo,
        JsonGenerator jsonGenerator,
        SerializerProvider serializerProvider
    ) throws IOException {
        String text = OBJECT_MAPPER.writeValueAsString(typeInfo);
        com.fasterxml.jackson.databind.ObjectMapper mapper =
            new com.fasterxml.jackson.databind.ObjectMapper();
        Map<String, Object> tmpMap = mapper.readValue(text, Map.class);
        jsonGenerator.writeObject(tmpMap);
    }
}
