package dao5;
import org.apache.activemq.ActiveMQConnectionFactory;


import javax.jms.*;
import java.io.IOException;

public class JMSDurableTopicCP {
    private String URL = "tcp://192.168.144.135:61616";
    private String TOPIC_NAME = "topic01";

    public void produceMessage() throws JMSException {
        // 1. 连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        // 2. 创建连接
        Connection connection = connectionFactory.createConnection();
        // 3. 创建会话  第一个事务，第二个签收
        Session topicConnectionSession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4. 创建 topic
        Topic topic = topicConnectionSession.createTopic(TOPIC_NAME);
        MessageProducer producer = topicConnectionSession.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();
        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = topicConnectionSession.createTextMessage("helloworld" + i);
            producer.send(textMessage);

        }
        // 关闭资源
        producer.close();
        topicConnectionSession.close();
        connection.close();
        System.out.println("发布完成...");
    }

    public void consumeMessage() throws JMSException, InterruptedException, IOException {
        System.out.println("消费者1");
        // 1. 连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        // 2. 创建连接
        Connection connection = connectionFactory.createConnection();
        connection.setClientID("z3");

        // 3. 创建会话  第一个事务，第二个签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4. 创建topic
        Topic topic = session.createTopic(TOPIC_NAME);
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "remark");
        connection.start();
        // 5. 消费者
        while (true) {
            Message message  = topicSubscriber.receive();
            if (message!=null) {
                if (message instanceof TextMessage)
                {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println("Text 消费者消费：" + textMessage.getText());
                }
            }else {
                break;
            }
        }

        // 关闭资源
        topicSubscriber.close();
        session.close();
        connection.close();
    }
    
    public static void main(String[] args) throws JMSException, IOException, InterruptedException {
        new JMSDurableTopicCP().produceMessage();
//        new JMSDurableTopicCP().consumeMessage();
    }
}
