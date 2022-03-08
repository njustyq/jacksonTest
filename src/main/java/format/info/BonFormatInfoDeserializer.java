package format.info;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * The json deserializer for {@link BonFormatInfo}.
 */
public class BonFormatInfoDeserializer extends StdDeserializer<BonFormatInfo> {
    private static final long serialVersionUID = 1L;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    protected BonFormatInfoDeserializer() {
        super(BonFormatInfo.class);
    }

    @Override
    public BonFormatInfo deserialize(
        JsonParser jsonParser,
        DeserializationContext deserializationContext
    ) throws IOException {
        ObjectMapper mapper =
            new ObjectMapper();
        String text = mapper.readTree(jsonParser).toString();
        return OBJECT_MAPPER.readValue(text, BonFormatInfo.class);
    }
}
