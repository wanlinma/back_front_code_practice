package config;

import bean.PersonBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;

@Configuration
@PropertySource(value = {"classpath:/application.properties"})
@ComponentScan("bean")
public class MainConfig {

    @Bean
    public PersonBean personBean() {
        return new PersonBean();
    }

    @Bean
    public MyBeanProcessor myBeanProcessor() {
        return new MyBeanProcessor();
    }

}
