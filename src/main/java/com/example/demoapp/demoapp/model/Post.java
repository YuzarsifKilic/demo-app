package com.example.demoapp.demoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
    private String title;
    private String text;

    public Post() {}

    public Post(String id, User user, String title, String text) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.text = text;
    }

    public Post(User user, String title, String text) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
