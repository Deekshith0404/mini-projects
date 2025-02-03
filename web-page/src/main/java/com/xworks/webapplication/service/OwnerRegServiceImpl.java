package com.xworks.webapplication.service;

import com.xworks.webapplication.dao.OwnerRepo;
import com.xworks.webapplication.dao.OwnerRepoImpl;
import com.xworks.webapplication.dto.AllCustomerDataDto;
import com.xworks.webapplication.dto.OwnerRegDto;

import java.util.Collections;
import java.util.List;

public class OwnerRegServiceImpl implements OwnerRegService{

    private  OwnerRepo ownerRepo=new OwnerRepoImpl();
    @Override
    public int register(OwnerRegDto ownerRegDto) {
        return ownerRepo.register(ownerRegDto);
    }

    @Override
    public String login(String email, String password) {
        int result=ownerRepo.login(email,password);
        if (result==1){
            return "please register first!";
        } else if (result==2) {
            return null;
        }else {
            return "password incorrect";
        }
    }

    @Override
    public List<String> userName() {
        return ownerRepo.userNames();
    }

    @Override
    public String dailyEntry(AllCustomerDataDto allCustomerDataDto) {
        int result=ownerRepo.dailyEntry(allCustomerDataDto);
        if (result==1) {
            return "data saved successfully!!";
        } else if (result==2) {
            return "empty entry please add data!";
        }else {
            return "failed to add try again!";
        }
    }

    @Override
    public List<AllCustomerDataDto> allData() {
         return ownerRepo.allData();
    }
}
