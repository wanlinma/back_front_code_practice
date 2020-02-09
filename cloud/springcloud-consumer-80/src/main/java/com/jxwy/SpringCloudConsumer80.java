package com.jxwy;

import com.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
// 在启动微服务的时候就能去加载我们自定义的Ribbon配置类，从而使配置生效
@RibbonClient(name = "SPRINGCLOUD-PROVIDER",configuration = MyRule.class)
public class SpringCloudConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumer80.class, args);
    }
}