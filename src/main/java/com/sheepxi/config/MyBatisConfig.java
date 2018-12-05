package com.sheepxi.config;

import ch.qos.logback.core.db.DriverManagerConnectionSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author: 喜🐑
 * @create: 2018-12-05 14:50
 */
@PropertySource(value = {"classpath:jdbc.properties"},ignoreResourceNotFound = true)
public class MyBatisConfig {
    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driverClass")
    private String driverName;

    @Value("${jdbc.username}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;

    @Autowired
    private DriverManagerDataSource driverManagerDataSource;

    /**
     * 初始化数据连接
     * @return
     */
    @Bean
    public DriverManagerConnectionSource driverManagerConnectionSource(){
        DriverManagerConnectionSource driver= new DriverManagerConnectionSource();
        driver.setDriverClass(driverName);
        driver.setUrl(jdbcUrl);
        driver.setUser(userName);
        driver.setPassword(password);
        return driver;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(driverManagerDataSource);
        ResourcePatternResolver resourcePatternResolver=new PathMatchingResourcePatternResolver();
        try {
             sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath:mapper/*.xml"));
             return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
