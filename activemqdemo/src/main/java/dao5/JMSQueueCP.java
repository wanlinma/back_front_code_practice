package dao5;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JMSQueueCP {
    private String URL = "tcp://127.0.0.1:61616";
//    private String URL = "tcp://192.168.43.128:61616";
    private String QUEUE_NAME = "QueueHelloWorld01";

    public void produceMessage() throws JMSException {
        // 1. 连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        // 2. 创建连接
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 3. 创建会话  第一个事务，第二个签收
//        Connection connection = connectionFactory.createConnection();
//        connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4. 创建队列
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageProducer producer = session.createProducer(queue);
//        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("helloworld" + i);
            producer.send(textMessage);
        }
        // 关闭资源
        producer.close();
        session.close();
        connection.close();
        System.out.println("发布完成...");
    }

    public void consumeMessage() throws JMSException, InterruptedException, IOException {
        // 1. 连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        // 2. 创建连接
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 3. 创建会话  第一个事务，第二个签收
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        // 4. 创建队列
        Queue queue = session.createQueue(QUEUE_NAME);
        // 5. 消费者
        MessageConsumer consumer = session.createConsumer(queue);
        while (true) {
            TextMessage textMessage  = (TextMessage)consumer.receive(4000l);
            if (textMessage!=null) {
                System.out.println("消费者消费："+textMessage.getText());
            }else {
                break;
            }
        }
//        session.commit();

//        consumer.setMessageListener(new MessageListener() {
//            @SneakyThrows
//            public void onMessage(Message message) {
//                if (message != null && message instanceof TextMessage) {
//                    TextMessage textMessage = (TextMessage) message;
//                    System.out.println("消费者消费：" + textMessage.getText());
//                    System.out.println("附加信息：" + textMessage.getStringProperty("c01"));
//                }
//            }
//        });

        // 关闭资源
        consumer.close();
        session.close();
        connection.close();
    }


    public static void main(String[] args) throws JMSException, InterruptedException, IOException {
//        new JMSQueueCP().produceMessage();
        new JMSQueueCP().consumeMessage();
    }
}
