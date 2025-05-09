package com.example.spring_proj.controller;

import com.example.spring_proj.dto.CourseDto;
import com.example.spring_proj.entities.Course;
import com.example.spring_proj.mappers.CourseMapper;
import com.example.spring_proj.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid CourseDto courseDto) {
        try {
            Course course = this.courseMapper.mapToModel(courseDto);
            return new ResponseEntity<>(this.courseService.addCourse(course), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }
}
