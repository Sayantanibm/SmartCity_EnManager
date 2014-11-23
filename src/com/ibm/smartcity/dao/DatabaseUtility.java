package com.ibm.smartcity.dao;
import java.util.ArrayList;

import com.ibm.smartcity.bean.Issue;
import com.ibm.smartcity.bean.User;
import com.ibm.smartcity.constant.constantss;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
public class DatabaseUtility {
	
	public String saveIssue(Issue issueObj){
		 String connURL = null;
		try{
			
			 connURL = getServiceURI();
			 System.out.println("Connection URL : "+connURL);
		      MongoClient mongo = new MongoClient(new MongoClientURI(connURL));

		        DB db = mongo.getDB("db");
		        BasicDBObject doc = new BasicDBObject("IssueTitle",issueObj.getIssueTitle())
		        	.append("IssueStatus", issueObj.getIssueStatus())
		        	.append("IssueAddress", issueObj.getIssueAddress())
		        	.append("IssueDescription", issueObj.getIssueDescription());
		        DBCollection table = null;
		        try{
		        	table = db.createCollection("IssueListed",doc);
		        }catch(Exception ex){
		        	table = db.getCollection("IssueListed");
		        }
		      /* doc.put("IssueTitle", issueObj.getIssueTitle());
		        doc.put("IssueCategory", issueObj.getIssueCategory());
		        doc.put("IssueAddress", issueObj.getIssueAddress());
		        doc.put("IssueDescription", issueObj.getIssueDescription());*/
		        table.insert(doc);
		        //issueSaved = true;
		        
		       /* DBCollection table = db.getCollection("user");


		        BasicDBObject document = new BasicDBObject();
		        document.put("name", "Tom");
		        document.put("age", 30);
		        document.put("createdDate", new Date());
		        table.insert(document);

		        BasicDBObject searchQuery = new BasicDBObject();
		        searchQuery.put("name", "Tom");

		        DBCursor cursor = table.find(searchQuery);

		        while (cursor.hasNext()) {
		            //out.println( "Inserted: " + cursor.next());
		        	System.out.println("Inserted: " + cursor.next());
		        }

		        BasicDBObject query = new BasicDBObject();
		        query.put("name", "Tom");

		        BasicDBObject newDocument = new BasicDBObject();
		        newDocument.put("name", "Tina");

		        BasicDBObject updateObj = new BasicDBObject();
		        updateObj.put("$set", newDocument);

		        table.update(query, updateObj);

		        BasicDBObject searchQuery2 = new BasicDBObject().append("name", "Tina");

		        DBCursor cursor2 = table.find(searchQuery2);

		        while (cursor2.hasNext()) {
		            //out.println( "Updated: " + cursor2.next());
		            System.out.println("Updated: " + cursor2.next());
		        }*/
		}catch(Exception ex){
			//issueSaved = false;
			ex.printStackTrace();
			connURL = ex.getMessage();
		}
		return("Issue Reported");
	}
	
	
	public ArrayList<Issue> readIssueList(){
		ArrayList<Issue> issueList = new ArrayList<Issue>();
		try{
			String connURL = getServiceURI();
			System.out.println("Connection URL : "+connURL);
		    MongoClient mongo = new MongoClient(new MongoClientURI(connURL));
		    DB db = mongo.getDB("db");
		    DBCollection table = db.getCollection("IssueListed");
		    DBCursor cursor = table.find();
		    while(cursor.hasNext()){
		    	BasicDBObject dbObject = (BasicDBObject)cursor.next();
		    	Issue issueObj = new Issue();
		    	//issueObj.setIssueId(dbObject.getString("IssueId"));
		    	issueObj.setIssueTitle(dbObject.getString("IssueTitle"));
		    	issueObj.setIssueCategory(dbObject.getString("IssueCategory"));
		    	issueObj.setIssueAddress(dbObject.getString("IssueAddress"));
		    	issueObj.setIssueDescription(dbObject.getString("IssueDescription"));
		    	issueList.add(issueObj);
		    }
			
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		return(issueList);
	}
	public boolean saveUser(User userObj){
		boolean userSaved = false;
		String connURL=null;
		try{
			connURL = getServiceURI();
			//System.out.println("Connection URL : "+connURL);
		    MongoClient mongo = new MongoClient(new MongoClientURI(connURL));
		    DB db = mongo.getDB("db");
	    	String adminFlag = (userObj.isUserAdmin())?"Y":"N";
	        BasicDBObject doc = new BasicDBObject(constantss.USER_ID,userObj.getUserID())
	        .append(constantss.USER_PASSWORD, userObj.getUserPassword())
	        .append(constantss.USER_FIRSTNAME, userObj.getUserFirstName())
	        .append(constantss.USER_LASTNAME, userObj.getUserLastName())
	        .append(constantss.USER_ADDRESS, userObj.getUserAddress())
	        .append(constantss.USER_CONTACT, userObj.getUserContact())
	        .append(constantss.USER_ADMIN, adminFlag);
	        DBCollection table = null;
	        boolean userIdPresent = false;
		    try{
		        table = db.createCollection("User",doc);
		    }catch(Exception ex){
		    	table = db.getCollection("User");
		    	userIdPresent = isUserIdAlreadyRegistered(table,userObj.getUserID());
		    }
		    if(!userIdPresent){
			    table.insert(doc);
			    userSaved = true;
		    }
		    
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return(userSaved);
	}
	private boolean isUserIdAlreadyRegistered(DBCollection table,String userId){
		boolean userIdPresent = false;
		try{
			 BasicDBObject searchQuery = new BasicDBObject();
		     searchQuery.put(constantss.USER_ID, userId);
		     DBCursor cursor = table.find(searchQuery);
		     userIdPresent = cursor.hasNext();
		}catch(Exception ex){
			userIdPresent = false;
		}
		return(userIdPresent);
		
	}
	
	public boolean isUserPresent(User userObj){
		boolean userPresent = false;
		try{
			String connURL = getServiceURI();
		    MongoClient mongo = new MongoClient(new MongoClientURI(connURL));
		    DB db = mongo.getDB("db");
		    DBCollection table = db.getCollection("User");
		    BasicDBObject searchQuery = new BasicDBObject();
		    searchQuery.put(constantss.USER_ID, userObj.getUserID());
		    searchQuery.put(constantss.USER_PASSWORD, userObj.getUserPassword());
		    DBCursor cursor = table.find(searchQuery);
			userPresent = cursor.hasNext();
		}catch(Exception ex){
			userPresent = false;
			ex.printStackTrace();
			
		}
		return(userPresent);
	}
	  public String getServiceURI() throws Exception {
		   /* CloudEnvironment environment = new CloudEnvironment();
		   // List<Map<String,Object>> services= environment.getServices();
		    if ( environment.getServiceDataByLabels("mongodb-2.4").size() == 0 ) {
		        throw new Exception( "No MongoDB service is bund to this app!!" );
		    } 
		   // Map credential = (Map)((Map<String,Object>)(services.get(0))).get("credentials");

		   Map credential = (Map)((Map)environment.getServiceDataByLabels("mongodb-2.4").get(0)).get( "credentials" );
		 
		    return (String)credential.get( "url" );*/
		  //return("mongodb://1374dd73-87c6-4433-80ce-648f466ef551:1bfa7d37-bcf1-4468-a29a-6eeac6dbbc16@23.246.199.110:10008/db");
		  //return("mongodb://fef43aca-ceef-4f26-9a52-9891b4a98b13:40ce2bb0-ca2a-4d6d-8724-c2462fd7e0eb@23.246.199.108:10030/db");
		  return("mongodb://a93c9114-0411-4fb2-a79c-573849f10eb8:362fa956-7dbb-461a-9609-e4fdb10b47fa@23.246.199.108:10030/db");
		  }


}
