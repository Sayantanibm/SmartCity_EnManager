package com.ibm.smartcity.servlet;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.smartcity.EnvironmentIssue.EnvironmentIssue;
import com.ibm.smartcity.bean.Issue;
import com.ibm.smartcity.constant.page;
import com.ibm.smartcity.constant.constantss;

@WebServlet("/EnvironmentIssueServlet")
public class EnvironmentIssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnvironmentIssueServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entering into doGet method of IssueReportServlet");
		EnvironmentIssue issueRptAct = new EnvironmentIssue();
		Issue issueObj = getIssueDetails(request);
		String connURL = issueRptAct.reportIssue(issueObj);
		/*if(issueReported){
			request.setAttribute(ParameterConstants.ISSUE_SAVE, "Y");
		}else{
			request.setAttribute(ParameterConstants.ISSUE_SAVE, "N");
		}*/
		request.setAttribute(constantss.ISSUE_SAVE, connURL);
		System.out.println("Exiting doGet method of EnvironmentIssueServlet");
		RequestDispatcher rd = request.getRequestDispatcher(page.ISSUE_REPORT_PAGE);
		rd.forward(request, response);
	}
	
	private Issue getIssueDetails(HttpServletRequest request){
		Issue issueObj = new Issue();
		String issueTitle = request.getParameter(constantss.ISSUE_TITLE);
		String issueAddress = request.getParameter(constantss.ISSUE_ADDRESS);
		String issueDescription = request.getParameter(constantss.ISSUE_DESCRIPTION);
		String issueStatus = request.getParameter(constantss.ISSUE_STATUS);
		issueTitle = (issueTitle!=null)?issueTitle.trim():"";
		issueAddress = (issueAddress!=null)?issueAddress.trim():"";
		issueDescription = (issueDescription!=null)?issueDescription.trim():"";
		issueStatus = (issueStatus!=null)?issueStatus.trim():"";
		issueObj.setIssueTitle(issueTitle);
		issueObj.setIssueDescription(issueDescription);
		issueObj.setIssueAddress(issueAddress);
		issueObj.setIssueStatus(issueStatus);
		return(issueObj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}

