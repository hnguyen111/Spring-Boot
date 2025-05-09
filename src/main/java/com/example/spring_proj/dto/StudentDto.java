package com.example.spring_proj.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
