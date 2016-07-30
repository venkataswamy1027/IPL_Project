<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team Info</title>
</head>
<body>
	<form action="playerlist" method="post">
		<table border="3" bordercolor="#c86260" bgcolor="#ffffcc" cellpadding="3"  width="70%">
			<tr>
				<th><b style="color:red;">Team Name</b></th>
				<th><b style="color:red;">Team Couch</b></th>
				<th><b style="color:red;">Team Captain</b></th>
				<th><b style="color:red;">Team Venue</b></th>
				<th><b style="color:red;">Team Owner</b></tr>
				<c:forEach var="dd" items="${ddteam}">

					<tr>
						<td>${dd.name}</td>
						<td>${dd.couch}</td>
						<td>${dd.captain}</td>
						<td>${dd.veneue}</td>
						<td>${dd.owner}</td>

					</tr>

				</c:forEach>
		</table>
		<br />
		</form>
</body>
</html>
