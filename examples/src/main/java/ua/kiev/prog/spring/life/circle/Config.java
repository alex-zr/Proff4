package ua.kiev.prog.spring.life.circle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ua.kiev.prog.spring.life")
public class Config {

    @Bean(initMethod = "initMethod")
    public TestBean testBean() {
        return new TestBean();
    }
}
