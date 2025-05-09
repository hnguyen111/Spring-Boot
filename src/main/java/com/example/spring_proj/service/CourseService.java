package com.example.spring_proj.service;

import com.example.spring_proj.entities.Course;
import com.example.spring_proj.exceptions.NotFoundException;
import com.example.spring_proj.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepo courseRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public Course addCourse(Course course) {
        return this.courseRepo.save(course);
    }

    public Course getCourseById(long courseId) {
        return this.courseRepo.findById(courseId).orElseThrow(() -> new NotFoundException("Course with ID " + courseId + " not found."));
    }
}
