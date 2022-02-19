package com.example.validation.controller;

import com.example.validation.dto.User;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {
    //옛날 방식
//    @PostMapping("/user")
//    public ResponseEntity user(@RequestBody User user){
//        System.out.println(user);
//
//        if(user.getAge() >= 90) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
//        }
//        return ResponseEntity.ok(user);
//    }
    @PostMapping("/user")
    //BindingResult @Valid의 결과가 들어오게 된다!
    //BindingResult객체를 통해서 새로운 변환값을 받을 수 있고, 이게 없다면 나중에 예외처리에서 같이 처리 가능하다!
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //bindingresult에 에러가 있니?
            StringBuilder sb = new StringBuilder();

            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError)objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("Field : "+field.getField());
                System.out.println(message);
                sb.append("field : "+field.getField());
                sb.append("message : "+message);

            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
        System.out.println(user);
        return ResponseEntity.ok(user);
    }


}
