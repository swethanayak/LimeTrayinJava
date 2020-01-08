package com.deloitte.limetray.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.deloitte.limatray.services.RegistrationServiceImpl;
import com.deloitte.limetray.model.Registration;

public class RegistrationDemo {

	public static void main(String atgs[]) {
		
		RegistrationServiceImpl objimpl = new RegistrationServiceImpl();
		List<Registration> list = new ArrayList<Registration>();
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("1.Sign up registration.");
		System.out.println("2.Display User Details.");
		System.out.println("3.Exit.");
		System.out.println("4.Sign in.");
		String choice = sc.next();
		
		switch (Integer.parseInt(choice)) {
		
		case 1:
			System.out.println("Enter your Name: ");
			 String username = sc.next();
			 System.out.println("Enter your UserId: ");
			 String userid = sc.next();
			 System.out.println("Enter your Password: ");
			 String password = sc.next();
			 System.out.println("Enter your PhoneNumber: ");
			 long phonenumber = Long.parseLong(sc.next());
			 System.out.println("Enter your Email-id: ");
			 String emailid = sc.next();
			 objimpl.adduser(username,userid,password,phonenumber,emailid);
			 break;
			 
		case 2:
			
			list = objimpl.displayuser();
			if(list.size()>1) {
			for (Registration obj : list) {
				System.out.println(obj);
			}}
			else
			{
				System.out.println("No Users to display");
			}
			break;
			
		case 3:
			sc.close();
			System.exit(0);
			break;
			
		case 4:
			System.out.println("Enter your UserId: ");
			 String userid1 = sc.next();
			 System.out.println("Enter your Password: ");
			 String password1 = sc.next();
			 boolean flag = objimpl.signinuser(userid1,password1);
				if(flag) {
					System.out.println("SignIn successful!! ");
					}
				else {
					System.out.println("Invalid User!!");
					}
			 break;
			 
		}
	}
		
		
	}
}
