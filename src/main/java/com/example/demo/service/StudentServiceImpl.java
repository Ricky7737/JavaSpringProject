package com.example.demo.service;

import com.example.demo.dao.StudentDAO;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    @Autowired
    // 注入 StudentDAO
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Student registerStudent(Student student) {
        // 檢查是否有同樣的名字
        // student.getUsername())!= null 意味著資料庫中已有相同的名字
        // != null 代表資料庫中有相同的名字
        if(studentDAO.findByUsername(student.getUsername())!= null){
            throw new IllegalArgumentException("Username already exists"); // 若有相同的名字，則拋出例外
        }
        // 若沒有相同的名字，則存入資料庫
        return studentDAO.save(student);
    }

    @Override
    public Student loginStudent(Student student) {
        // 從資料庫中尋找使用者名稱是否存在
        Student existingStudent = studentDAO.findByUsername(student.getUsername());
        // 如果不存在該使用者名稱或者密碼不正確，拋出運行時異常
        // existingStudent == null 意味著使用者名稱不存在
        // !existingStudent.getPassword().equals(student.getPassword()) 意味著密碼不正確
        if (existingStudent == null || !existingStudent.getPassword().equals(student.getPassword())) {
            throw new RuntimeException("Invalid username or password"); // 若不存在或密碼不正確，則拋出例外
        }
        return existingStudent; // 返回現有的學生資料
    }
}


