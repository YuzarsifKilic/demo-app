package com.example.demoapp.demoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "post_id", nullable = false)
    @JsonIgnore
    private Post post;
    private String text;

    public Comment() {}

    public Comment(String id, User user, Post post, String text) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.text = text;
    }

    public Comment(User user, Post post, String text) {
        this.user = user;
        this.post = post;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Post getPost() {
        return post;
    }

    public String getText() {
        return text;
    }
}
