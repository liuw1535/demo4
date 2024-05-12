
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
					<h2>Login to your account</h2>	<%
    if(!(request.getAttribute("message")==null)){
    out.println("<h2>"+request.getAttribute("message")+"</h2>");
}%>
<%
    Cookie[] cookies=request.getCookies();
    String name="";
    String password="";
    String rememberMe="";
    if (cookies!=null){
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("name")){
                name=cookie.getValue();
            }
            if (cookie.getName().equals("password")){
                password=cookie.getValue();
            }
            if (cookie.getName().equals("isRem")){
                rememberMe=cookie.getValue();
            }
        }
    }
    //update 5 user basepath
%>

<form method="post" action="<%=basePath+"LoginServlet"%>">
    <input type="text" name="name" placeholder="name" value="<%=name%>"><br>
   <input type="password" name="password" placeholder="password" value="<%=password%>">
    <br/>
    <span>
		<input type="checkbox" class="checkbox" name="isRem" value="1" <%="1".equals(rememberMe)? "checked":""%>/> Keep me signed in
   </span>
    <button type="submit" class="btn btn-default">Login</button>
</form>	
					</div><!--/login form-->
				</div>
				
				
			</div>
		</div>
	</section><!--/form-->
<%@include file="footer.jsp"%>
