package ua.kiev.prog.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.prog.dao.DepartmentRepository;
import ua.kiev.prog.dao.UserRepository;
import ua.kiev.prog.domain.Department;
import ua.kiev.prog.domain.User;

@Service
@AllArgsConstructor
public class UserServiceImpl {

    private UserRepository userRepository;
    private DepartmentRepository departmentRepository;

    public Department getDepartmentById(Long id) {
        return departmentRepository.getOne(id);
    }

    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    @Transactional
    public void addToUser() {
        User user = findById(1L);
        for (long i = 1; i < 6; i++) {
            addToUser(getDepartmentById(i), user);
        }
    }

    @Transactional
    public void addToUser(Long depId, Long userId) {
        addToUser(getDepartmentById(depId), findById(userId));
    }

    @Transactional
    public void addToUser(Department department, User user) {
        if (user.getDepartments().contains(department)) {
            return;
        }
        user.getDepartments().add(department);
        userRepository.save(user);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void departmentSave(Department department) {
        departmentRepository.save(department);
    }
}
