package com.example.jar.jackson;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class Car {
    private String name;
    private int id;
}
