<%--
  Created by IntelliJ IDEA.
  User: 刘定坤
  Date: 2021/4/4
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1><%= "Login" %>
</h1>
<form method="post" action="login">
    userName:<input type="text" name="username"><br/>
    password:<input type="text" name="password"><br/>
    <input type="submit" value="Login"/>b mfk7.
</form>
<%@include file="footer.jsp"%>
