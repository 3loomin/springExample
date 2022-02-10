package com.example.put.controller;


import com.example.put.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")// @PathVariable (name = "userId") Long id >> name = 에 {}안의 변수 명과 같아야 돼.
    public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable Long userId){
        System.out.println(requestDto);
        return requestDto;
    }

}
