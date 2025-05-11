package com.project.registrationpage.service;

import com.project.registrationpage.dto.RegistrationDto;
import com.project.registrationpage.entity.RegistrationEntity;
import com.project.registrationpage.repo.RegistrationRepo;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    RegistrationRepo registrationRepo;
    @Override
    public boolean save(RegistrationDto registrationDto) {
        RegistrationEntity registration=new RegistrationEntity();
        BeanUtils.copyProperties(registrationDto,registration);
        return registrationRepo.save(registration);
    }

    @Override
    public boolean Update(RegistrationEntity registration) {
        return registrationRepo.Update(registration);
    }

    @Override
    public List<RegistrationEntity> getalldata() {
        return registrationRepo.getall();
    }

    @Override
    public RegistrationEntity findById(int idd) {
        return registrationRepo.getbyid(idd);
    }
}
