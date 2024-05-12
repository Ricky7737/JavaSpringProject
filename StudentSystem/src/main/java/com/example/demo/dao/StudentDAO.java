package com.example.demo.dao;

import com.example.demo.model.Student;

public interface StudentDAO {
    // 儲存學生資料的地方
    Student save(Student student);
    Student findByUsername(String username);
}
