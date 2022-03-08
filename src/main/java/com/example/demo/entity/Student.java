package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

/**
 * @author pandaqyang
 * @date 2021/6/10 14:20
 */
public class Student {

    @JsonProperty("Aname")
    private String theName;

    @JsonProperty("Aage")
    private int theAge;

    public void setTheName(String theName) {
        this.theName = theName;
    }

    public String getTheName() {
        return theName;
    }

    public void setTheAge(int theAge) {
        this.theAge = theAge;
    }

    public int getTheAge() {
        return theAge;
    }

    @JsonCreator
    public Student(@JsonProperty("Aname1") String theName,@JsonProperty("Aage1") int theAge){
//    public Student( String theName,int theAge){
        this.theName = theName;
        this.theAge = theAge;
    }


    public Student(String theName){
        this.theName = theName;
        this.theAge = 10;
    }
    public Student(){}


    @Override
    public String toString() {
        return "Student{" +
                "theName='" + theName + '\'' +
                ", theAge=" + theAge +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        Student student = new Student();
        student.setTheName("张三");
        student.setTheAge(18);
        System.out.println(new ObjectMapper().writeValueAsString(student));

//        String Str = "{\"theName\":\"李四\",\"theAge\":20}";
        String Str = "{\"Aname\":\"李四\",\"Aage\":20}";
        ObjectMapper mapper = new ObjectMapper();
        Student s = mapper.readValue(Str,Student.class);
        System.out.println(s.toString());


    }
}
