package com.example.demo.service;

import com.example.demo.model.Student;

public interface StudentService {
    // 學生註冊資料
    Student registerStudent(Student student);
    // 學生登入
    Student loginStudent(Student student);
}
