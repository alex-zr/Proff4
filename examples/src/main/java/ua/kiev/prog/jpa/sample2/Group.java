package ua.kiev.prog.jpa.sample2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Groups")
public class Group {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Client> clients = new HashSet<>();

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public void addClient(Client client) {
        client.setGroup(this);
        clients.add(client);
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
