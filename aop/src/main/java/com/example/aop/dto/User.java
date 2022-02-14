package com.example.aop.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String id;
    private String pw;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
