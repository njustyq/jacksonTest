package format.info;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

/**
 * The type information for data types.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(name = "string", value = StringTypeInfo.class),
	@JsonSubTypes.Type(name = "int", value = IntTypeInfo.class)
})
public interface TypeInfo extends Serializable {
}
