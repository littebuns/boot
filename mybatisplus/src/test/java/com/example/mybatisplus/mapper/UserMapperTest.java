package com.example.mybatisplus.mapper;


import com.example.mybatisplus.User;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    /**
     * 批量查询
     */
    @Test
    public void t1(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    /**
     * 条件查询
     */
    @Test
    public void t2(){
        Map<String, Object> map = Maps.newHashMap("name", "xxb");
        map.put("id", 1);
        userMapper.selectByMap(map).forEach(System.out::println);
    }


}