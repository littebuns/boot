package com.xxb.mybatisDemon.config;

import com.xxb.mybatisDemon.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SqlSessionFactoryConfigTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    void sqlSession() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.selectUser(1);
    }

}