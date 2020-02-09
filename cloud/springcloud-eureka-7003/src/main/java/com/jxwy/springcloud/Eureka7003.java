package com.jxwy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
//服务注册中心 Eureka Server
public class Eureka7003 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7003.class, args);
    }
}