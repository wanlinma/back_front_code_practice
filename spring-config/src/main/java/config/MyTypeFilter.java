package config;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Set;

/**
 * 在使用 @ComponetScan 的类，就算不使用 @Configuration ，如果里面使用了@Bean 的方式导入 Bean，依然会导入。其他类，使用了@Bean也不会导入。
 */
public class MyTypeFilter implements TypeFilter {
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        System.out.println("getClassName:" + metadataReader.getClassMetadata().getClassName()); // service.CatService
//        System.out.println("getFilename:"+metadataReader.getResource().getFilename()); // CatService.class
//        System.out.println("getURI:"+metadataReader.getResource().getURI()); // /C:/Users/TNT/Desktop/spring-config/target/classes/service/CatService.class
//        System.out.println("getURL:"+metadataReader.getResource().getURL()); // /C:/Users/TNT/Desktop/spring-config/target/classes/service/CatService.class
//        System.out.println("getDescription:"+metadataReader.getResource().getDescription()); // file [C:\Users\TNT\Desktop\spring-config\target\classes\service\CatService.class]
//        Set<String> annotationTypes = metadataReader.getAnnotationMetadata().getAnnotationTypes();
//        annotationTypes.forEach(System.out::println); // org.springframework.stereotype.Service   org.springframework.stereotype.Controller  ...
        // 可以根据类型满不满足某些条件来进行过滤 true表示满足。
        return false;
    }
}
