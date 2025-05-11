package com.project.registrationpage.dto;

import lombok.Data;

@Data
public class RegistrationDto {
    private int id;
    private  String name;
    private String email;
    private Long mobile;
    private String city;
    private String gender;
}
