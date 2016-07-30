<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Player List</title>
</head>
<body>
	<form action="playerlist" method="post">
		<table border="3" bordercolor="#c86260" bgcolor="#ffffcc" cellpadding="3" width="70%">
			<tr>
				<th><b style="color:red;">Player Name</b></th>
				<th><b style="color:red;">Player Role</b></th>
				<th><b style="color:red;">Player Batting Style</b></th>
				<th><b style="color:red;">Player Bowling Style</b></th>
				<th><b style="color:red;">Player Nation</b></th>
				<th><b style="color:red;">Player Date Of Birth</b></th>
			</tr>
			<c:forEach var="playerlist" items="${playerlist}">
				<tr>
					<td>${playerlist.name}</td>
					<td>${playerlist.role}</td>
					<td>${playerlist.batting}</td>
					<td>${playerlist.bowler}</td>
					<td>${playerlist.nation}</td>
					<td>${playerlist.dob}</td>				
				</tr>

			</c:forEach>
		</table>
		<br />
		</form>
</body>
</html>