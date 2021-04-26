<%--
  Created by IntelliJ IDEA.
  User: 刘定坤
  Date: 2021/4/24
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%
    User u=(User) session.getAttribute("user");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Update</h1>
<form method="post" action="updateUser">
    id:<input type="text" name="id" value="<%=u.getId()%>"><br/>
    userName:<input type="text" name="username" value="<%=u.getUsername()%>"><br/>
    password:<input type="text" name="password" value="<%=u.getPassword()%>"><br/>
    email:<input type="text" name="email" value="<%=u.getEmail()%>"><br/>
    Gender:<input type="radio" name="gender" value="male"<%="male".equals(u.getGender())?"checked":""%>>Male
           <input type="radio" name="gender" value="female"<%="female".equals(u.getGender())?"checked":""%>>Female<br/>
    Date of birth:<input type="text" name="birthDate" value="<%=u.getBirthdate()%>"><br/>
    <input type="submit" value="Save Changes"/>
</form>
<%@include file="footer.jsp"%>
