package dao5;

import javax.jms.JMSException;
import java.io.IOException;

public class RunTopic {
    public static void main(String[] args) throws InterruptedException, JMSException, IOException {
        new JMSTopicCP().consumeMessage();
    }
}
