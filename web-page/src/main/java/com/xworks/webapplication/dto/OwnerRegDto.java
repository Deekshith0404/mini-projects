package com.xworks.webapplication.dto;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "owner")
@NamedQuery(name = "getByemailall",query = "select  e from OwnerRegDto e where e.email=:email")
@NamedQuery(name = "getemailbyname",query = "select  e from OwnerRegDto e where e.name=:name")
public class OwnerRegDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private LocalDate date;
    private LocalTime time;
}
