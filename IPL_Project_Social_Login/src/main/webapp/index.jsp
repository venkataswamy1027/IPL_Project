<%@page import="com.bridgelabz.controllers.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	FBConnection fbConnection = new FBConnection();
%>
<html>
<head>
<br>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/4.10.0/bootstrap-social.min.css" />
<style type="text/css">
	body{ front-family:verdana;font-size:15px; }
	div#back_glob{ background-color:white; width:350px; margin:2px auto; box-shadow:0px 0px 15px #4B91D7; }
	input{ display:block; margin:10px; }
	div#back_header{ background-color:#48A6DF; text-align:center; front-size:22px; font-weight:bold; color:white; padding:20px; }
	div#back_form { display:flex; jestify-content: center; }
	.button {
			border-collapse: collapse;
		    background-color: #48A6DF;
		    border: 7px #3399ff ;
		    color:white;
		    padding: 7px 25px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    margin: 10px 110px;
		    cursor: pointer;
			}
			.button1 {border-radius: 4px;}
			.button2 {border-radius: 4px;}
</style>
</head>
<center>
<body>
	<div style="margin-left:auto; margin-right:auto;">
	<div id="back_glob">
	<div id="back_header">
	<h4><b style="color:white">IPL 2016 APPLICATION</b></h4>
	</div>
	<a href="loginform.html"class="button button1">Sign In</a><br>
	<a href="registrationform.html" class="button button2">Sign Up</a>
	<table>
	<h3><b style="color:#C23A4F">Sign in with</b></h3><br>
	<tr>
					<td style="padding-left: 10px;">
						<a href="<%=fbConnection.getFBAuthUrl()%>"><img src="resources/images/facebookloginbutton.png" />
					</td>
	</tr>
				</table>
				<br>
				</div>
</body>
</center>
</html>