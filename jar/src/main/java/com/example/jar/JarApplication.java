package com.example.jar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.jar.easyExcel.mapper")
public class JarApplication {

    public static void main(String[] args) {
        SpringApplication.run(JarApplication.class, args);
    }

}
