package selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes(); // 当前 @Import 上的所有注解类型。
        System.out.println("--selecotr--");
        annotationTypes.forEach(System.out::println);
//        --selecotr--
//        org.springframework.context.annotation.ComponentScan
//        org.springframework.context.annotation.Import
//        --selecotr--
        System.out.println("--selecotr--");
        return new String[]{beans.CatBean.class.getName()}; // "bean.CatBean"
//        return new String[0];
    }
}
