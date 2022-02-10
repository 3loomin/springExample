package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    //TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;
    }
    //JSON
    //실제 작동 req -> object mapper -> object -> method(우리가 만든) -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user; //200 OK
    }
    //
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(user);//201 status
    }
}
