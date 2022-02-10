package com.example.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class User {
    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;


    public User(){
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    }
    public User(String name, int age, String phoneNumber){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }


    //반드시 메소드의 시작에는 예약어를 사용하지 말자 ex) getDefaultUser (x)
    public User DefaultUser(){
        return new User("default",0,"010-1111-2222");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
