package com.project.registrationpage.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@NamedQuery(name = "getall",query = "select e from RegistrationEntity e")
@NamedQuery(name = "getbyid",query = "select e from RegistrationEntity e where e.id=:id")
@NamedQuery(name = "update",query = "update RegistrationEntity e set e.name=:name , e.email =:email, e.mobile=:mobile, e.city=:city, e.gender=:gender where e.id=:id")

public class RegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    private String email;
    private Long mobile;
    private String city;
    private String gender;
}
