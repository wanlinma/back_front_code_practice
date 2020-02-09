package com.jxwy.cfgbeans;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    // 微服务调用
    @Bean
    @LoadBalanced // SpringBoot Ribbon 是基于Netflix Ribbon实现的一套客户端 负载均衡的工具。
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule iRule(){
//        RandomRule  随机
//        AvailabilityFilteringRule 会先过滤掉多次访问故障而处于断路器跳闸状态的服务，还有并发的链接数量超过阈值的服务，然后对剩余的服务列表进行轮询策略访问
//        WeightedResponseTimeRule 根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大，被选中概略越大，刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够，会切换到 WeightedResponseTimeRule
//        RetryRule 先根据 RoundRobinRule 策略获取服务，如果服务获取失败，则在指定时间内充实，获取可用的服务
//        BestAvailableRule 会过略掉由于措辞访问故障而处于断路器跳闸状态的服务，然后选择一个并发量小的服务
//        ZoneAvoidanceRule 默认规则，符合判断server所在区域的性能和server的可用性选择服务器
        return new RandomRule(); // 轮询
    }
}
