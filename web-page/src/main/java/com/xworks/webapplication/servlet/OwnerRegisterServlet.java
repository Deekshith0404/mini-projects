package com.xworks.webapplication.servlet;
import com.xworks.webapplication.dto.OwnerRegDto;
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

@WebServlet(urlPatterns = "/owner",loadOnStartup = 1)
public class OwnerRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String email=req.getParameter("email");

        OwnerRegDto ownerRegDto=new OwnerRegDto(0,name,email,password, LocalDate.now(), LocalTime.now());
         OwnerRegService ownerRegService=new OwnerRegServiceImpl();

        int result=ownerRegService.register(ownerRegDto);
        if (result==1){
            req.setAttribute("result","registration success! login now");
        }else if (result==0){
            req.setAttribute("result","registration failed try again later");
        }else {
            req.setAttribute("result","login you have an account");
        }
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("OwnerRegister.jsp");
        requestDispatcher.forward(req,resp);
    }
}
