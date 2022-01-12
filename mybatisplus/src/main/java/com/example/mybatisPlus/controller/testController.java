package com.example.mybatisPlus.controller;

import com.example.mybatisPlus.User;
import com.example.mybatisPlus.mapper.edi.TestMapper;
import com.example.mybatisPlus.mapper.main.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class testController {

    @Resource
    private UserMapper userMapper;
    @Resource
    private TestMapper testMapper;

    @GetMapping("/test")
    public void test(){
//        userMapper.selectList(null);
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        //        List<User> users = testMapper.selectList(null);

    }

}
