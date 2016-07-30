<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			.button2 {border-radius: 12px;}
			.button3 {border-radius: 12px;}
</style>
</head>
<body>
<h3><b style="color:red;">Your login success => <b style="color:black;">${loginForm.userName}</b></b></h3>
<a href=ipl.html class="button button1">Click TO Go IPL Information</a><br>
<a href="search.html?search_field=&search_item=" class="button button2">Click To Search Information</a><br>
<a href="sort.html?sort_field=&sort_order=" class="button button3">Click To Sort Player Information In Ascending Or Descending Order</a><br>
</body>
</html>
