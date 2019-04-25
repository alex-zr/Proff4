package ua.kiev.prog;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ua.kiev.prog.domain.Contact;
import ua.kiev.prog.domain.Group;
import ua.kiev.prog.service.ContactService;

/*
    Единый интерфейс (Uniform Interface)
    Отсутствие состояний (Stateless)
    Кеширование ответа (Cacheable)
    Клиент-сервер (Client-Server)
    Многоуровневая система (Layered System)
    Код по требованию (Code on Demand - опционально)
 */
@SpringBootApplication
@AllArgsConstructor
public class Application implements ApplicationRunner {
    private ContactService contactService;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Group group = new Group("Test");
        Contact contact;

        contactService.addGroup(group);

        for (int i = 0; i < 13; i++) {
            contact = new Contact(null, "Name" + i, "Surname" + i, "1234567" + i, "user" + i + "@test.com");
            contactService.addContact(contact);
        }
        for (int i = 0; i < 10; i++) {
            contact = new Contact(group, "Other" + i, "OtherSurname" + i, "7654321" + i, "user" + i + "@other.com");
            contactService.addContact(contact);
        }
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}