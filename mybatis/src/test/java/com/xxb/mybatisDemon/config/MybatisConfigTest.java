package com.xxb.mybatisDemon.config;

import com.xxb.mybatisDemon.entity.User;
import com.xxb.mybatisDemon.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisConfigTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void t1(){
        try (SqlSession session = sqlSessionFactory.openSession()){
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.selectUser(1);
            System.out.println(user);
        }
    }

}