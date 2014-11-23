<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ibm.smartcity.constant.constantss" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.clas
{
	border:8px solid;
	border-radius: 25px;
	width:500px;
	Height:500px;
	
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration here</title>
</head>
<body background="registration.jpg">
<center>
<font size="+3" face="Comic Sans MS"><b>Welcome To Smart City Development</b></font>
</center>
        <br>
		<br>
<center>
<div class="clas">
<h1>User Registration</h1>
					
						<%if(request.getAttribute(constantss.USER_SAVE_FAILURE)!=null) {
							String userSaveFailure = (String)request.getAttribute(constantss.USER_SAVE_FAILURE);
							request.removeAttribute(constantss.USER_SAVE_FAILURE);
							if("Y".equals(userSaveFailure)){%>
							<h2>The UserId with which you want to register already exists.</h2>
							<%}
						}%>
							<form action="registerUser.do" method="post">
							<font size="+2" face="Comic Sans MS">
									<p>
										<label for="userid"><b>User Id</b>
										<span class="ibm-required">*</span></label>
										<span>
											<input type="Text" size="30" name="userId" id="userid" value="">
										</span>
									</p>
									<p>
										<label for="userpassword"><b>Password</b><span
												>*</span></label>
										<span>
											<input type="password" size="30" name="userPassword" id="userpassword" value="">
										</span>
									</p>
									<p>
										<label for="firstname"><b>First Name</b><span
												class="ibm-required">*</span></label>
										<span>
										<input type="Text" size="30" name="firstName" id="firstname" value="">
										</span>
									</p>
									<p>
										<label for="lastname"><b>Last Name</b><span>*</span></label>
										<span>
										<input type="Text" size="30" name="lastName" id="lastname" value="">
										</span>
									</p>	
									<p>
										<label for="usercontact"><b>Contact</b><span
												class="ibm-required">*</span></label>
										<span>
										<input type="Text" size="30" name="userContact" id="usercontact" value="">
										</span>
									</p>																										
									<p>
										<label for="useraddress"><b>Address</b><span>*</span></label>
										<span>
										<input type="Text" size="30" name="userAddress" id="useraddress" value="">
										</span>
									</p>
									
									<p>
										<input type="submit" value="Submit" class="but" name="Submit"/>
									</p>
									</font>
							</form>
							</div>	
							</center>
</body>
</html>