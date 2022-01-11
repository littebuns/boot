package com.example.jar;

import com.example.jar.easyExcel.mapper.TypeCodeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JarApplicationTests {

    @Autowired
    private TypeCodeMapper typeCodeMapper;

    @Test
    void contextLoads() {
        System.out.println(typeCodeMapper.selectList(null));
    }

}
