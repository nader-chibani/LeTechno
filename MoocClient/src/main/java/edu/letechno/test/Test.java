package edu.letechno.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.letechno.entity.User;
import edu.letechno.session.IUserSession;

public class Test {
	
	public static void main(String[] args) {
		Context context;
		try {
			
			context = new InitialContext();
			Object o= context.lookup("mooc/UserSession!edu.letechno.session.IUserSession");
			
			IUserSession user=(IUserSession) o ;
			User u = new User(1, "nader", "nader", "nader","nader", "nader", "nader");
			
			user.CreateUser(u);
			
		//	System.out.println("nom");
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
