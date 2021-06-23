package com.example.boot.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootTest
public class applicationContextWare implements ApplicationContextAware {


    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Test
    public void test(){
        Object detail = context.getBean("myJobDetail");
        System.out.println(detail);
    }


}
