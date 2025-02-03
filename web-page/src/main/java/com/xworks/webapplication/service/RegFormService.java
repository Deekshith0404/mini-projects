package com.xworks.webapplication.service;

import com.xworks.webapplication.dto.AllCustomerDataDto;
import com.xworks.webapplication.dto.RegFormDto;

import java.util.List;

public interface RegFormService {
    boolean save(RegFormDto regFormDto);
    List<AllCustomerDataDto> login(String email, String password);
    Double grandTotal(String email);
}
