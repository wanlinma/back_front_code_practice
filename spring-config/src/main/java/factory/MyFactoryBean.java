package factory;

import beans.CatBean;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<CatBean> {


    @Override
    public CatBean getObject() throws Exception {
        return new CatBean().setName("Tom").setAge(12);
    }

    @Override
    public Class<?> getObjectType() {
        return CatBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
