package com.liudingkun.week3.demo;

import jdk.nashorn.internal.objects.Global;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    //week 4 code
    Connection Con=null;

    @Override
    public void init() throws ServletException {
        super.init();
        /*ServletContext context = config.getServletContext();
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
        }*/
         Con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //week 3 code
        //String username=request.getParameter("username");
        //String password=request.getParameter("password");
        //String email=request.getParameter("email");
        //String gender=request.getParameter("gender");
        //String birthDate=request.getParameter("birthDate");

        //PrintWriter writer= response.getWriter();
        //writer.println("<br> username"+username);
        //writer.println("<br> password"+password);
        //writer.println("<br> email"+email);
        //writer.println("<br> gender"+gender);
        //writer.println("<br> birthDate"+birthDate);
        //writer.close();

        //week 4 code
        String id=request.getParameter("id");
        String user =request.getParameter("username");
        String pass= request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String date = request.getParameter("birthDate");
        try {
            String sql = "insert into usertable values (?,?,?,?,?,?)";
            PreparedStatement ps = Con.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,user);
            ps.setString(3,pass);
            ps.setString(4,email);
            ps.setString(5,gender);
            ps.setString(6,date);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //String sql = "SELECT * FROM usertable";
        //PrintWriter out= response.getWriter();
        //try {
            //ResultSet rs=Con.createStatement().executeQuery(sql);
            //out.println("<html><title></title><body><table border=1><tr>");
            //out.println("<td>id</td><td>Username</td><td>password</td><td>Email</td><td>Gender</td><td>Birthday</td></tr>");
            /*while(rs.next())
            {
                out.println("<tr>");
                out.println("<td>"+rs.getString("id")+"</td>");
                out.println("<td>"+rs.getString("username")+"</td>");
                out.println("<td>"+rs.getString("password")+"</td>");
                out.println("<td>"+rs.getString("email")+"</td>");
                out.println("<td>"+rs.getString("gender")+"</td>");
                out.println("<td>"+rs.getString("birthdate")+"</td>");
                out.println("</tr>");
            }
            out.println("</table></body></html>");*/
            //request.setAttribute("rsname",rs);
            //request.getRequestDispatcher("userList.jsp").forward(request,response);
            //System.out.println("I am in RegisterServlet-->doPost()--> after forward()");

       // } catch (SQLException throwables) {
         //   throwables.printStackTrace();
       // }
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
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
