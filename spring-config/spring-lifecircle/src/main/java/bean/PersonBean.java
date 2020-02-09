package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@Accessors(chain = true)
public class PersonBean implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Value("${user.nickName}")
    private String name;
    private Integer age;

    @PostConstruct
    public void init() {
        System.out.println(this.getClass().getName() + " init...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(this.getClass().getName() + " destroy...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(this.getClass().getName() + " setApplicationContext");
        this.applicationContext = applicationContext;
    }
}
