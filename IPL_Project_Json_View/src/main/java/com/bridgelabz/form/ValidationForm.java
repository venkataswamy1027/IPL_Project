package com.bridgelabz.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class ValidationForm {
	/*set the annotations to fields and generate user messages to the respective fields*/
	//add seters and getters
	@NotEmpty
	@Size(min = 1, max = 20)
	@Pattern(regexp="[a-zA-Z]+")
	private String userName;
	@NotNull
	@NumberFormat(style = Style.NUMBER)
	@Min(1)
	@Max(110)
	private Integer age;
	@NotEmpty(message = "Password must not be blank.")
	@Size(min = 1, max = 10)
	private String password;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
