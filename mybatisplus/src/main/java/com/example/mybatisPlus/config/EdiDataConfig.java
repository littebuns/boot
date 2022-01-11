package com.example.mybatisPlus.config;


import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@MapperScan(basePackages = "com.example.mybatisPlus.mapper.edi", sqlSessionTemplateRef = "ediSqlSessionTemplate")
public class EdiDataConfig {

    static final String EDI_LOCATION = "classpath*:mapper/*.xml";

    @Bean("ediDataSource")
    @ConfigurationProperties("spring.edi.datasource")
    public DataSource ediDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ediSqlSessionFactory")
    public SqlSessionFactory ediSqlSessionFactory(@Qualifier("ediDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(resolveMapperLocations());
        return factoryBean.getObject();
    }

    public Resource[] resolveMapperLocations() {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        List<String> mapperLocations = new ArrayList<>();
        mapperLocations.add(EDI_LOCATION);
        List<Resource> resources = new ArrayList();
        if (mapperLocations != null) {
            for (String mapperLocation : mapperLocations) {
                try {
                    Resource[] mappers = resourceResolver.getResources(mapperLocation);
                    resources.addAll(Arrays.asList(mappers));
                } catch (IOException e) {
                    //
                }
            }
        }
        return resources.toArray(new Resource[resources.size()]);
    }


    @Bean(name = "ediTransactionManager")
    public DataSourceTransactionManager customTransactionManager(@Qualifier("ediDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "ediSqlSessionTemplate")
    public SqlSessionTemplate customSqlSessionTemplate(@Qualifier("ediSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
