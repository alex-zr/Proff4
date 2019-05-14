package ua.kiev.prog.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("spring-cloud-eureka-client") // Имя используемое для балансировщика ribbon
public interface ValidationClient {
    @RequestMapping(value = "/contact/validate", method = RequestMethod.GET)
    String validate(String phoneNumber);
}
