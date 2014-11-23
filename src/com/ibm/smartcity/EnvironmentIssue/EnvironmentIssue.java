package com.ibm.smartcity.EnvironmentIssue;

import com.ibm.smartcity.bean.Issue;
import com.ibm.smartcity.dao.DatabaseUtility;
//import java.util.ArrayList;

public class EnvironmentIssue {
		public String reportIssue(Issue issueObj){
			System.out.println("Entering into reportIssue method of IssueReportAction class");
			//ArrayList<Issue> issueList = new ArrayList<Issue>();
			boolean issueReported=true;
			System.out.println("Issue Title : "+issueObj.getIssueTitle());
			System.out.println("Issue Address : "+issueObj.getIssueAddress());
			System.out.println("Issue Description : "+issueObj.getIssueDescription());
			System.out.println("Exiting reportIssue method of IssueReportAction class");
			DatabaseUtility dbUtil = new DatabaseUtility();
			//String connURL = dbUtil.saveIssue(issueObj);
			String connURL=dbUtil.saveIssue(issueObj);
			/*if(connURL!=null)
			{
				issueList = dbUtil.readIssueList();
			} */
			return(connURL);
	}
}
