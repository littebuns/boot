package com.example.mybatisPlus.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author  xxb
 * @create  2022/1/11 9:46
 * @desc 查看注入两个数据源 jdbcTemplate 会用哪个
 * @Result jdbcTemplate 不会自动注入
 **/
@SpringBootTest
public class DatasourceTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void t1(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user ");
        System.out.println(list);
    }

}
