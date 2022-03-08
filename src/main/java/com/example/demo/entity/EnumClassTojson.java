package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

/**
 * @author pandaqyang
 * @date 2021/7/21 19:35
 */

public enum EnumClassTojson {
//    @JsonProperty("byte_t")
    BYTE_TYPE("byte"),
//    @JsonProperty("int32_t")
    INT32_TYPE("int32");

    @JsonProperty("type1")
    private final String type;

    @JsonCreator
    EnumClassTojson(@JsonProperty("type1")String type){
        this.type = type;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "type='" + type + '\'' +
//                '}';
//    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // 声明一个简单Module 对象
//        SimpleModule module = new SimpleModule();
//        // 给Module 添加一个序列化器
//        module.addSerializer(EnumClassTojson.class, new JsonSerializer<EnumClassTojson>() {
//            @Override
//            public void serialize(EnumClassTojson value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
//                // 开始写入对象
//                gen.writeStartObject();
//                // 分别指定 k v   code   description
//                gen.writeStringField("byte_t",value.type);
//                // 显式结束操作
//                gen.writeEndObject();
//            }
//        });
//
//        module.addDeserializer(EnumClassTojson.class, new JsonDeserializer<EnumClassTojson>() {
//            @Override
//            public EnumClassTojson deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
//                ObjectMapper mapper = new ObjectMapper();
//                String text = mapper.readTree(jsonParser).toString();
//                System.out.println(text);
//                return mapper.readValue(text, EnumClassTojson.class);
//            }
//        });
//        // 注册 Module
//        objectMapper.registerModule(module);

        String json = objectMapper.writeValueAsString(EnumClassTojson.BYTE_TYPE);
        System.out.println(json);

        EnumClassTojson s = objectMapper.readValue(json,EnumClassTojson.class);
        System.out.println(s.toString());
    }
}
