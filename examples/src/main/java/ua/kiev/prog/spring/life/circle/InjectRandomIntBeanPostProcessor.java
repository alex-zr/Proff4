package ua.kiev.prog.spring.life.circle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Component
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("postProcessBeforeInitialization()");

        Field[] fields = bean.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandom.class)) {
                field.setAccessible(true);
                InjectRandom annotation = field.getAnnotation(InjectRandom.class);
                ReflectionUtils.setField(field, bean, getRandomIntInRange(annotation.min(), annotation.max()));
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization()");
        return bean;
    }

    private int getRandomIntInRange(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

}
