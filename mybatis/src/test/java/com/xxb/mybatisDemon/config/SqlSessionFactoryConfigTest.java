package com.xxb.mybatisDemon.config;

import com.xxb.mybatisDemon.entity.User;
import com.xxb.mybatisDemon.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SqlSessionFactoryConfigTest {

    @Test
    void getSqlSession() {
        SqlSession session = SqlSessionFactoryConfig.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUser(1);
        log.info(user.toString());
    }
}