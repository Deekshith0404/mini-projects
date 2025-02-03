package com.xworks.webapplication.dao;

import com.xworks.webapplication.dto.AllCustomerDataDto;
import com.xworks.webapplication.dto.RegFormDto;

import java.util.List;

public interface RegFormRepo {
boolean save(RegFormDto regFormDto);
List<AllCustomerDataDto> login(String email, String password);
    List<Double> grandTotal(String email);

}
