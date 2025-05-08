package com.example.spring_proj.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     @Column(name = "id", nullable = false)
     private long id;

     @Column(name = "first_name", nullable = false)
     @NotBlank(message = "First Name must not be null.")
     private String firstName;

     @Column(name = "last_name", nullable = false)
     @NotBlank(message = "Last Name must not be null.")
     private String lastName;
}
