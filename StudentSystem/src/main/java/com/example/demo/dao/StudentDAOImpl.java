package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentDAOImpl implements StudentDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    // 實作 StudentDAO 介面中的 save 方法
    public Student save(Student student) {
        String SQL = "INSERT INTO students (username, password) VALUES (?, ?)";
        // 這邊用來插入資料到 students 表格中
        jdbcTemplate.update(SQL, student.getUsername(), student.getPassword());
        return student;
    }

    @Override
    public Student findByUsername(String username) {
        String SQL = "SELECT username, password FROM students WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(SQL, new Object[]{username}, new BeanPropertyRowMapper<>(Student.class));
        } catch (EmptyResultDataAccessException ex) {
            // 如果找不到符合條件的記錄，返回 null 或者其他適當的值
            return null;
        }
    }
}
