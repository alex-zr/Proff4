package ua.kiev.prog.jpa.sample3;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Courses")
@NamedQueries({
        @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
        @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name")
})
public class Course {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Transient
    private String note;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    Set<Client> clients = new HashSet<>();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public void addClient(Client client) {
        if (!clients.contains(client))
            clients.add(client);
        if (!client.courses.contains(this))
            client.courses.add(this);
    }

    public Set<Client> getClients() {
        return Collections.unmodifiableSet(clients);
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
