import config.MainConfig;
import config.aop.MyDo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        MyDo myDo = annotationConfigApplicationContext.getBean(MyDo.class);
        myDo.print("张三1","张三2");
        myDo.print2("李四");
    }
}
