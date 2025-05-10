package com.example.spring_proj.repository;

import com.example.spring_proj.entities.Course;
import com.example.spring_proj.entities.Enrolment;
import com.example.spring_proj.entities.Student;
import com.example.spring_proj.enums.EnrolmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolmentRepo extends JpaRepository<Enrolment, Long> {
    long countByCourseAndStatus(Course course, EnrolmentStatus status);

    long countByStudentAndStatus(Student student, EnrolmentStatus status);
}
