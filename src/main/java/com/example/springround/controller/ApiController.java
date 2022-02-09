package com.example.springround.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //해당 class는 REST API 처리하는 Controller
@RequestMapping("/api") //RequestMapping URI를 지정해주는 Annotation

public class ApiController { //http://localhost:포트/api/hello
    @GetMapping("/hello")
    public String hello(){
        return "hello spring world!";
    }
}
