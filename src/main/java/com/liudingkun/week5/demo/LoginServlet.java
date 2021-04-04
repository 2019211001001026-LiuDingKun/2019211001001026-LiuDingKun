package com.liudingkun.week5.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    Connection Con=null;
    @Override
    public void init() throws ServletException {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost;databaseName=userdb";
        String username ="sa";
        String password ="admin123456789";
        try {
            Class.forName(driver);
            Con= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean a;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        a=login(username,password);
        PrintWriter writer= response.getWriter();
        if(a=true)
        {
            writer.println("Login Success!!!");
            writer.println("Welcome"+username);
        }else {
            writer.println("Username or Password Error!!!");
        }
    }
    public boolean login(String name, String pwd) {
        boolean flag = false;
        String sql = "SELECT * FROM usertable";
        try {
            try {
                init();
            } catch (ServletException e) {
                e.printStackTrace();
            }
            ResultSet rs = Con.createStatement().executeQuery(sql);
            while(rs.next()){
                if(rs.getString("username").equals(name) && rs.getString("password").equals(pwd)){
                    flag = true;
                }
            }
            Con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
