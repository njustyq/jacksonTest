package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author pandaqyang
 * @date 2021/7/21 21:53
 */
public class Grade {

    @JsonProperty("Anum")
    public int num;

    @JsonProperty("Astudent")
    public Student student;

    public Grade(@JsonProperty("Anum") int num, @JsonProperty("Astudent") Student student){
        this.num = num;
        this.student = student;
    }


    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(new Grade(1,new Student("allen",18)));
        System.out.println(json);

        Grade grade = mapper.readValue(json, Grade.class);
    }
}
