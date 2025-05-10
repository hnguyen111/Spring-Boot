package com.example.spring_proj.controller;

import com.example.spring_proj.dto.EnrolmentDto;
import com.example.spring_proj.entities.Enrolment;
import com.example.spring_proj.mappers.EnrolmentMapper;
import com.example.spring_proj.service.EnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/enrolment")
public class EnrolmentController {
    private final EnrolmentService enrolmentService;
    private final EnrolmentMapper enrolmentMapper;

    @Autowired
    public EnrolmentController(EnrolmentService enrolmentService, EnrolmentMapper enrolmentMapper) {
        this.enrolmentService = enrolmentService;
        this.enrolmentMapper = enrolmentMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEnrolment(@RequestBody EnrolmentDto enrolmentDto) {
        try {
            Enrolment enrolment = this.enrolmentMapper.mapToModel(enrolmentDto);
            return new ResponseEntity<>(this.enrolmentService.addEnrolment(enrolment), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }
}
