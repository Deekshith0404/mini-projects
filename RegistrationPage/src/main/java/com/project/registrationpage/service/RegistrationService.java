package com.project.registrationpage.service;

import com.project.registrationpage.dto.RegistrationDto;
import com.project.registrationpage.entity.RegistrationEntity;

import java.util.List;

public interface RegistrationService {
    boolean save(RegistrationDto registrationDto);
    boolean Update( RegistrationEntity registration);

    List<RegistrationEntity> getalldata();

    RegistrationEntity findById(int idd);
}
