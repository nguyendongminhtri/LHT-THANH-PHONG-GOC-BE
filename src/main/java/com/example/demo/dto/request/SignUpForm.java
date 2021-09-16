package com.example.demo.dto.request;

import java.util.Set;

public class SignUpForm {
    private String name;
    private String username;
    private String email;
    private String avatar;
    private String password;
    private Set<String> roles;

    public SignUpForm() {
    }

    public SignUpForm(String name, String username, String email,String avatar, String password, Set<String> roles) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.password = password;
        this.roles = roles;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
