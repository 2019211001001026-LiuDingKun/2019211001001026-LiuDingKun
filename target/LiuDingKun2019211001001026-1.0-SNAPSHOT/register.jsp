<%--
  Created by IntelliJ IDEA.
  User: 刘定坤
  Date: 2021/3/23
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<form method="post" action="register">
    ID:<input type="text" name="id"><br/>
    userName:<input type="text" name="username"><br/>
    password:<input type="text" name="password"><br/>
    email:<input type="text" name="email"><br/>
    Gender:<input type="radio" name="gender">Male<input type="radio" name="gender">Female<br/>
    Date of birth:<input type="text" name="birthDate"><br/>
    <input type="submit" value="Register"/>
</form>
<%@include file="footer.jsp"%>
