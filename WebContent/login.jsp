<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="com.ibm.smartcity.constant.constantss" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login to the System</title>
<style>
.clas
{
	border:8px solid;
	border-radius: 25px;
	width:500px;
	Height:150px;
	
}
.but
{
	border:3px solid;
	border-radius: 25px;
	border-color:Black;
	background-color:#ff4500;
	color:white;
	font-face:Comic Sans MS;
	Height:50px;
	Width:200px;
}
</style>
</head>
<body background="login.jpg">
<center>
<font size="+3" face="Comic Sans MS"><b>Welcome To Smart City Development</b></font>
</center>
        <br>
		<br>
		<br>
		<br>
		<br>
<center>
<div class="clas">
<%if(request.getAttribute(constantss.USER_LOGIN_FAILURE)!=null){
								String loginFailure = (String)request.getAttribute(constantss.USER_LOGIN_FAILURE);
								request.removeAttribute(constantss.USER_LOGIN_FAILURE);
								if("Y".equals(loginFailure)){ %>
									<h2>You have entered incorrect UserId / Password.</h2>
								<% }
							 }
							%>
	<form action="login.do" method="post">
	<font size="+2" face="Comic Sans MS">
								<p>
									<label for="userid">User Id</label>
									<span>
										<input type="Text" size="30" name="userId" id="userid" value="">
									</span>
								</p>
								<p>
									<label for="userpassword">Password</label>
									<span>
										<input type="password" size="30" name="userPassword" id="userpassword"  value="">
									</span>
								</p>
								<br>
								
									<input type="submit" value="Sign in" class="but" name="Submit"/>
						</font>		
						</form>
		</div>
		</center>
</body>
</html>