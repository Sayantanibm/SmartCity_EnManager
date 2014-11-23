package com.ibm.smartcity.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.smartcity.bean.Issue;
import com.ibm.smartcity.bean.User;
import com.ibm.smartcity.login.login;
import com.ibm.smartcity.constant.page;
import com.ibm.smartcity.constant.constantss;
@WebServlet("/LoginServelet")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public LoginServelet()
	 {
	        super();
	  }
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			User userObj = getUserIdPassword(request);
			login loginAction = new login();
			ArrayList<Issue> issueList= loginAction.performLogin(userObj);
			RequestDispatcher rd = null;
			if(issueList!=null && issueList.size()>0){
				request.setAttribute("IssueList",issueList);
				rd = request.getRequestDispatcher(page.ISSUE_LIST_PAGE);
			}else{
				request.setAttribute(constantss.USER_LOGIN_FAILURE, "Y");
				rd = request.getRequestDispatcher(page.USER_LOGIN_PAGE);
			}
			rd.forward(request, response);
		}
		
	 private User getUserIdPassword(HttpServletRequest request){
			User userObj = new User();
			String userId = request.getParameter(constantss.USER_ID);
			String userPassword = request.getParameter(constantss.USER_PASSWORD);
			userId = (userId!=null)?userId.trim():"";
			userPassword = (userPassword!=null)?userPassword.trim():"";
			userObj.setUserID(userId);
			userObj.setUserPassword(userPassword);
			return(userObj);
		}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request,response);
		}
}

