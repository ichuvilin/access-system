package com.example.accesssystem.model;

import com.example.accesssystem.entity.UserEntity;

import java.io.File;

public class User {
    private String first_name;
    private String last_name;
    private String username;
    private String role;

    private String qrCode;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setFirst_name(entity.getFirst_name());
        model.setLast_name(entity.getLast_name());
        model.setUsername(entity.getUsername());
        model.setRole(entity.getRole());
        model.setQrCode("./src/main/resources/static/img/" + entity.getUsername() + ".png");
        return model;
    }

    public User() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getQrCode() {
        return qrCode;
    }
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
