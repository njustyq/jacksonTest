package format.info;


import com.example.demo.entity.EnumClassTojson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 脏字过滤包体数据类型
 * Created by lupingzhao on 2015/9/8.
 */
public enum BonType {

    BYTE_TYPE(0x01), INT32_TYPE(0x02), UINT32_TYPE(0x03), INT64_TYPE(0x04), UINT64_TYPE(0x05), DOUBLE_TYPE(0x06),
    STRING_TYPE(0x07), BINARY_TYPE(0x08), OBJECT_TYPE(0x09), ARRAY_TYPE(0x10), NIL_TYPE(100), UNKOWN_TYPE(0xFF);

    private static final Logger LOG = LoggerFactory.getLogger(BonType.class);

    private byte value = 0;

    BonType(int value) {
        this.value = (byte) value;
    }

    public byte value() {
        return value;
    }

    public static BonType valueOf(byte value) {
        switch (value) {
            case 0x01:
                return BYTE_TYPE;
            case 0x02:
                return INT32_TYPE;
            case 0x03:
                return UINT32_TYPE;
            case 0x04:
                return INT64_TYPE;
            case 0x05:
                return UINT64_TYPE;
            case 0x06:
                return DOUBLE_TYPE;
            case 0x07:
                return STRING_TYPE;
            case 0x08:
                return BINARY_TYPE;
            case 0x09:
                return OBJECT_TYPE;
            case 0x10:
                return ARRAY_TYPE;
            case 100:
                return NIL_TYPE;
            default:
                LOG.warn("Unrecognized type {}", value);
                return UNKOWN_TYPE;
        }
    }

    public static BonType fromString(String value) {
        switch (value.toUpperCase()) {
            case "BYTE":
                return BYTE_TYPE;
            case "INT":
            case "INT32":
                return INT32_TYPE;
            case "UINT32":
                return UINT32_TYPE;
            case "INT64":
            case "LONG":
            case "BIGINT":
                return INT64_TYPE;
            case "UINT64":
                return UINT64_TYPE;
            case "DOUBLE":
                return DOUBLE_TYPE;
            case "STRING":
                return STRING_TYPE;
            case "BINARY":
                return BINARY_TYPE;
            case "OBJECT":
                return OBJECT_TYPE;
            case "ARRAY":
                return ARRAY_TYPE;
            case "NIL":
                return NIL_TYPE;
            default:
                LOG.warn("Unrecognized type {}", value);
                return UNKOWN_TYPE;
        }
    }

    public static Class<?> toClass(BonType bonType) {
        switch (bonType) {
            case BYTE_TYPE:
                return Byte.class;
            case INT32_TYPE:
                return Integer.class;
            case INT64_TYPE:
            case UINT32_TYPE: // promotes uint32 to long
                return Long.class;
            case UINT64_TYPE: // promotes uint64 to BigDecimal
                return BigDecimal.class;
            case DOUBLE_TYPE:
                return Double.class;
            case STRING_TYPE:
                return String.class;
            case BINARY_TYPE:
                return byte[].class;
            default:
                return Object.class;
        }
    }

//	public static FormatInfo toFormatInfo(BonType bonType) {
//		switch (bonType) {
//			case BYTE_TYPE:
//				return ByteFormatInfo.INSTANCE;
//			case INT32_TYPE:
//				return IntFormatInfo.INSTANCE;
//			case INT64_TYPE:
//			case UINT32_TYPE:
//				return LongFormatInfo.INSTANCE;
//			case UINT64_TYPE:
//				return DecimalFormatInfo.INSTANCE;
//			case DOUBLE_TYPE:
//				return DoubleFormatInfo.INSTANCE;
//			case STRING_TYPE:
//				return StringFormatInfo.INSTANCE;
//			case BINARY_TYPE:
//				return new ArrayFormatInfo(ByteFormatInfo.INSTANCE);
//			default:
//				return null;
//		}
//	}
//	public static BonType fromFormatInfo(FormatInfo formatInfo) {
//    	if (formatInfo instanceof ByteFormatInfo){
//    		return BYTE_TYPE;
//		}
//    	else if (formatInfo instanceof IntFormatInfo){
//			return INT32_TYPE;
//		}
//    	else if (formatInfo instanceof LongFormatInfo){
//			return INT64_TYPE;
//		}
//    	else if (formatInfo instanceof DecimalFormatInfo){
//    		return UINT64_TYPE;
//		}
//    	else if (formatInfo instanceof DoubleFormatInfo){
//    		return DOUBLE_TYPE;
//		}
//    	else if (formatInfo instanceof StringFormatInfo){
//    		return STRING_TYPE;
//		}
//    	else if (formatInfo instanceof ArrayFormatInfo){
//			return BINARY_TYPE;
//		}
//    	else {
//			return UNKOWN_TYPE;
//		}
//
//	}
//

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(BonType.UNKOWN_TYPE);
        System.out.println(json);

        BonType s = objectMapper.readValue(json,BonType.class);
        System.out.println(s.toString());
    }

}
