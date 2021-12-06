package com.xxb.mybatisDemon.config;

import com.xxb.mybatisDemon.entity.User;
import com.xxb.mybatisDemon.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryConfig {

    public static SqlSession getSqlSession(){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置自动提交
        return new SqlSessionFactoryBuilder().build(inputStream).openSession(true);
    }

    @Test
    public void t1(){
        try (SqlSession session = getSqlSession()){
            UserMapper mapper = session.getMapper(UserMapper.class);
//            mapper.insertUser("xxb");
            System.out.println(mapper.addUser(new User("xxb")));
            System.out.println(mapper.selectUser(1));
        }
    }

}
