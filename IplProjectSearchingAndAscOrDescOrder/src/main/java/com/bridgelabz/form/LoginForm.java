package com.bridgelabz.form;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
public class LoginForm {
	//set the annotations and generate user messages
		//add setters and getters
	@NotEmpty
	@Size(min = 1, max = 20)
	private String userName;
	@NotEmpty
	@Size(min = 1, max = 20)
	private String password;
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
}
