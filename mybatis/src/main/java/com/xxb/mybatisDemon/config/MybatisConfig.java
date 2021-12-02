package com.xxb.mybatisDemon.config;

import com.xxb.mybatisDemon.mapper.UserMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource){
        Environment environment = new Environment("xxb", new JdbcTransactionFactory(), dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
        configuration.addMapper(UserMapper.class);
        return new SqlSessionFactoryBuilder().build(configuration);
    }

}
