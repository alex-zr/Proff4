package ua.kiev.prog.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by vincent.zhang on 6/14/2016.
 */
@Entity
@Where(clause = "deleted='FALSE'")
@SQLDelete(sql = "UPDATE department SET deleted = 'TRUE' WHERE id = ?")
public class Department extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(targetEntity = User.class)
    @JoinTable(
            name = "user_dept",
            inverseJoinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id",
                    nullable = false,
                    updatable = false),
            joinColumns = @JoinColumn(
                    name = "dept_id",
                    referencedColumnName = "id",
                    nullable = false,
                    updatable = false)
    )
    private Collection<User> users = new HashSet<>(0);

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Department that = (Department) o;
        if (!getName().equals(that.getName())) {
            return false;
        }
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getId().hashCode();
        return result;
    }
}
