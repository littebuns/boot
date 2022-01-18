package com.xxb.mybatisDemon.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryConfig {

    /**
     * native 方式
     * 通过 mybatis-config.xml 获取到 sqlSession
     * @return sqlSession
     */
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


}
