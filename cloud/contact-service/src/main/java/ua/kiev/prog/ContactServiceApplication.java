package ua.kiev.prog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kiev.prog.service.ValidationClient;

@SpringBootApplication
@EnableFeignClients
@Controller
public class ContactServiceApplication {
    @Autowired
    private ValidationClient greetingClient;

    public static void main(String[] args) {
        SpringApplication.run(ContactServiceApplication.class, args);
    }

    @RequestMapping("/get-greeting")
    public String greeting(Model model) {
        model.addAttribute("greeting", greetingClient.greeting());
        return "greeting-view";
    }
}
