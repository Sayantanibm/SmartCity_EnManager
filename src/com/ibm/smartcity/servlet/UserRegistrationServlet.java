package com.ibm.smartcity.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.smartcity.registration.registration;
import com.ibm.smartcity.bean.User;
import com.ibm.smartcity.constant.page;
import com.ibm.smartcity.constant.constantss;

@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		registration userRegAct = new registration();
		User userObj = getUserDetails(request);
		boolean userRegistered = userRegAct.registerUser(userObj);
		RequestDispatcher rd = null;
		if(userRegistered){
			rd = request.getRequestDispatcher(page.USER_LOGIN_PAGE);
		}else{
			request.setAttribute(constantss.USER_SAVE_FAILURE, "Y");
			rd = request.getRequestDispatcher(page.USER_REGISTRATION_PAGE);
		}
		rd.forward(request, response);
	}
	
	private User getUserDetails(HttpServletRequest request){
		User userObj = new User();
		String userId = request.getParameter(constantss.USER_ID);
		String userPassword = request.getParameter(constantss.USER_PASSWORD);
		String userFirstName = request.getParameter(constantss.USER_FIRSTNAME);
		String userLastName = request.getParameter(constantss.USER_LASTNAME);
		String userAddress = request.getParameter(constantss.USER_ADDRESS);
		String userContact = request.getParameter(constantss.USER_CONTACT);
		userId = (userId!=null)?userId.trim():"";
		userPassword = (userPassword!=null)? userPassword.trim():"";
		userFirstName = (userFirstName!=null)?userFirstName.trim():"";
		userLastName = (userLastName!=null)?userLastName.trim():"";
		userAddress = (userAddress!=null)?userAddress.trim():"";
		userContact = (userContact!=null)?userContact.trim():"";
		userObj.setUserID(userId);
		userObj.setUserPassword(userPassword);
		userObj.setUserFirstName(userFirstName);
		userObj.setUserLastName(userLastName);
		userObj.setUserAddress(userAddress);
		userObj.setUserContact(userContact);
		return(userObj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}

