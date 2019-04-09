package ua.kiev.prog.jpa.sample3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Clients")
@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;
    private Integer age;

    @ManyToMany
    @JoinTable(
            name = "ClientCourse",
            joinColumns = {@JoinColumn(name = "cli_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")})
    Set<Course> courses = new HashSet<>();

    public Client() {
    }

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course))
            courses.add(course);
        if (!course.clients.contains(this))
            course.clients.add(this);
    }

    public Set<Course> getCourses() {
        return Collections.unmodifiableSet(courses);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
