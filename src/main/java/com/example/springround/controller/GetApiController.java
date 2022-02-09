package com.example.springround.controller;


import com.example.springround.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    //https://localhost:포트/api/get/path-variable/{name}
    @GetMapping("path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){

        System.out.println("PathVariable:" + pathName);
        return pathName;
    }

    //https://localhost:포트/api/get/query-param?user=steve&email=steve@gmail.com%age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                System.out.println("\n");

                sb.append(entry.getKey() + " = " + entry.getValue() + "\n");

        });

        return sb.toString();
    }
    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" = " + email+" "+ age;
    }


    ////
    //?name=steve&email=stststs@gmail.com&age=12
    //객체를 만들어서 받는 형태 >> @Requestparam 쓰면 안돼 스프링 부트에서 알아서 해줘!
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}