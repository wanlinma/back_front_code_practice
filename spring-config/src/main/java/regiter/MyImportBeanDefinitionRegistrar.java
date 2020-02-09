package regiter;

import beans.CatBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        System.out.println("----register---");
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        if (registry.containsBeanDefinition("personBean")) // 包含这个 bean 名 id
        {
            BeanDefinition beanDefinition = new RootBeanDefinition(CatBean.class);
            registry.registerBeanDefinition("catBeanMWL", beanDefinition);
        }
        System.out.println("----register---");
    }
}
