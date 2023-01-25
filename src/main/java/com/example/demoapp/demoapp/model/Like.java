package com.example.demoapp.demoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Like {

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

    public Like() {}

    public Like(String id, User user, Post post) {
        this.id = id;
        this.user = user;
        this.post = post;
    }

    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
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
}
