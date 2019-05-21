package ua.kiev.prog.spring.life.circle;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/*
В случае использования java конфигурации не используется, бины создаются кодом
 */

@Component
public class RandomFactory implements FactoryBean<TestBean> {
    @Override
    public TestBean getObject() throws Exception {
        TestBean randomBean = new TestBean();
        return randomBean;
    }

    @Override
    public Class<?> getObjectType() {
        return TestBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

