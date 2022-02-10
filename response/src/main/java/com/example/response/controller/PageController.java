package com.example.response.controller;


import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 이 어노테이션은 페이지(html)을 리턴해주는 어노테이션이야 웹 개발을 같이 하게 되면 자주 사용하겠다!
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
        //return 자체가 String이라면, 자동으로 resources에서 같은 문자열 검색!
    }

    //ResponseEntity
    @ResponseBody //객체를 리턴해줘서 body를 만들어줘야 할 때!
    @GetMapping("/user")
    public User user(){
        var user = new User(); //var은 자바11버전에서 [User] user = new User()가 아닌 타입을 추론을 해줌
        user.setName("steve");
        user.setAddress("house");
        return user;
    }
}
