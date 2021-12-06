package com.xxb.mybatisDemon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@Alias("user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String name;

    public User(String name) {
        this.name = name;
    }
}
