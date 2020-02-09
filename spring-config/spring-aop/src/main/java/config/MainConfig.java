package config;


import config.aop.MyDo;
import config.aop.RequestParamAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MainConfig {

    @Bean
    public MyDo div() {
        return new MyDo();
    }

    @Bean
    public RequestParamAspect divLogAspectAop() {
        return new RequestParamAspect();
    }
}
