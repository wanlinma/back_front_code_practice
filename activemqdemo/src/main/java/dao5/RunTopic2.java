package dao5;

import javax.jms.JMSException;
import java.io.IOException;

public class RunTopic2 {
    public static void main(String[] args) throws JMSException, IOException, InterruptedException {
        new JMSTopicCP().consumeMessage();
    }
}
