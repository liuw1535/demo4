<%--
  Created by IntelliJ IDEA.
  User: uisl
  Date: 2024/3/20
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<form action="SearchServlet" method="get" target="_blank">
    <label>
        <input type="text" name = "search" size="30">
        <select name="engine">
            <option value="baidu">Baidu</option>
            <option value="bing">Bing</option>
            <option value="google">Google</option>
        </select>
        <input type="submit" value="Search">
    </label>
</form>
<a href="config">Config.parameter-week4</a><br>
<a href="Login.jsp">Login-week5</a><br>
<a href="register.jsp">Register-getParameter-week3</a><br>
<a href="hello-servlet">Hello Servlet-week1</a><br>
<a href="register.jsp">Register JDBC-week4</a><br>
<a href="index.jsp">include-week5</a><br>
<a href="work_1">Student info Servlet-week2</a>
<%@include file="footer.jsp"%>
</body>
</html>
