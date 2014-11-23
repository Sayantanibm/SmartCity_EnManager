<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ibm.smartcity.constant.constantss" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Your Issue Here</title>
<style>
.clas
{
	border:8px solid;
	border-radius: 25px;
	width:500px;
	Height:350px;
	
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
.cla
{
	float:right;
}
</style>
</head>
<body background = "orange1.jpg">
<%= session.getAttribute("userId") %>
<%session.setAttribute("userId", request.getParameter("userId")); %>
<center>
<div class="clas">
<%if(request.getAttribute(constantss.ISSUE_SAVE)!=null) {
							String issueSaveFlag = (String)request.getAttribute(constantss.ISSUE_SAVE);
							request.removeAttribute(constantss.ISSUE_SAVE);%>
							<%=issueSaveFlag %>
							<%if("Y".equals(issueSaveFlag)){%>
							<h2>Issue has been reported successfully!!!	</h2>
							<%}
						}%>
						
<h1>Post Your Issue Here</h1>
<br>
<br>
<br>
<br>
<br>
<form name="issuepost" method="post" action="reportIssue.do">
<font size="+2" face="Comic Sans MS">
<p>
IssueName:<input type="text" name="issueTitle" id="IssueTitle"></p>
<p>
IssueAddress:<input type="text" name="issueAddress" id="IssueAddress"></p>
<p>
IssueDescription:<input type="text" name="issueDescription" id="IssueDescription"></p>
<p>
<input type="submit" value="Report"  name="Submit"/>
</p>
</font>
</form>
</div>
<div class="cla">
	<font size="+1" face="Comic Sans MS">
<a href ="issuelist.do">Back to Issue list</a></font>
</div>
</center>
</body>
</html>