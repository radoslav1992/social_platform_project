package com.radoslav.dodnikov.social_platform.comments;

import com.radoslav.dodnikov.social_platform.interfaces.AbstractEntity;
import com.radoslav.dodnikov.social_platform.posts.Post;
import com.radoslav.dodnikov.social_platform.users.User;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends AbstractEntity {

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator_id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post_id;

    public Comment(String text, User cretor_id, Post post_id) {
        this.text = text;
        this.creator_id = cretor_id;
        this.post_id = post_id;
    }

    public Comment() {}

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

    public Post getPost_id() {
        return post_id;
    }

    public void setPost_id(Post post_id) {
        this.post_id = post_id;
    }
}
