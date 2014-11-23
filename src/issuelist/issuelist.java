package issuelist;

import com.ibm.smartcity.bean.*;
import com.ibm.smartcity.dao.DatabaseUtility;
import java.util.ArrayList;
public class issuelist {
	public ArrayList<Issue> getIssueList(){
		System.out.println("Entering into getIssueList method of  IssueList");
		ArrayList<Issue> issueList = new ArrayList<Issue>();
		/*Issue issueObj = new Issue();
		issueObj.setIssueID("#17001");
		issueObj.setIssueTitle("Broken Tiles");
		issueObj.setIssueCategory("Technical Services Department");
		issueObj.setIssueStatus("Open");
		issueObj.setIssueDescription("In front of the bookstore there are many broken tiles. Please take care.");
		issueList.add(issueObj);*/
		issueList = new DatabaseUtility().readIssueList();
		System.out.println("Exiting getIssueList method of  IssueListAction");
		return(issueList);
	}

}
