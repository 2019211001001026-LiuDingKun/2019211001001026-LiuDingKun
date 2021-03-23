package com.liudingkun.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("");
        String password=request.getParameter("");
        String email=request.getParameter("");
        String gender=request.getParameter("");
        String birthDate=request.getParameter("");

        PrintWriter writer= response.getWriter();
        writer.println("<br> username"+username);
        writer.println("<br> password"+password);
        writer.println("<br> email"+email);
        writer.println("<br> gender"+gender);
        writer.println("<br> birthDate"+birthDate);
        writer.close();

    }
}
