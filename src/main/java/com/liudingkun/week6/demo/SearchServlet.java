package com.liudingkun.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String text=request.getParameter("txt");
        String[] s= request.getParameterValues("search");
        if (text==null){
            response.sendRedirect("/2019211001001026_LiuDingKun_war_exploded/index.jsp");
        }else {
            if(s[0].equals("baidu")){
                response.sendRedirect("https://www.baidu.com/s?we="+text);
            }else {
                if (s[0].equals("bing")){
                    response.sendRedirect("https://cn.bing.com/search?q="+text);
                }else {
                    if (s[0].equals("google")){
                        response.sendRedirect("https://www.google.cn/search?q="+text);
                    }
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
