package com.liudingkun.controller;

import com.liudingkun.dao.UserDao;
import com.liudingkun.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection Con=null;

    @Override
    public void init() throws ServletException {
        //super.init();
        Con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        Date birthDate= Date.valueOf(request.getParameter("birthDate"));
        User u=new User();
        u.setId(id);
        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);
        u.setGender(gender);
        u.setBirthdate(birthDate);
        UserDao userDao=new UserDao();
        try {
            PrintWriter out= response.getWriter();
            userDao.updateUser(Con,u);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
    }
}
