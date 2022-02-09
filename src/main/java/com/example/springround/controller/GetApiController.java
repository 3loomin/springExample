package com.example.springround.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") //http://localhost:포트/api/get/hello
    public String getHello(){
        return "get Hello";
    }
    ////////versus
    @RequestMapping(path = "/hi", method = RequestMethod.GET) //get
    public String hi(){
        return "get Hi";
    }
}