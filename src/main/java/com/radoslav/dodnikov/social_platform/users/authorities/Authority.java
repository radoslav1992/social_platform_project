package com.radoslav.dodnikov.social_platform.users.authorities;

import com.radoslav.dodnikov.social_platform.interfaces.AbstractEntity;
import com.radoslav.dodnikov.social_platform.users.User;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authorities")
public class Authority extends AbstractEntity implements GrantedAuthority {

    @Column(name = "authority")
    private String authority;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

    public Authority() {
        this.users = new HashSet<>();
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
