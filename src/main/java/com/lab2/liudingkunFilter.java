package com.lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class liudingkunFilter implements Filter {
        public void init(FilterConfig config) throws ServletException {
        }

        public void destroy() {
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
            System.out.println("liudingkunFilter-->before chain");
            chain.doFilter(request, response);
            System.out.println("liudingkunFilter-->after chain");
        }
}
