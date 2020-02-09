package dao5;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JMSDurableTopicCPRun {

    public static void main(String[] args) throws JMSException, IOException, InterruptedException {
        new JMSDurableTopicCP().consumeMessage();
        /**
         *  1. 一定要先运行一次消费者，等于像MQ注册，类似我订阅了这个主题。
         *  2. 然后在运行生产者发送消息。
         *  3. 无论消费者是否在线，都会接收到，下次连接，会把所有未接受的消息都接受。
         */
    }
}
