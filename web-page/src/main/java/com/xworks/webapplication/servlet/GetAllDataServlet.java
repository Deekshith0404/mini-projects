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
import java.util.List;
@WebServlet(urlPatterns = "/alldata",loadOnStartup = 1)
public class GetAllDataServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OwnerRegService ownerRegService=new OwnerRegServiceImpl();
        List<AllCustomerDataDto> list=ownerRegService.allData();
        if (list!=null){
            req.setAttribute("list",list);
            List<String> name1=ownerRegService.userName();
            req.setAttribute("names",name1);
        }else {
            req.setAttribute("list","data not found!");
        }
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("MaintainanceFile.jsp");
        requestDispatcher.forward(req,resp);
    }
}
