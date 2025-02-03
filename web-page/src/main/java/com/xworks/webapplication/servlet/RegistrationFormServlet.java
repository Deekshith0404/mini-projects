package com.xworks.webapplication.servlet;

import com.xworks.webapplication.dto.RegFormDto;
import com.xworks.webapplication.service.RegFormService;
import com.xworks.webapplication.service.RegFormServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;


@WebServlet(urlPatterns = "/regist",loadOnStartup = 1)
public class RegistrationFormServlet extends HttpServlet {
    private RegFormService regFormService=new RegFormServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        String conPassword=req.getParameter("confirmPassword");

        RegFormDto regFormDto=new RegFormDto(0,name,email,password, LocalTime.now());
        System.out.println(regFormDto);
        boolean result=regFormService.save(regFormDto);
        if (result){
            req.setAttribute("message","Registration complted. you can now login!!");
        }else {
            req.setAttribute("message","registration failed try again!!");
        }

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("RegForm.jsp");
        requestDispatcher.forward(req,resp);

    }
}
