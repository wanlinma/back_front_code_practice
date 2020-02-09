import config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;


public class MainClass {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        annotationConfigApplicationContext.close();
    }
//    bean.PersonBean 构造方法...
//    bean.PersonBean init
//    bean.PersonBean destroy
}

