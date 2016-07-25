<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.button {
		    background-color:  #4CAF50;
		    border: none;
		    color: yellow;
		    padding: 5px 25px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    margin: 5px 5px;
		    cursor: pointer;
			}
			.button1 {border-radius: 12px;}
</style>
</head>
<body>
<center>
<h1><b style="color:#0F73DE">User Registration Form</b></h1>
<form:form method="post" action="registrationform.html"  modelAttribute="registration"
	commandName="registration">
	<table>
		<tr>
			<td>User Name:<FONT color="red"><form:errors
				path="userName" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="userName" /></td>
		</tr>

		<tr>
			<td>Password:<FONT color="red"><form:errors
				path="password" /></FONT></td>
		</tr>
		<tr>
			<td><form:password path="password" /></td>
		</tr>

		<tr>
			<td>Confirm Password:<FONT color="red"><form:errors
				path="confirmPassword" /></FONT></td>
		</tr>
		<tr>
			<td><form:password path="confirmPassword" /></td>
		</tr>

		<tr>
			<td>Email:<FONT color="red"><form:errors path="email" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Mobile No:<FONT color="red"><form:errors path="mobile" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="mobile" /></td>
		</tr>
		<tr>
			<td><input type="submit" class="button button1" value="Submit"/></td>
		</tr>
	</table>
</form:form>
</center>
</body>
</html>