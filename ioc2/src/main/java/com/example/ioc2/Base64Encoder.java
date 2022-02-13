package com.example.ioc2;

import org.springframework.stereotype.Component;

import java.util.Base64;
@Component("base74Encoder")
public class Base64Encoder implements com.example.ioc2.IEncoder {

    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
