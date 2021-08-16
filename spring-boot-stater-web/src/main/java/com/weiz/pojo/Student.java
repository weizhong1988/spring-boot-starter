package com.weiz.pojo;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Student {
    @NotBlank(message = "name不允许为空")
    @Length(min = 2,max = 10,message = "你的长度不对劲呀")
    private  String firstName;

    @NotBlank(message = "name不允许为空")
    @Length(min = 2,max = 10,message = "你的长度不对劲呀")
    private  String lastName;

    @NotNull(message = "进入未成年人入内！")
    @Min(18)
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
