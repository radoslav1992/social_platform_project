package com.radoslav.dodnikov.social_platform.communities;

import com.radoslav.dodnikov.social_platform.interfaces.AbstractEntity;
import com.radoslav.dodnikov.social_platform.users.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "communities")
public class Community extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_communities",
            joinColumns = {@JoinColumn(name = "community_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> members;

    public Community(String title, String description) {
        this.title = title;
        this.description = description;
        this.members = new HashSet<>();
    }

    public Community() {
        this.members = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public void addMember(User newMember) {
        this.members.add(newMember);
    }
}
