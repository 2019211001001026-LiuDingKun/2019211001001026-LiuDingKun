<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!!!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<form method="post" action="/register">
    userName:<input type="text" name="username"><br/>
    password:<input type="text" name="password"><br/>
    email:<input type="text" name="email"><br/>
    Gender:<input type="radio" name="gender">Male<input type="radio" name="gender">Female<br/>
    Date of birth:<input type="text" name="birthDate"><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>