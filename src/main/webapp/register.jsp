<%--
  Created by IntelliJ IDEA.
  User: uisl
  Date: 2024/3/10
  Time: 11:48
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
        .b{
            margin:10px 0 10px 0;
        }
        body{
            background-color:antiquewhite;
        }
        .c{
            padding: 5px 8px 5px 8px;
        }
    </style>
</head>
<body>
<div>
    <form action="jdbc" method="post">
        <label><span>Name:</span><br>
            <input type="text" value="Username" name="Username" onfocus="this.value = '';" class = "x" onblur = "if (this.value === ''){this.value = 'Username'}"></label><br>
        <label><span>Password:</span><br>
            <input type="password" minlength = "8" value="password" name="password" class = "x" onfocus="this.value = '';" onblur = "if (this.value === ''){this.value = 'Password'}"></label><br>
        <label><span>Email:</span><br>
            <input type="email" value="xxxx@xxx.xxx" name="email" class = "x" onfocus="this.value = '';" onblur = "if (this.value === ''){this.value = 'xxxx@xxx.xxx'}"></label><br>
        <span class ="b">Gender:</span><br>
        <label class = "c"><input type="radio" name = "sex" value="male">Male</label><label class = "c"><input type="radio" name = "sex" value="female">Female</label><br>
        <span class = "b">Birthday:</span><br>
        <label><input type="date" name="data"></label><br>
        <input type="submit" class="a" value="Register">
    </form>
</div>
</body>
</html>
