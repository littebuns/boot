package com.xxb.mybatisDemon.mapper;

import com.xxb.mybatisDemon.config.SqlSessionFactoryUtil;
import com.xxb.mybatisDemon.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

class UserResultMapMapperTest {

    private final SqlSession session = SqlSessionFactoryUtil.getSqlSession();
    private final UserResultMapMapper userResultMapMapper = session.getMapper(UserResultMapMapper.class);



    @Test
    void selectByResultMapper() {
        User user = userResultMapMapper.selectByResultMapper(1);
        System.out.println(user);
    }
}