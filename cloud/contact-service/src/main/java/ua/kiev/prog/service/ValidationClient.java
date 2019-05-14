package ua.kiev.prog.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-cloud-eureka-client") // Имя используемое для балансировщика ribbon
public interface ValidationClient {
    @RequestMapping("/contact/validate")
    String validate(String phoneNumber);
}
