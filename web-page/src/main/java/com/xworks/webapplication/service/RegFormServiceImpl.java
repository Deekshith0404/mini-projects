package com.xworks.webapplication.service;

import com.xworks.webapplication.dao.RegFormRepoImpl;
import com.xworks.webapplication.dao.RegFormRepo;
import com.xworks.webapplication.dto.AllCustomerDataDto;
import com.xworks.webapplication.dto.RegFormDto;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RegFormServiceImpl implements RegFormService{

    private RegFormRepo regFormRepo=new RegFormRepoImpl();
    @Override
    public boolean save(RegFormDto regFormDto) {
       boolean result=regFormRepo.save(regFormDto);
       return  result;
    }

    @Override
    public List<AllCustomerDataDto> login(String email, String password) {
        return regFormRepo.login(email,password);

    }

    @Override
    public Double grandTotal(String email) {
        List<Double> list=regFormRepo.grandTotal(email);
        Iterator<Double> iterator= list.iterator();
        Double grandTotal=0.00;
        while (iterator.hasNext()){
            grandTotal+=iterator.next();
        }
        return grandTotal;
    }
}
