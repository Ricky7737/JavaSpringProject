package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    // 注入 StudentService Bean
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    // 註冊
    @PostMapping("/register")
    // 用於處理學生註冊請求。它接受一個 Student 物件作為參數，並返回一個 ResponseEntity<Student> 對象，表示 HTTP 回應
    public ResponseEntity<Student> register(@RequestBody Student student) {
        // 呼叫 StudentService 來註冊學生
        Student registeredStudent = studentService.registerStudent(student);

        System.out.println("有學生註冊");
        // 回傳註冊成功的 Student 物件
        // ResponseEntity<> 是 Spring 框架提供的類別，用於包裝 HTTP 回應
        // 第一個參數是註冊成功的 Student 物件，第二個參數是 HTTP 狀態碼
        // HttpStatus.CREATED 表示 HTTP 201
        return new ResponseEntity<>(registeredStudent, HttpStatus.CREATED);
    }
    // 登入
    @PostMapping("/login")
    // 用於處理學生登入請求。它接受一個 Student 物件作為參數，並返回一個 ResponseEntity<Student> 對象，表示 HTTP 回應
    public ResponseEntity<Student> login(@RequestBody Student student) {
        // 呼叫 StudentService 來驗證學生的帳號密碼
        Student loggedInStudent = studentService.loginStudent(student);
        // 回傳登入成功的 Student 物件
        System.out.println("有學生登入");
        // HttpStatus.OK 表示 HTTP 200
        return new ResponseEntity<>(loggedInStudent, HttpStatus.OK);
    }
}
