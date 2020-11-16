package com.radoslav.dodnikov.social_platform.forums;

import com.radoslav.dodnikov.social_platform.communities.Community;
import com.radoslav.dodnikov.social_platform.interfaces.AbstractEntity;
import com.radoslav.dodnikov.social_platform.users.User;

import javax.persistence.*;

@Entity
@Table(name = "forums")
public class Forum extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator_id;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community_id;

    public Forum(String title, String description, User creator_id, Community community_id) {
        this.title = title;
        this.description = description;
        this.creator_id = creator_id;
        this.community_id = community_id;
    }

    public Forum() {}

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

    public User getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(User creator_id) {
        this.creator_id = creator_id;
    }

    public Community getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(Community community_id) {
        this.community_id = community_id;
    }
}
