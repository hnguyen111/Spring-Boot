package com.example.spring_proj.service;

import com.example.spring_proj.entities.Enrolment;
import com.example.spring_proj.enums.EnrolmentStatus;
import com.example.spring_proj.repository.EnrolmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrolmentService {
    private final EnrolmentRepo enrolmentRepo;

    @Autowired
    public EnrolmentService(EnrolmentRepo enrolmentRepo) {
        this.enrolmentRepo = enrolmentRepo;
    }

    public Enrolment addEnrolment(Enrolment enrolment) {
        if (enrolment.getEnrolmentDate().isAfter(enrolment.getCourse().getEnrolmentEndDate())) {
            throw new IllegalArgumentException("Enrolment date cannot be after the course's enrolment end date.");
        }
        if (enrolmentRepo.countByCourseAndStatus(enrolment.getCourse(), EnrolmentStatus.ACTIVE) == enrolment.getCourse().getCapacity()) {
            throw new IllegalStateException("Course has reached maximum enrolment capacity.");
        }
        if (enrolmentRepo.countByStudentAndStatus(enrolment.getStudent(), EnrolmentStatus.ACTIVE) == 1) {
            throw new IllegalStateException("Student already has an active enrolment.");
        }
        return this.enrolmentRepo.save(enrolment);
    }
}
