package com.ibm.smartcity.registration;

import com.ibm.smartcity.bean.User;
import com.ibm.smartcity.dao.DatabaseUtility;

public class registration {
	
	public boolean registerUser(User userObj){
		boolean userRegistrationSuccessful = true;
		DatabaseUtility dbUtil = new DatabaseUtility();
		userRegistrationSuccessful = dbUtil.saveUser(userObj);
		return(userRegistrationSuccessful);
	}

}
