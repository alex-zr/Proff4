package ua.kiev.prog.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

@Entity(name = "USER_")
public class User extends BaseEntity {

    @Transient
    private final int LEVEL = Integer.MAX_VALUE;

    @NaturalId
    @Column(unique = true)
    private String email;
    @Column(name = "password_hash")
    private String passwordHash;

    @Column
    private LocalDateTime passwordChangeDate;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "failed_login_attempt")
    private Integer failedLoginAttempt = 0;
    @Column(name = "unblock_hash")
    private String unblockHash;
    @Column(name = "password_should_be_changed")
    private Boolean passwordShouldBeChanged = false;
    @Column(name = "hidden")
    private Boolean hidden = false;
    @Column(name = "user_group")
    private String group;

    @Column(name = "authentication_source_id")
    private String authenticationSourceId;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_dept",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id",
                    nullable = false,
                    updatable = false),
            inverseJoinColumns = @JoinColumn(
                    name = "dept_id",
                    referencedColumnName = "id",
                    nullable = false,
                    updatable = false)
    )
    private Collection<Department> departments = new HashSet<>(0);

    @Column
    private LocalDateTime lastLogin;
    @Column
    private Boolean activated;

    @Override
    public String getName() {
        return getEmail();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public LocalDateTime getPasswordChangeDate() {
        return passwordChangeDate;
    }

    public void setPasswordChangeDate(LocalDateTime passwordChangeDate) {
        this.passwordChangeDate = passwordChangeDate;
    }

    public String getUnblockHash() {
        return unblockHash;
    }

    public void setUnblockHash(String unblockHash) {
        this.unblockHash = unblockHash;
    }

    public Boolean getPasswordShouldBeChanged() {
        return passwordShouldBeChanged;
    }

    public void setPasswordShouldBeChanged(Boolean passwordShouldBeChanged) {
        this.passwordShouldBeChanged = passwordShouldBeChanged;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAuthenticationSourceId() {
        return authenticationSourceId;
    }

    public void setAuthenticationSourceId(String authenticationSourceId) {
        this.authenticationSourceId = authenticationSourceId;
    }

    public Integer getFailedLoginAttempt() {
        return failedLoginAttempt;
    }

    public void setFailedLoginAttempt(Integer failedLoginAttempt) {
        this.failedLoginAttempt = failedLoginAttempt;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getEmail().equals(user.getEmail());

    }

    @Override
    public int hashCode() {
        return getEmail().hashCode();
    }
}
