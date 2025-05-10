package com.example.spring_proj.mappers;

import com.example.spring_proj.dto.EnrolmentDto;
import com.example.spring_proj.entities.Course;
import com.example.spring_proj.entities.Enrolment;
import com.example.spring_proj.entities.Student;
import com.example.spring_proj.service.CourseService;
import com.example.spring_proj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrolmentMapper {
    private final StudentService studentService;
    private final CourseService courseService;

    @Autowired
    public EnrolmentMapper(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public Enrolment mapToModel(EnrolmentDto enrolmentDto) {
        Student student = studentService.getStudentById(enrolmentDto.getStudentId());
        Course course = courseService.getCourseById(enrolmentDto.getCourseId());
        Enrolment enrolment = new Enrolment();
        enrolment.setStudent(student);
        enrolment.setCourse(course);
        enrolment.setEnrolmentDate(enrolmentDto.getEnrolmentDate());
        enrolment.setStatus(enrolmentDto.getStatus());
        return enrolment;
    }
}
