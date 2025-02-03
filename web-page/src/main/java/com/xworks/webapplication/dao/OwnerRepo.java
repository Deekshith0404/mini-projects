package com.xworks.webapplication.dao;

import com.xworks.webapplication.dto.AllCustomerDataDto;
import com.xworks.webapplication.dto.OwnerRegDto;

import java.util.List;

public interface OwnerRepo {
    int login(String email,String password);
    int register(OwnerRegDto ownerRegDto);
    List<String> userNames();
    int dailyEntry(AllCustomerDataDto allCustomerDataDto);
    List<AllCustomerDataDto>  allData();
}
