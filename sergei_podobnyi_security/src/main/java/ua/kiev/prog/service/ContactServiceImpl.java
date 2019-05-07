package ua.kiev.prog.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.prog.dao.ContactRepository;
import ua.kiev.prog.dao.GroupRepository;
import ua.kiev.prog.domain.Contact;
import ua.kiev.prog.domain.Group;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;
    private GroupRepository groupRepository;

    @Override
    @Transactional
    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    @Transactional
    public void addGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    @Transactional
    public void deleteContacts(long[] idList) {
        for (long id : idList) {
            contactRepository.deleteById(id);
        }
    }

    @Override
    @Transactional(propagation = Propagation.NEVER, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<Group> findGroups() {
        return groupRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll(Pageable pageable) {
        return contactRepository.findAll(pageable).getContent();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByGroup(Group group, Pageable pageable) {
        return contactRepository.findByGroup(group, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public long countByGroup(Group group) {
        return contactRepository.countByGroup(group);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByPattern(String pattern, Pageable pageable) {
        return contactRepository.findByPattern(pattern, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return contactRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Group> findGroup(long id) {
        return groupRepository.findById(id);
    }
}
