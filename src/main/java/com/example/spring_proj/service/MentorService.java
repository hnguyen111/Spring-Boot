package com.example.spring_proj.service;

import com.example.spring_proj.entities.Mentor;
import com.example.spring_proj.exceptions.NotFoundException;
import com.example.spring_proj.repository.MentorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorService {
    private final MentorRepo mentorRepo;

    @Autowired
    public MentorService(MentorRepo mentorRepo) {
        this.mentorRepo = mentorRepo;
    }

    public Mentor addMentor(Mentor mentor) {
        return this.mentorRepo.save(mentor);
    }

    public Mentor getMentorById(long mentorId) {
        return this.mentorRepo.findById(mentorId).orElseThrow(() -> new NotFoundException("Cannot find a mentor with ID " + mentorId));
    }
}
