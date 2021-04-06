<%--
  Created by IntelliJ IDEA.
  User: 刘定坤
  Date: 2021/3/16
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<body>
<a href="index.jsp"> go to Ecjtu </a><!-- method is GET -->
<form method="post"> <!--what is method when we use form?--><!--its GET why? default is GET, form data is added in the URL ,u can see-->
<!--its better to usePOST in form, data is not added in the URL-->
    Name:<input type="text" name="name"><br/>
    ID:<input type="text" id="id"><br/>
    <input type="submit" value="Send data to server"/>
</form>
<%@include file="footer.jsp"%>
