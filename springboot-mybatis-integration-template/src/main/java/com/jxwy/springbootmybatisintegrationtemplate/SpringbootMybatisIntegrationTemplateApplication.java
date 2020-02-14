package com.jxwy.springbootmybatisintegrationtemplate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jxwy.springbootmybatisintegrationtemplate.mapper")
public class SpringbootMybatisIntegrationTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisIntegrationTemplateApplication.class, args);
    }

}
