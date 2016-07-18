package com.bridgelabz.dao;
import com.bridgelabz.model.*;

public interface LoginDAO{    
      public boolean checkLogin(String userName, String userPassword);
	public void addUser(Users user);
	public boolean checkEmail(String emai);
	public boolean checkUserName(String userName);

}