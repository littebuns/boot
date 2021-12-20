package com.xxb.mybatisDemon.mapper;

import com.xxb.mybatisDemon.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void selectUser(){
        User user = userMapper.selectUser(1);
        System.out.println(user);
    }

    @Test
    void selectUserByResultMap(){
        User user = userMapper.selectUserByResultMap(1);
        System.out.println(user);
    }


    @Test
    void selectUserToMap() {
        Map<String, Object> map = this.userMapper.selectUserToMap();
        System.out.println(map);
    }
}