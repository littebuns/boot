package com.example.boot.controller;

import com.example.boot.util.ExceptionUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public void t1(){
        ExceptionUtill.t1();
    }

}
