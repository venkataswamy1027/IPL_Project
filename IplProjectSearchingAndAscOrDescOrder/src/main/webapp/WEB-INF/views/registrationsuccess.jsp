<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.button {
			border-collapse: collapse;
		    background-color:  #4CAF50;
		    border: 2px #3399ff;
		    color: yellow;
		    padding: 5px 25px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    margin: 2px auto;
		    cursor: pointer;
			}
			.button1 {border-radius: 12px;}
</style>
</head>
<h3><b style="color:red;">Your Registration Successfully Done => <b style="color:black;">${registration.userName}</b></b></h3>
<a href="/IplProjectSearchingAndAscOrDescOrder" class="button button1">Click TO Go Home Page</a><br>
</body>
</html>