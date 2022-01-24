package com.xxb.mybatisDemon.mapper;

import com.xxb.mybatisDemon.config.SqlSessionFactoryConfig;
import com.xxb.mybatisDemon.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Slf4j
class UserMapperTest {

    private final UserMapper userMapper;
    private final SqlSession session;

    {
        session = SqlSessionFactoryConfig.getSqlSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    @Test
    void addUser(){
        User xxb = new User(18, "xxb", "xxb@xxb.com", "666");
        userMapper.addUser(xxb);
        log.info("数据插入后的主键为{}", xxb.getId());
        session.close();
    }

}