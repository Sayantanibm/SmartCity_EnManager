package com.ibm.smartcity.login;

import java.util.ArrayList;

import com.ibm.smartcity.bean.Issue;
import com.ibm.smartcity.bean.User;
import com.ibm.smartcity.dao.DatabaseUtility;

public class login {
	public ArrayList<Issue> performLogin(User userObj){
		boolean loginSuccessful = false;
		ArrayList<Issue> issueList = new ArrayList<Issue>();
		DatabaseUtility dbUtil = new DatabaseUtility();
		loginSuccessful = dbUtil.isUserPresent(userObj);
		if(loginSuccessful){
			issueList = dbUtil.readIssueList();
		}
		return(issueList);
	}
}
