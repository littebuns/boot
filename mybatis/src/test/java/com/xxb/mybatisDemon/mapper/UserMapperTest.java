package com.xxb.mybatisDemon.mapper;

import com.xxb.mybatisDemon.config.SqlSessionFactoryConfig;
import com.xxb.mybatisDemon.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;
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

    /**
     * 测试 ${} 取值
     */
    @Test
    void selectUserByYear(){
        List<User> users = userMapper.selectUserByYear("2021");
        System.out.println(users);
    }

    /**
     * 单个参数的查询
     */
    @Test
    void selectByOneParam(){
        User user = userMapper.selectUser(11);
        System.out.println(user);
    }

    /**
     * 实体类作为参数进行查询
     */
    @Test
    void selectByEntity(){
        User user = new User();
        user.setAge(18);
        user.setName("Jone1");
        List<User> users = userMapper.selectByAgeAndName(user);
        System.out.println(users.size());
    }

    /**
     * 多个参数的查询
     */
    @Test
    void selectByMultParams(){
        List<User> users = userMapper.selectByAgeAndName1(18, "Jone");
        System.out.println(users);
    }

    @Test
    void selectMap(){
        Map<String, Object> map = userMapper.selectUserToMap();
        System.out.println(map);
    }

}