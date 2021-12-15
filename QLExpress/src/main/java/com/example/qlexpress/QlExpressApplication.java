package com.example.qlexpress;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.qlexpress.mapper")
public class QlExpressApplication {

    public static void main(String[] args) {
        SpringApplication.run(QlExpressApplication.class, args);
    }

}
