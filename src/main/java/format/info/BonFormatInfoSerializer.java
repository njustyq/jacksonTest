package format.info;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Map;

/**
 * The json serializer for {@link BonFormatInfo}.
 */
public class BonFormatInfoSerializer extends StdSerializer<BonFormatInfo> {
    private static final long serialVersionUID = 1L;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    protected BonFormatInfoSerializer() {
        super(BonFormatInfo.class);
    }

    @Override
    public void serialize(
        BonFormatInfo typeInfo,
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
