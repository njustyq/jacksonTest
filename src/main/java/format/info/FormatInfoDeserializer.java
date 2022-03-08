package format.info;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * The json deserializer for {@link FormatInfo}.
 */
public class FormatInfoDeserializer extends StdDeserializer<FormatInfo> {
    private static final long serialVersionUID = 1L;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    protected FormatInfoDeserializer() {
        super(FormatInfo.class);
    }

    @Override
    public FormatInfo deserialize(
        JsonParser jsonParser,
        DeserializationContext deserializationContext
    ) throws IOException {
        com.fasterxml.jackson.databind.ObjectMapper mapper =
            new com.fasterxml.jackson.databind.ObjectMapper();
        String text = mapper.readTree(jsonParser).toString();
        return OBJECT_MAPPER.readValue(text, FormatInfo.class);
    }
}
