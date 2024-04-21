<%--
  Created by IntelliJ IDEA.
  User: uisl
  Date: 2024/3/29
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            padding: 0;
            margin: 0;
        }
        input:focus{
            outline: none;
        }
        .x{
            height: 25px;
            font-size: 13px;
            color:#6e6e6f;
            border:none;
            border-bottom: 1px solid #98D5F3;
            margin: 5px 0 5px 0;
        }
        div{
            width: 28%;
            margin: 20px auto;
            text-align: center;
            background-color: white;
        }
        .a{
            background-color: white;
            border: none;
            cursor: pointer;
            margin-top: 30px;
            font-size: 23px;
            color:#D6BC8B;
        }
        .a:hover{
            color: #f5e50d;
            border-bottom: 1px solid #98D5F3;
        }
        body{
            background-color:antiquewhite;
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<%!
    String name = null;
%>
<%
    Cookie[] cookies = request.getCookies();
    for(int i = 0; i < cookies.length; i++)
    {
        if (cookies[i].getName().equals("username"))
        {
            name = cookies[i].getValue();
        }
    }
%>
<div>
    <form action="LoginServlet" method="post">
        <label><span>Name:</span><br>
            <input type="text" name="Username" placeholder="Username" class = "x" value=<%=name != null ? name : ""%>  ></label><br>
        <label><span>Password:</span><br>
            <input type="password" minlength = "8" name="password" class = "x" placeholder="Password"></label><br>
        <label>
            <input type="submit" class="a" value="Login"></label><br>
        <label><span>Remember me</span>
            <input type="checkbox" value="false" name = "isRem">
        </label>
    </form>
</div>
<script>
    let checkbox = document.getElementsByName("isRem")[0];
    checkbox.value = "false";
    checkbox.addEventListener('change',function (){
        if(this.checked)
        {
            this.value = "true";
        }
        else
        {
            this.value = "false";
        }
    });
</script>
<%@include file="footer.jsp"%>
</body>
</html>
