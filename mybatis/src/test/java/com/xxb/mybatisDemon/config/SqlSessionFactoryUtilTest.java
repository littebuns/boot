package com.xxb.mybatisDemon.config;

import com.xxb.mybatisDemon.entity.User;
import com.xxb.mybatisDemon.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

@Slf4j
class SqlSessionFactoryUtilTest {

    @Test
    void getSqlSession() {
        SqlSession session = SqlSessionFactoryUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUser(1);
        log.info(user.toString());
    }

    @Test
    void getSqlSessionByEnvironment() {
        SqlSession session = SqlSessionFactoryUtil.getSqlSession("prod");
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUser(1);
        if (null != user){
            log.info(user.toString());
        }
    }
}