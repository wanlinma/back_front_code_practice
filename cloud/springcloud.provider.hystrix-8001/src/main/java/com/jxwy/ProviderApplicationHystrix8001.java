package com.jxwy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 本服务启动后自动注册eureka服务
@EnableDiscoveryClient // 服务发现
@EnableCircuitBreaker
public class ProviderApplicationHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplicationHystrix8001.class, args);
    }
}
