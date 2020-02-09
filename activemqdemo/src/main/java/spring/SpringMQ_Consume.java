package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpringMQ_Consume {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SpringMQ_Consume consume = ctx.getBean(SpringMQ_Consume.class);
        String reValue = (String)consume.jmsTemplate.receiveAndConvert();
        System.out.println(reValue);
    }
}
