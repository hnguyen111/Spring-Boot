package com.example.spring_proj.service;

import com.example.spring_proj.dto.StudentDto;
import com.example.spring_proj.entities.Student;
import com.example.spring_proj.exceptions.NotFoundException;
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
        return addedStudent;
    }

    public Student getStudentById(long studentId) {
        Optional<Student> student = this.studentRepo.findById(studentId);
        return student.orElseThrow(() -> {
            return new NotFoundException("Student with ID " + studentId + " is not found.");
        });
    }

    public Student updateStudent(long studentId, StudentDto studentDto) {
        Student existingStudent = this.getStudentById(studentId);
        if (studentDto.getFirstName() != null) {
            existingStudent.setFirstName(studentDto.getFirstName());
        }
        if (studentDto.getLastName() != null) {
            existingStudent.setLastName(studentDto.getLastName());
        }
        if (studentDto.getEmail() != null) {
            existingStudent.setEmail(studentDto.getEmail());
        }
        if (studentDto.getPassword() != null) {
            existingStudent.setPassword(studentDto.getPassword());
        }
        return this.studentRepo.save(existingStudent);
    }

    public void deleteStudentById(long studentId) {
        this.studentRepo.deleteById(studentId);
    }
}
