package com.xxb.mybatisDemon.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {

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
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //设置自动提交
        return sqlSessionFactory.openSession(true);
    }

    /**
     * 根据环境变量获取session
     * @param environment
     * @return
     */
    public static SqlSession getSqlSession(String environment){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置自动提交
        return new SqlSessionFactoryBuilder().build(inputStream, environment).openSession(true);
    }


}
