package spring;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.MessageListener;

@Configuration
@ComponentScan(value = "spring")
public class AppConfig {

    @Bean(destroyMethod = "stop")
    public PooledConnectionFactory pooledConnectionFactory(@Autowired ActiveMQConnectionFactory activeMQConnectionFactory) {
        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
        pooledConnectionFactory.setConnectionFactory(activeMQConnectionFactory);
        pooledConnectionFactory.setMaxConnections(100);
        return pooledConnectionFactory;
    }

    //    配置生产者
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://192.168.221.130:61616");
        return activeMQConnectionFactory;
    }

    //    这个队列目的地，点对点的
    @Bean
    public ActiveMQQueue activeMQQueue() {
        return new ActiveMQQueue("spring-active-queuee"); // 队列 目的地名称
    }

    // 是个是topic目的地
    @Bean
    public ActiveMQTopic activeMQTopic() {
        return new ActiveMQTopic("spring-active-topic");
    }

    //    spring 提供的JMS工具类，他可以进行消息发送，接收等
    @Bean
    @Autowired
    public JmsTemplate jmsTemplate(PooledConnectionFactory pooledConnectionFactory, ActiveMQQueue activeMQQueue, ActiveMQTopic activeMQTopic, SimpleMessageConverter simpleMessageConverter) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(pooledConnectionFactory);
        jmsTemplate.setDefaultDestination(activeMQTopic);
        jmsTemplate.setMessageConverter(simpleMessageConverter);
        return jmsTemplate;
    }

    //消息类型转换
    @Bean
    public SimpleMessageConverter simpleMessageConverter() {
        return new SimpleMessageConverter();
    }


    // 在 Spring 里，实现消费者不启动，直接配置监听完成。配置监听器，不必启动消费者，实现 messageListener 就会自动在 produce 之后自动消费
    @Bean
    public DefaultMessageListenerContainer defaultMessageListenerContainer(
            ActiveMQConnectionFactory activeMQConnectionFactory,
            ActiveMQQueue activeMQQueue,
            ActiveMQTopic activeMQTopic,
            MessageListener messageListener
    ) {
        DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
        defaultMessageListenerContainer.setConnectionFactory(activeMQConnectionFactory);
        defaultMessageListenerContainer.setDestination(activeMQTopic);
        defaultMessageListenerContainer.setMessageListener(messageListener);
        return defaultMessageListenerContainer;
    }




}
