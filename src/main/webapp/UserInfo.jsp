<%@ page import="com.liuwei.week7.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: uisl
  Date: 2024/4/20
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .tab {
            width: 100%;
            border-collapse: collapse;
        }
        .tab th,td{
            padding: 8px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        .tab th{
            background-color: #f2f2f2;
        }
        .tab tr:hover{
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<table class = "tab">
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>password</th>
        <th>birthday</th>
        <th>email</th>
    </tr>
        <%
        HttpSession session2 = request.getSession(false);
        User user = (User)session2.getAttribute("User");
            if (user != null)
            {
                out.print("<tr><td>"+user.getID()+"</td><td>"+user.getName()+"</td><td>"+user.getPassword()+"</td><td>"+user.getBirthday()+"</td><td>"+user.getEmail()+"</td></tr>");
                out.print("</table>");
            }
            else
            {
                out.print("<tr><td>---</td><td>---</td><td>---</td><td>---</td><td>---</td></tr></table>");
            }
        %><br>
    <a href="update.jsp">Update</a>

    <%@include file="footer.jsp"%>
</body>
</html>
