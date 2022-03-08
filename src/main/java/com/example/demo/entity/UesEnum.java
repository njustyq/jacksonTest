package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import format.info.BonType;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * @author pandaqyang
 * @date 2021/7/21 19:46
 */
public class UesEnum {

    @JsonProperty("enumC")
//    @JsonSerialize(using = EnumSerializer.class)
    private EnumClassTojson[] enumC;

    @JsonProperty("bonType")
    private BonType[] bonTypes;

    @JsonCreator
    public UesEnum(
            @JsonProperty("enumC")
//            @JsonDeserialize(using = EnumDeserializer.class)
            EnumClassTojson[] enumC,
            @JsonProperty("bonType")
            BonType[] bonTypes
    ){
        this.enumC = enumC;
        this.bonTypes = bonTypes;
    }

    @Override
    public String toString() {
        return "UesEnum{" +
                "enumC=" + Arrays.asList(enumC)  +
                ", bonType" + Arrays.asList(bonTypes)  +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException, UnsupportedEncodingException {
        EnumClassTojson[] enumClassTojsons = {EnumClassTojson.BYTE_TYPE, EnumClassTojson.INT32_TYPE};
        BonType[] bonTypes = {BonType.BYTE_TYPE, BonType.INT32_TYPE};
        String json = new ObjectMapper().writeValueAsString(new UesEnum(enumClassTojsons, bonTypes));
//        String json = new ObjectMapper().writeValueAsString(new UesEnum(EnumClassTojson.BYTE_TYPE));
        System.out.println(json);
//        System.out.println(new ObjectMapper().writeValueAsString(new UesEnum(EnumClassTojson.BYTE_TYPE)));

        ObjectMapper mapper = new ObjectMapper();
        UesEnum s = mapper.readValue(json, UesEnum.class);
        System.out.println(s.toString());

        String path = "中国人";
        System.out.println(path);
        String str1 = new String(path.getBytes("GBK"),"iso-8859-1");
        System.out.println(str1);
        String str2 = new String(str1.getBytes("iso-8859-1"),"GBK");
        System.out.println(str2);
        String content = "中文";
        String str3 =new String(content.getBytes("iso-8859-1"), "iso-8859-1");
        System.out.println(str3);
        String str4 =new String(str3.getBytes("iso-8859-1"), "utf8");
        System.out.println(str4);

        List<String> list = Arrays.asList("json", "tdjson");
        System.out.println("list: " + list);

    }
}
