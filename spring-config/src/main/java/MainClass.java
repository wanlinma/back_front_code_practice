import beans.CatBean;
import config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.testng.annotations.Test;


public class MainClass {
    private static AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

    @Test
    public void test1() {
        Object myFactoryBean = annotationConfigApplicationContext.getBean("myFactoryBean");
        System.out.println(myFactoryBean); // CatBean(name=Tom, age=12)
        Object myFactoryBean2 = annotationConfigApplicationContext.getBean("&myFactoryBean");  // BeanFactory  FACTORY_BEAN_PREFIX
        System.out.println(myFactoryBean2); // factory.MyFactoryBean@4466af20
    }


    @Test
    public void test() {
        printAllBeans(annotationConfigApplicationContext);
    }


    private void printAllBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

}
