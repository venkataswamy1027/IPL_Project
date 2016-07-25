<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team Info</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<style>
table,th,td { 
			border:1px solid #929395; 
			border-collapse:collapse;
}
th {
    border-bottom: 1px solid #929395;
}

tr{
    background:white;
}
</style>
</head>
<body>
<div data-role="page" id="pageone">
  <div data-role="header">
  </div>
  <div data-role="main" class="ui-content">
	<form action="playerlist" method="post">
		<table  data-role="table" class="ui-responsive ui-shadow" id="myTable" data-filter="true" data-input="#filterTable-input">
		<thead>
			<tr>
				<th data-priority="1"><b style="color:red;">Team ID</b></th>
				<th data-priority="2"><b style="color:red;">Team Name</b></th>
				<th data-priority="3"><b style="color:red;">Team Couch</b></th>
				<th data-priority="4"><b style="color:red;">Team Captain</b></th>
				<th data-priority="5"><b style="color:red;">Team Venue</b></th>
				<th data-priority="6"><b style="color:red;">Team Owner</b></tr>
				</tr>
				</thead>
				<c:forEach var="dd" items="${team}">

					<tr>
						<td>${dd.id}</td>
						<td>${dd.name}</td>
						<td>${dd.couch}</td>
						<td>${dd.captain}</td>
						<td>${dd.veneue}</td>
						<td>${dd.owner}</td>

					</tr>

				</c:forEach>
		</table>
		<br>
		</form>
</body>
</html>
