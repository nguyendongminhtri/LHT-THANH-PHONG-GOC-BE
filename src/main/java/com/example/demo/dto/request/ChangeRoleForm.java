package com.example.demo.dto.request;

public class ChangeRoleForm {
    private String role;

    public ChangeRoleForm() {
    }

    public ChangeRoleForm(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
