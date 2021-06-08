package com.liudingkun.week5.demo;

import com.liudingkun.dao.UserDao;
import com.liudingkun.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection Con=null;
    @Override
    public void init() throws ServletException {
        /*ServletContext servletContext = getServletContext();
        String driver =  servletContext.getInitParameter("driver");
        String url =  servletContext.getInitParameter("url");
        String username =  servletContext.getInitParameter("username");
        String password =  servletContext.getInitParameter("password");
        try {
            Class.forName(driver);
            Con= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        Con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userDao=new UserDao();
        try {
            User user= userDao.findByUsernamePassword(Con,username,password);
            if (user!=null){
                // week 8 code
                //Cookie c=new Cookie("sessionid",""+user.getId());
                //c.setMaxAge(10*60);
                //response.addCookie(c);
                String rememberMe=request.getParameter("rememberMe");
                if (rememberMe!=null&&rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername", user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword", user.getPassword());
                    Cookie rememberMeCookie=new Cookie("RememberMe", rememberMe);
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
                HttpSession session= request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(100000);
                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);

            }else {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*PrintWriter writer= response.getWriter();
        String sql = "SELECT * FROM usertable";
        try {
            ResultSet rs = Con.createStatement().executeQuery(sql);
            while(rs.next()){
                if(rs.getString("username").equals(username) && rs.getString("password").equals(password)){
                    request.setAttribute("id",rs.getString("id"));
                    request.setAttribute("username",rs.getString("username"));
                    request.setAttribute("password",rs.getString("password"));
                    request.setAttribute("email",rs.getString("email"));
                    request.setAttribute("gender",rs.getString("gender"));
                    request.setAttribute("birthdate",rs.getString("birthdate"));
                    request.getRequestDispatcher("userInfo.jsp").forward(request,response);
                        //week5 code
                        //writer.println("Login Success!!!");
                        //writer.println("Welcome"+username);
                    }else {
                        //writer.println("Username or Password Error!!!");
                    request.setAttribute("message","Username or Password Error!!!");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                    }
            }
            Con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
