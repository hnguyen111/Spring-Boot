package com.example.spring_proj.mappers;

import com.example.spring_proj.dto.CourseDto;
import com.example.spring_proj.entities.Course;
import com.example.spring_proj.entities.Mentor;
import com.example.spring_proj.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    private final MentorService mentorService;

    @Autowired
    public CourseMapper(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    public Course mapToModel(CourseDto dto) {
        Course course = new Course();
        Mentor mentor = this.mentorService.getMentorById(dto.getMentorId());
        course.setName(dto.getName());
        course.setPrice(dto.getPrice());
        course.setCapacity(dto.getCapacity());
        course.setNoOfDays(dto.getNoOfDays());
        course.setStartDate(dto.getStartDate());
        course.setDescription(dto.getDescription());
        course.setMentor(mentor);
        course.setEnrolmentEndDate(dto.getEnrolmentEndDate());
        return course;
    }
}
