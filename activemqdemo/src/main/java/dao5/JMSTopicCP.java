package dao5;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JMSTopicCP {
    private String URL = "tcp://192.168.144.135:61616";
    private String TOPIC_NAME = "topic01";

    public void produceMessage() throws JMSException {
        // 1. 连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        // 2. 创建连接
        TopicConnection topicConnection = connectionFactory.createTopicConnection();
        topicConnection.start();
        // 3. 创建会话  第一个事务，第二个签收
        Session topicConnectionSession = topicConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4. 创建 topic
        Topic topic = topicConnectionSession.createTopic(TOPIC_NAME);
        MessageProducer producer = topicConnectionSession.createProducer(topic);
        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = topicConnectionSession.createTextMessage("helloworld" + i);
            producer.send(textMessage);

            //
            MapMessage mapMessage = topicConnectionSession.createMapMessage();
            mapMessage.setString("k1","mapmessage"+i);
            producer.send(mapMessage);

        }
        // 关闭资源
        producer.close();
        topicConnectionSession.close();
        topicConnection.close();
        System.out.println("发布完成...");
    }

    public void consumeMessage() throws JMSException, InterruptedException, IOException {
        System.out.println("消费者1");
        // 1. 连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        // 2. 创建连接
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 3. 创建会话  第一个事务，第二个签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4. 创建topic
        Topic topic = session.createTopic(TOPIC_NAME);
        // 5. 消费者
        MessageConsumer consumer = session.createConsumer(topic);
        while (true) {
            Message message  = consumer.receive();
            if (message!=null) {
                if (message instanceof TextMessage)
                {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println("Text 消费者消费：" + textMessage.getText());
                }
                if (message instanceof MapMessage) {
                    MapMessage mapMessage = (MapMessage) message;
                    System.out.println("Map 消费者消费：" + mapMessage.getString("k1"));
                }

            }else {
                break;
            }
        }

        // 关闭资源
//        System.in.read();  // 卡住代码执行，不关闭连接。
        consumer.close();
        session.close();
        connection.close();
    }


    public static void main(String[] args) throws JMSException, InterruptedException, IOException {
        new JMSTopicCP().produceMessage();
//        new JMSTopicCP().consumeMessage();
    }
}
