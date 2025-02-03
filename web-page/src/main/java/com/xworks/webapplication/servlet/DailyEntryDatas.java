package com.xworks.webapplication.servlet;

import com.xworks.webapplication.dto.AllCustomerDataDto;
import com.xworks.webapplication.service.OwnerRegService;
import com.xworks.webapplication.service.OwnerRegServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@WebServlet(urlPatterns = "/entry")
public class DailyEntryDatas extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OwnerRegService ownerRegService=new OwnerRegServiceImpl();
        String name=req.getParameter("name");
        Double quantity= Double.valueOf(req.getParameter("quantity"));
        Double price= Double.valueOf(req.getParameter("amount"));
        Double totalAmount=quantity*price;

        AllCustomerDataDto allCustomerDataDto=new AllCustomerDataDto(0,name,quantity,price, LocalTime.now(), LocalDate.now(),totalAmount);
        String result=ownerRegService.dailyEntry(allCustomerDataDto);
        req.setAttribute("result",result);
        List<String> name1=ownerRegService.userName();
        req.setAttribute("names",name1);
//        RequestDispatcher requestDispatcher=req.getRequestDispatcher("MaintainanceFile.jsp");
//        requestDispatcher.forward(req,resp);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("MaintainanceFile.jsp");
        requestDispatcher.forward(req,resp);
    }
}
