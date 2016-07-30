package com.bridgelabz.form;
import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
public class Registration 
{
	/*set the annotations to fields and generate user messages to the respective fields*/
	//add setters and getters
	@Pattern(regexp="[a-zA-Z]+")
	private String userName;
	@NotEmpty
	@Size(min=6,max=15)
	@Pattern(regexp="[a-zA-Z0-9]+")
	private String password;
	@NotEmpty
	@Size(min=6,max=15)
	@Pattern(regexp="[a-zA-Z0-9]+")
	private String confirmPassword;
	@NotEmpty
	@Email
	@Pattern(regexp="[a-z0-9@.]+")
	private String email;
	@NotEmpty
	@Size(min=10,max=10)
	@Pattern(regexp="[0-9]+")
	private String mobile;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
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

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

}