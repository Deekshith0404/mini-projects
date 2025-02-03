package com.xworks.webapplication.dto;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "registration")
@NamedQuery(name = "getByemail",query = "select registration from RegFormDto registration where registration.email=:email")
@NamedQuery(name = "customername",query = "select r.userName from RegFormDto r")
public class RegFormDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String email;
    private String password;
    private LocalTime time;
}
