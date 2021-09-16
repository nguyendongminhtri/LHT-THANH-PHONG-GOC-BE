package com.example.demo.dto.request;

public class ChangePasswordForm {
    private String currentPassword;
    private String newPassword;

    public ChangePasswordForm() {
    }

    public ChangePasswordForm(String currentPassword, String newPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
