package com.xxb.mybatisDemon.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void selectUserToMap() {
        Map<String, Object> map = this.userMapper.selectUserToMap();
        System.out.println(map);
    }
}