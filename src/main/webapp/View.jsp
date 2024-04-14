<%@ page import="com.liuwei.week7.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.Collectors" %><%--
  Created by IntelliJ IDEA.
  User: uisl
  Date: 2024/4/14
  Time: 11:24
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
<%!
    List<User> users;
%>
<%
    Object os = request.getAttribute("users");
    boolean isList_User = true;
    if (os instanceof List)
    {
        List<?> list = (List<?>) os;
        for(int i = 0; i < list.size(); i++)
        {
            if (!(list.get(i) instanceof User))
            {
                users = null;
                isList_User = false;
                break;
            }
        }
        if (isList_User)
        {
            users = list.stream()
                        .filter(User.class::isInstance)
                        .map(User.class::cast)
                        .collect(Collectors.toList());
        }
    }
    //users = (List<User>)request.getAttribute("users");
%>
<table class = "tab">
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>password</th>
        <th>birthday</th>
        <th>email</th>
    </tr>
        <%
            User user;
            if (users != null)
            {
                for (int i = 0; i < users.size(); i++)
                {
                    user = users.get(i);
                    out.print("<tr><td>"+user.getID()+"</td><td>"+user.getName()+"</td><td>"+user.getPassword()+"</td><td>"+user.getBirthday()+"</td><td>"+user.getEmail()+"</td></tr>");
                }
                out.print("</table>");
            }
        %>

</html>
