package com.xxb.mybatisDemon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xxb.mybatisDemon.mapper")
public class MybatisDemonApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisDemonApplication.class, args);
    }
}
