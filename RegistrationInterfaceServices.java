package com.deloitte.limatray.services;

import java.util.ArrayList;

import com.deloitte.limetray.model.Registration;



public interface RegistrationInterfaceServices {
	
	public void adduser(String username,String userid,String password,long phonenumber,String emailid);
	public ArrayList<Registration> displayuser();
	public boolean signinuser(String userid,String password);

}
