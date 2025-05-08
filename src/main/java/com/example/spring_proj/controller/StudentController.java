package com.example.spring_proj.controller;

import com.example.spring_proj.entities.Student;
import com.example.spring_proj.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody @Valid Student student) {
        return this.studentService.addStudent(student);
    }

    @GetMapping("/student/{sid}")
    public Student getStudentById(@PathVariable(name = "sid") long studentId) {
        return this.studentService.getStudentById(studentId);
    }

    @PutMapping("/student/{studentId}")
    public Student updateStudent(@PathVariable long studentId, @RequestBody Student student) {
        if (studentId != student.getId()) {
            // Throw some error
        }
        return this.studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudentById(@PathVariable long studentId) {
        this.studentService.deleteStudentById(studentId);
    }
}
