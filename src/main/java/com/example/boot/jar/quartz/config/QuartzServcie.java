package com.example.boot.jar.quartz.config;

import org.springframework.stereotype.Service;

@Service
public class QuartzServcie {


    public void task(){
        System.out.println("Service 中实际执行的任务");
    }

}
