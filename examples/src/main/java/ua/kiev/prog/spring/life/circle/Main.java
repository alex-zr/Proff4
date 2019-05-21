package ua.kiev.prog.spring.life.circle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        TestBean bean = (TestBean) context.getBean("testBean");
        bean.printValue();

    }
}
