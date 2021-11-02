package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bands")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameBand;
    private String avatarBand;
    private String description;
    @ManyToOne
    User user;
    public Band() {
    }

    public Band(Long id, String nameBand, String avatarBand, String description, User user) {
        this.id = id;
        this.nameBand = nameBand;
        this.avatarBand = avatarBand;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBand() {
        return nameBand;
    }

    public void setNameBand(String nameBand) {
        this.nameBand = nameBand;
    }

    public String getAvatarBand() {
        return avatarBand;
    }

    public void setAvatarBand(String avatarBand) {
        this.avatarBand = avatarBand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
