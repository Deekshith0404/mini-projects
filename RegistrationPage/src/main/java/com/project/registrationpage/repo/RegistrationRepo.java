package com.project.registrationpage.repo;

import com.project.registrationpage.entity.RegistrationEntity;

import java.util.List;

public interface RegistrationRepo {
    boolean save(RegistrationEntity registration);
    boolean Update(RegistrationEntity registration);

    List<RegistrationEntity> getall();

    RegistrationEntity getbyid(int idd);
}
