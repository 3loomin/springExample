package com.example.validation.dto;


import com.example.validation.annotation.YearMonth;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class User {
    //모든 validation 어노테이션엔 message가 있다!
    @NotBlank
    private String name;

    @Max(value = 90)
    private int age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxx")
    private String phoneNumber;

    //@Size(min = 6, max = 6) //yyyyMM
    @YearMonth
    private String reqYearMonth;


    @AssertTrue(message = "yyyyMM 형식에 맞지 않습니다.")
    public boolean isReqYearMonthValidation(){
        //parsing

        try{
            LocalDate localDate = LocalDate.parse(this.getReqYearMonth()+"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
        } catch (Exception e){
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                '}';
    }
}
