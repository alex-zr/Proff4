package ua.kiev.prog.spring.life.circle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestBean implements InitializingBean {

    // 1. BeanDefinitionReader считывает все BeanDefinitions из контекста
    // 2. Запускаются все BeanFactoryPostProcessor классы объявленные в контексте и настраивают BeanDefinitions
    // 3. BeanDefinitions передаются в BeanFactory и она создаёт бины
    // 4. для каждого бина, BeanFactory запускает все BeanPostProcessors
    @InjectRandom
    private int value;

    public TestBean() {
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet()");
    }

    public void initMethod() {
        System.out.println("initMethod()");
    }

    public void printValue() {
        System.out.println("Generated value: " + value);
    }


}
