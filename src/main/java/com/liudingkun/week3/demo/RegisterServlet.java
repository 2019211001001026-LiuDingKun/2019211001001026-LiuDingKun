package com.liudingkun.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    //week 4 code
    Connection Con=null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Con = DriverManager.getConnection(url, username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //week 3 code
        /* String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthDate=request.getParameter("birthDate");

        PrintWriter writer= response.getWriter();
        writer.println("<br> username"+username);
        writer.println("<br> password"+password);
        writer.println("<br> email"+email);
        writer.println("<br> gender"+gender);
        writer.println("<br> birthDate"+birthDate);
        writer.close();
         */
    }
    //week 4 code
    private void Insert(HttpServletRequest request)
    {
        String user =request.getParameter("username");
        String pass= request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String date = request.getParameter("birthdate");
        try {
            String sql = "insert into usertable values (?,?,?,?,?)";
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pass);
            ps.setString(3,email);
            ps.setString(4,gender);
            ps.setString(5,date);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void Print(HttpServletResponse response)
    {
        String sql = "SELECT * FROM usertable";
        try {
            ResultSet rs=Con.createStatement().executeQuery(sql);
            while(rs.next())
            {
                rs.getString("username");
                rs.getString("password");
                rs.getString("email");
                rs.getString("gender");
                rs.getString("date");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
        @Override
        public void destroy() {
            super.destroy();
            try {
                Con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
}
