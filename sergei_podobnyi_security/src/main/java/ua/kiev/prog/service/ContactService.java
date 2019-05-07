package ua.kiev.prog.service;

import org.springframework.data.domain.Pageable;
import ua.kiev.prog.domain.Contact;
import ua.kiev.prog.domain.Group;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    void addContact(Contact contact);

    void addGroup(Group group);

    void deleteContacts(long[] idList);

    List<Group> findGroups();

    List<Contact> findAll(Pageable pageable);

    List<Contact> findByGroup(Group group, Pageable pageable);

    long countByGroup(Group group);

    List<Contact> findByPattern(String pattern, Pageable pageable);

    long count();

    Optional<Group> findGroup(long id);
}
