package com.xworks.webapplication.service;

import com.xworks.webapplication.dto.AllCustomerDataDto;
import com.xworks.webapplication.dto.OwnerRegDto;

import java.util.List;

public interface OwnerRegService {
    int register(OwnerRegDto ownerRegDto);
    String login(String email,String password);
    List<String> userName();
    String dailyEntry(AllCustomerDataDto allCustomerDataDto);
    List<AllCustomerDataDto> allData();
}
