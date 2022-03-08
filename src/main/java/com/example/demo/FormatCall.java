package com.example.demo;

import com.example.demo.entity.BonFieldFormatInfo;
import com.example.demo.entity.FieldFormatInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author pandaqyang
 * @date 2021/7/19 20:09
 */
public class FormatCall {

    public static void main(String[] args) throws JsonProcessingException {
        String Str = "{\"name\":\"f1\",\"format\":{\n" +
                "\"type\": \"int\"\n" +
                "}" +
                "}";
        String Str1 = "{\"name\":\"f1\",\"format\":{\n" +
                "\"type\": \"string\"\n" +
                "}" +
                "}";
        String Str2 = "{\"name\":\"f1\",\"format\":{\n" +
                "\"type\": \"int32\"\n" +
                "}" +
                "}";
        String Str3 = "{\"name\":\"f1\",\"format\":{\n" +
                "\"type\": \"int\"\n" +
                "}" +
                "}";
        String Str4 = "{\"name\":\"f1\",\"format\":{\n" +
                "\"type\": \"string\"\n" +
                "}" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        FieldFormatInfo fieldFormatInfo = mapper.readValue(Str,FieldFormatInfo.class);
        System.out.println(fieldFormatInfo.toString());

        FieldFormatInfo fieldFormatInfo1 = mapper.readValue(Str1,FieldFormatInfo.class);
        System.out.println(fieldFormatInfo1.toString());

        BonFieldFormatInfo fieldFormatInfo2 = mapper.readValue(Str2, BonFieldFormatInfo.class);
        System.out.println(fieldFormatInfo2.toString());

        BonFieldFormatInfo fieldFormatInfo3 = mapper.readValue(Str3, BonFieldFormatInfo.class);
        System.out.println(fieldFormatInfo3.toString());

        BonFieldFormatInfo fieldFormatInfo4 = mapper.readValue(Str4, BonFieldFormatInfo.class);
        System.out.println(fieldFormatInfo4.toString());
    }
}
