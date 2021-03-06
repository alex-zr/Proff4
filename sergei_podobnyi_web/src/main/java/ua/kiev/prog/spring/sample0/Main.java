package ua.kiev.prog.spring.sample0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Car car1 = context.getBean("car1", Car.class);
        Driver driver1 = context.getBean("driver1", Driver.class);
//        Driver driver = context.getBean("driver", Driver.class);
//        Object object1 = context.getBean("object", Object.class);
//        Object object2 = context.getBean("object", Object.class);
        System.out.println(car1);
        System.out.println(driver1);
//        System.out.println(driver);
//        System.out.println(object1);
//        System.out.println(object2);
    }
}
