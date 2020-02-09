package config;


import beans.CatBean;
import beans.PersonBean;
import condition.LinuxConditional;
import condition.WindowConditional;
import factory.MyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import regiter.MyImportBeanDefinitionRegistrar;
import selector.MyImportSelector;


@ComponentScan(value = {"service", "controller", "beans", "config"})
@Import({MyImportBeanDefinitionRegistrar.class})
public class MainConfig {
    @Bean
    public MyFactoryBean myFactoryBean() {
        return new MyFactoryBean();  // id myFactoryBean
    }

    @Bean
    public PersonBean personBean() {
        return new PersonBean().setName("向三").setAge(45);
    }

    @Bean
    @Conditional({LinuxConditional.class})
    public PersonBean personBeanLinux() {
        return new PersonBean().setName("Linux").setAge(12);
    }

    @Bean
    @Conditional({WindowConditional.class})
    public PersonBean personBeanWindows() {
        return new PersonBean().setName("Windows").setAge(12);
    }
}
