package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pandaqyang
 * @date 2021/6/9 19:56
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    public String str ="" ;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String index() {
        return "Hello World";
    }

    @RequestMapping(value = "/set",method = RequestMethod.PUT)
    public void setStr(){
        str = "set value of str!!!";
    }
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String reTurnStr(){
        return str;
    }
}
