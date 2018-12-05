package com.sheepxi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: 喜🐑
 * @create: 2018-12-04 17:53
 */
@SpringBootApplication
@MapperScan("com.sheepxi.mapper")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
