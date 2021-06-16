package com.liudingkun.controller;

import com.liudingkun.dao.OrderDao;
import com.liudingkun.model.Order;
import com.liudingkun.model.Payment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "OrderDetailsServlet", value = "/admin/orderList")
public class AdminOrderListServlet extends HttpServlet {
    private Connection con=null;

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Payment> paymentTypelist=Payment.findAllPayment(con);
        request.setAttribute("paymentTypeList",paymentTypelist);
        OrderDao orderDao=new OrderDao();
        List<Order> orderList=orderDao.findAll(con);
        request.setAttribute("orderList",orderList);
        String path="/WEB-INF/views/admin/orderList.jsp";
        request.getRequestDispatcher(path).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
}
