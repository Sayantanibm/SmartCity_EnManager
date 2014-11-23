<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.*,com.ibm.smartcity.bean.Issue,com.ibm.smartcity.constant.constantss,java.util.ArrayList" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.clas
{
	background-color:#8C8CFF;
	height:80px;
}
.bot
{
	float:bottom;
	background-color:#8C8CFF;
	height:80px;
}
.cla
{
	float:right;
}
</style>
<title>ISSUE LIST</title>
</head>
<body>
<div class="clas">
</div>
<div class="cla">
<h2>Welcome,<%= request.getParameter("userId") %></h2></div>
<%session.setAttribute("userId", request.getParameter("userId")); %>
<center><h1>List of Issues</h1></center>
					<div>
							<%
								ArrayList<Issue> issueList = null;
												if(request.getAttribute("IssueList")!=null){
													issueList = (ArrayList<Issue>)request.getAttribute("IssueList");
													request.removeAttribute("IssueList");
												}
												Iterator<Issue> issueLstItr =(issueList!=null)?issueList.iterator():null;
												if(issueLstItr!=null){
							%>
							<table width="100%" height="80" border="1" cellspacing="0" cellpadding="4">
								<thead>
								<tr>
									<th>Issue Title</th>
									<th>Issue Status</th>
									<th>Issue Address</th>
									<th>Issue Description</th>
								</tr>
								</thead>
								
								<tbody>
								
								<%while(issueLstItr.hasNext()){
									Issue issueObj = issueLstItr.next();
									String issueTitle = issueObj.getIssueTitle();
									String issueStatus = issueObj.getIssueStatus();
									String issueAddress = issueObj.getIssueAddress();
									String issueDescription = issueObj.getIssueDescription();
									issueTitle = (issueTitle !=null )?issueTitle.trim():"";
									issueStatus = (issueStatus!=null)?issueStatus.trim():"";
									issueAddress = (issueAddress!=null)?issueAddress.trim():"";
									issueDescription = (issueDescription!=null)?issueDescription.trim():"";
							%>
								<tr>
									<td><%=issueTitle %></td>
									<td><%=issueStatus %></td>
									<td><%=issueAddress %></td>
									<td><%=issueDescription %></td>
								</tr>
								
							<%}%>
								</tbody>
							</table>
							<%
							}
							%>		
	<div class="cla">
	<font size="+1" face="Comic Sans MS">
	<a href="issue.jsp">Create New Report</a></font>
	</div>			
</body>
</html>