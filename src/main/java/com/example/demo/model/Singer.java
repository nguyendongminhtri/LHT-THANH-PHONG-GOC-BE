package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "singers")
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameSinger;
    private String avatarSinger;
    private String description;
    private LocalDate birthDay;
    @ManyToOne
    User user;

    public Singer() {
    }

    public Singer(Long id, String nameSinger, String avatarSinger, String description, LocalDate birthDay, User user) {
        this.id = id;
        this.nameSinger = nameSinger;
        this.avatarSinger = avatarSinger;
        this.description = description;
        this.birthDay = birthDay;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getAvatarSinger() {
        return avatarSinger;
    }

    public void setAvatarSinger(String avatarSinger) {
        this.avatarSinger = avatarSinger;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
