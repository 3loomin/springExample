package com.example.ioc2;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Encoder {
    private IEncoder iEncoder;
    //@Qualifier -> 현재 빈이 base64, url 두 가지라서 하나로 지정을 해주는 어노테이션!
    public Encoder(@Qualifier("base74Encoder") IEncoder iEncoder){

        //this.iEncoder = new Base64Encoder();
        //this.iEncoder = new UrlEncoder();
        this.iEncoder = iEncoder;
    }
    public void setiEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }
    public String encode(String message){

        return iEncoder.encode(message);
    }
}
