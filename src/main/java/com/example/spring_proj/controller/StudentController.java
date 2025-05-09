package com.example.spring_proj.controller;

import com.example.spring_proj.dto.StudentDto;
import com.example.spring_proj.entities.Student;
import com.example.spring_proj.exceptions.NotFoundException;
import com.example.spring_proj.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student) {
        try {
            return ResponseEntity.ok(this.studentService.addStudent(student));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{sid}")
    public ResponseEntity<?> getStudentById(@PathVariable(name = "sid") long studentId) {
        try {
            Student student = this.studentService.getStudentById(studentId);
            return ResponseEntity.ok(student);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable long studentId, @RequestBody @Valid StudentDto studentDto) {
        try {
            Student updatedStudent = this.studentService.updateStudent(studentId, studentDto);
            return ResponseEntity.ok(updatedStudent);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudentById(@PathVariable long studentId) {
        this.studentService.deleteStudentById(studentId);
    }
}
