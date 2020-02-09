package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

@Service
public class SpringMQ_Produce {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SpringMQ_Produce produce = ctx.getBean(SpringMQ_Produce.class);
        produce.jmsTemplate.send(session -> {
            TextMessage textMessage = session.createTextMessage("**** spring 和 MQ 整合case 222 ****");
            return textMessage;
        });
        System.out.println("******produce over******88");
    }
}
