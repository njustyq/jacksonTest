package com.example.demo;

import org.junit.Test;

/**
 * @author pandaqyang
 * @date 2021/6/18 11:38
 */
public class SomeAPITest {

    public void setLong(long l){
        if ( l >= 0L){
            String s = String.valueOf(l);
            System.out.println(s);
        }
    }

    public void setInt(int l){
        if ( l >= 0){
            String s = String.valueOf(l);
            System.out.println(s);
        }
    }

    @Test
    public void testLongAndInt(){
        setLong(1);
        setInt(1);
    }

    @Test
    public void testSwitch(){
//        String str = "str";
        String str = null;
//        String str = "";
        switch (str) {
            case "":
                System.out.println("it is empty!");
                break;
            case "str":
                System.out.println("it is str!");
                break;
            default:
                System.out.println("it is default value!");
                return;
        }
        System.out.printf("no return!");
    }
    @Test
    public void testString(){
        String s1 = "test";
        s1 += "sadsa";
        System.out.println(s1);
    }
}
