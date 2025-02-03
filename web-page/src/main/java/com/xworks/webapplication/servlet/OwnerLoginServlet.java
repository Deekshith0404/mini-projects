package com.xworks.webapplication.servlet;

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
@WebServlet(urlPatterns = "/ownerlogin",loadOnStartup = 1)
public class OwnerLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        OwnerRegService ownerRegService=new OwnerRegServiceImpl();

        String result=ownerRegService.login(email,password);
        if (result!=null){
            req.setAttribute("result",result);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("Owner.jsp");
            requestDispatcher.forward(req,resp);
        }else {
            List<String> name=ownerRegService.userName();
            req.setAttribute("names",name);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("MaintainanceFile.jsp");
            requestDispatcher.forward(req,resp);


        }
    }
}
