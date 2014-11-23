package com.ibm.smartcity.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import issuelist.issuelist;

import com.ibm.smartcity.bean.Issue;
import com.ibm.smartcity.constant.*;

/**
 * Servlet implementation class IssueListServlet
 */
@WebServlet("/IssueListServlet")
public class IssueListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entering into doGet method of IssueListServlet");
		issuelist issueLstAct = new issuelist();
		ArrayList<Issue> issueList = issueLstAct.getIssueList();
		System.out.println("List of issues : "+issueList);
		request.setAttribute(constantss.ISSUE_LIST, issueList);
		RequestDispatcher rd = request.getRequestDispatcher(page.ISSUE_LIST_PAGE);
		System.out.println("Exiting doGet method of IssueListServlet");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
