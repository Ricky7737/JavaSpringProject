package com.example.demo.model;

public class Student {
    private Integer id;
    private String username;
    private String password;

    // 空參數 與 帶參數

    public Student() {}

    public Student(String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // getter and setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
