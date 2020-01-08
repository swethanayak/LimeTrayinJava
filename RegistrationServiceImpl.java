package com.deloitte.limatray.services;

import java.util.ArrayList;

import com.deloitte.limetray.dao.RegistrationDAO;
import com.deloitte.limetray.model.Registration;

public class RegistrationServiceImpl implements RegistrationInterfaceServices{

	@Override
	public void adduser(String username, String userid, String password,long phonenumber, String emailid) {
		// TODO Auto-generated method stub
		Registration obj = new Registration();
		obj.setUsername(username);
		obj.setUserid(userid);
		obj.setPassword(password);
		obj.setPhonenumber(phonenumber);
		obj.setEmailid(emailid);
		RegistrationDAO.adduser(obj);
		
		
	}

	@Override
	public ArrayList<Registration> displayuser() {
		// TODO Auto-generated method stub
		return RegistrationDAO.displayuser();
	}

	@Override
	public boolean signinuser(String userid, String password) {
		// TODO Auto-generated method stub
		
		return RegistrationDAO.signinuser(userid, password);
	}
	

}
