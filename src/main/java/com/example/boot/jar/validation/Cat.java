package com.example.boot.jar.validation;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Cat {

    @NotBlank(message = "名称不能为空")
    private String name;

    private int age;

    @BlankList()
    private String port1;

    @BlankList()
    private String port2;

}
