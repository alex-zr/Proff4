package ua.kiev.prog;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.kiev.prog.domain.Contact;
import ua.kiev.prog.domain.Group;
import ua.kiev.prog.service.ContactServiceImpl;

@SpringBootApplication
@AllArgsConstructor
public class Application implements ApplicationRunner {

    private ContactServiceImpl contactService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println("Context bean count: " + context.getBeanDefinitionCount());
    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception {
/*        Group group = new Group("Test");
        Contact contact;

        contactService.addGroup(group);

        for (int i = 0; i < 13; i++) {
            contact = new Contact(null, "Name" + i, "Surname" + i, "1234567" + i, "user" + i + "@test.com");
            contactService.addContact(contact);
        }
        for (int i = 0; i < 10; i++) {
            contact = new Contact(group, "Other" + i, "OtherSurname" + i, "7654321" + i, "user" + i + "@other.com");
            contactService.addContact(contact);
        }*/
    }
}