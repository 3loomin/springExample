package com.example.put.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@JsonNaming (value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutRequestDto {

    private String name;
    private  int age;
    private List<CarDto> carList;

    @Override
    public String toString() {
        return "PutRequestDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carList=" + carList +
                '}';
    }
}
