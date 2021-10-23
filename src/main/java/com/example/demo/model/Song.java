package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameSong;
    @Lob
    private String lyrics;
    private String avatarSong;
    private String mp3Url;
    @ManyToOne
    Category category;
    @ManyToOne
    User user;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "song_singer", joinColumns = @JoinColumn(name = "song_id"), inverseJoinColumns = @JoinColumn(name = "singer_id"))
    List<Singer> singerList = new ArrayList<>();
    public Song() {
    }

    public Song(Long id, String nameSong, String lyrics, String avatarSong, String mp3Url, Category category, User user, List<Singer> singerList) {
        this.id = id;
        this.nameSong = nameSong;
        this.lyrics = lyrics;
        this.avatarSong = avatarSong;
        this.mp3Url = mp3Url;
        this.category = category;
        this.user = user;
        this.singerList = singerList;
    }

    public Long getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSingerList(List<Singer> singerList) {
        this.singerList = singerList;
    }

    public List<Singer> getSingerList() {
        return singerList;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getAvatarSong() {
        return avatarSong;
    }

    public void setAvatarSong(String avatarSong) {
        this.avatarSong = avatarSong;
    }

    public String getMp3Url() {
        return mp3Url;
    }

    public void setMp3Url(String mp3Url) {
        this.mp3Url = mp3Url;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
