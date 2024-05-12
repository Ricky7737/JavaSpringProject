package com.example.demo.dto;

public class StudentDTO {
    private String username;
    private String password;

    // 空參數 與 帶參數構造

    public StudentDTO() {}

    public StudentDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getter and setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
