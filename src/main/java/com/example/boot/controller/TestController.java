package com.example.boot.controller;

import com.example.boot.util.ExceptionUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    private Map<String, String> shipMap = new HashMap<String, String>(){{
        put("","");
    }};


    @GetMapping
    public void t1(){
        ExceptionUtill.t1();
    }

}

