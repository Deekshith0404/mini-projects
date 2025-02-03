package com.xworks.webapplication.servlet;

import com.xworks.webapplication.dto.AllCustomerDataDto;
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
import java.util.List;
@WebServlet(urlPatterns = "/login",loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
    private RegFormService regFormService=new RegFormServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String password=req.getParameter("password");

        List<AllCustomerDataDto> list =regFormService.login(email,password);
        if (list!=null){
            Double grand=regFormService.grandTotal(email);
            req.setAttribute("list",list);
            req.setAttribute("grand",grand);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("Result.jsp");
            requestDispatcher.forward(req,resp);
        }else {
            req.setAttribute("list","register first!!!");
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req,resp);

        }

    }
}
