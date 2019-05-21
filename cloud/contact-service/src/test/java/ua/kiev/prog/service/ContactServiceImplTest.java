package ua.kiev.prog.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.kiev.prog.dao.ContactRepository;
import ua.kiev.prog.dao.GroupRepository;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceImplTest {

    @Mock
    private ContactRepository contactRepository;
    @Mock
    private GroupRepository groupRepository;
    @InjectMocks
    private ContactService contactService = new ContactServiceImpl(contactRepository, groupRepository);

    @Test
    public void testDeleteContacts() {
        contactService.deleteContacts(new long[]{1,2});
        verify(contactRepository).deleteById(1L);
        verify(contactRepository).deleteById(2L);
    }
}