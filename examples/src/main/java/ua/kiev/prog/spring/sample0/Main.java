package ua.kiev.prog.spring.sample0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.awt.AppContext;


public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println(car);
    }
}
