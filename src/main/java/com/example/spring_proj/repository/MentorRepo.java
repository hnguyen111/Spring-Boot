package com.example.spring_proj.repository;

import com.example.spring_proj.entities.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepo extends JpaRepository<Mentor, Long> {
}
