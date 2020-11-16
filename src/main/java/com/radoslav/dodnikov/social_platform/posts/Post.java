package com.radoslav.dodnikov.social_platform.posts;

import com.radoslav.dodnikov.social_platform.forums.Forum;
import com.radoslav.dodnikov.social_platform.interfaces.AbstractEntity;
import com.radoslav.dodnikov.social_platform.users.User;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator_id;

    @ManyToOne
    @JoinColumn(name = "forum_id")
    private Forum forum_id;

    public Post(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Post() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(User creator_id) {
        this.creator_id = creator_id;
    }

    public Forum getForum_id() {
        return forum_id;
    }

    public void setForum_id(Forum forum_id) {
        this.forum_id = forum_id;
    }
}
