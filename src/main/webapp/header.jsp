<%@ page import="com.liuwei.week7.pojo.User" %>
<html>
 <head>
   <title>My Online Shop</title>
   <style>
       .vis{
           visibility: visible;
       }
   </style>
 </head>
 <body style="margin:0px;padding:0px;font-family:helvetica;">
 <table width="100%" cellpadding="0" cellspacing="0">
   <tr>
     <td height="78" style="background-color:#788dad;
                            border-width:2px;
                            border-style:solid;
                            border-color:black;
                            padding:0px;
                            margin:0px;" valign="bottom">
      
     <img src="logo.jpg" align="left">
     </td>
   </tr>
   <tr>
     <td height="15" style="color:white;
                            background-color:#444444;
                            border-width:2px;
                            border-style:solid;
                            border-top-width:0px;
                            border-color:black;" align="center">
     <a style="color:white;" href="index.jsp">Home</a>
   - <a style="color:white;" href="Login.jsp">Login</a>
   - <a style="color:white;" href="productList">Product</a>
   - <a style="color:white;" href="#">FAQ</a>
   - <a style="color:white;" href="#">About</a>
   
   </td>
   </tr>
     <%!
         User u = null;
     %>
     <%
         HttpSession session1 = request.getSession(false);
         Object o = session1.getAttribute("User");
         if (o != null)
         {
             u = (User)o;
         }
         else
         {
             u = null;
         }
     %>
   <tr height="25"><td align="right"><font size="18" color="blue">
   Welcome,<font size="18" color="red"> <%=u == null ? "Guest" : u.getName()%></font>
   </font></td> </tr>
  <tr height="20"><td align="right">
   <br> <a href="loginOutServlet" class = "vis">Logout</a>
  <br><a href="#">My Cart</a><br/>
<a href="register.jsp">Register Here</a>
  </td></tr>
 </table>
<script>
    let s = document.getElementsByClassName("vis")[0];
    let flag = <%= u == null %>;
    if (flag)
    {
        s.style.visibility = "hidden";
    }
    else
    {
        s.style.visibility = "visible";
    }
    document.addEventListener('DOMContentLoaded',function () {
        let meta = document.createElement('meta');
        meta.httpEquiv = 'Cache-Control';
        meta.content = 'no-cache,no-store,must-revalidate';
        document.head.appendChild(meta);
    });
</script>