package ua.kiev.prog.spring.sample0;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan
public class AppConfig {

/*    @Bean
    public Car car1() {
        return new Car("Ferrary", 2010, driver1());
    }

    @Bean
    public Car car2() {
        return new Car("Tesla", 2015, driver2());
    }

    @Bean
    public Driver driver1() {
        return new Driver("Poroshenko", 20);
    }

    @Bean
    public Driver driver2() {
        return new Driver("Zelensky", 10);
    }*/


    @Bean
    @Scope("prototype")
    public Object object() {
        return new Object();
    }

}
