package ua.kiev.prog.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ua.kiev.prog.service.ContactService;
import ua.kiev.prog.service.ValidationClient;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MyControllerTest {


    @MockBean
    private ContactService contactService;
    @MockBean
    private ValidationClient validationClient;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void delete() throws Exception {
        mockMvc.perform(post("/contact/delete").param("toDelete", "1", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                /*.andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))*/;
        /*
        if (toDelete != null && toDelete.length > 0)
            contactService.deleteContacts(toDelete);
         */
        //verify(contactService).deleteContacts(any());
    }

    @Test
    public void contactAdd() throws Exception {
        mockMvc.perform(post("/contact/add")
                .param("groupId", "1")
                .param("name", "1")
                .param("surname", "1")
                .param("phone", "1")
                .param("email", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("")));
        /*
            @RequestMapping(value = "/contact/add", method = RequestMethod.POST)
    public String contactAdd(@RequestParam(value = "group") long groupId,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String phone,
                             @RequestParam String email) {
         */
        //verify(contactService).findGroup(1);
    }
}