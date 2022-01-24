package com.xxb.mybatisDemon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Data
@Alias("user")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    public User(int age, String name, String email, String userPhone) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.userPhone = userPhone;
    }

    private int id;
    private int age;
    private String name;
    private String email;
    private String userPhone;

}
