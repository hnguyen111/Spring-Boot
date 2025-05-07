package com.example.spring_proj.service;

import com.example.spring_proj.entities.Student;
import com.example.spring_proj.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student addStudent(Student student) {
        Student addedStudent = this.studentRepo.save(student);
        return  addedStudent;
    }

    public Student getStudentById(long studentId) {
        Optional<Student> student = this.studentRepo.findById(studentId);
        return student.orElse(null);
    }

    public Student updateStudent(Student student) {
        Student existingStudent = this.getStudentById(student.getId());
        if (existingStudent == null) {
            return null;
        }
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return this.studentRepo.save(student);
    }

    public void deleteStudentById(long studentId) {
        this.studentRepo.deleteById(studentId);
    }
}
