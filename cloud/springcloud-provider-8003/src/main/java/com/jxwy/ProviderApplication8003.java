package com.jxwy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 本服务启动后自动注册eureka服务
@EnableDiscoveryClient // 服务发现
public class ProviderApplication8003 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication8003.class, args);
    }
}
