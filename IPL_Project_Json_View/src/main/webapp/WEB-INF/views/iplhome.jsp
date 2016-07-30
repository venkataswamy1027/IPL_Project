<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IPL Home Page</title>
<style>
button {
	border: 2px solid #00ff00;
	-webkit-border-radius: 100px;
	-moz-border-radius: 100px;
	border-radius: 12px;
	font-size: 12px;
	font-family: arial, helvetica, sans-serif;
	padding: 10px 10px 10px 10px;
	text-decoration: none;
	display: inline-block;
	text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.30);
	font-weight: bold;
	color: #FFFFFF;
	background-color: #ff1493;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#3498db),
		to(#2980b9));
	background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
	background-image: -moz-linear-gradient(top, #3498db, #2980b9);
	background-image: -ms-linear-gradient(top, #3498db, #2980b9);
	background-image: -o-linear-gradient(top, #3498db, #2980b9);
	background-image: linear-gradient(to bottom, #3498db, #2980b9);
	filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,
		startColorstr=#3498db, endColorstr=#2980b9);
}

button {
	border: 2px solid #00ff00;
	background-color: #4CAF50;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#3cb0fd),
		to(#3498db));
	background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
	background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
	background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
	background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
	background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
	filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,
		startColorstr=#3cb0fd, endColorstr=#3498db);
}

table {
	font-family: 'Arial';
	margin: 15px auto;
	border-collapse: collapse;
	border: 2px solid #FF7373;
	border-bottom: 2px solid #FF7373;
	box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.50), 0px 10px 20px
		rgba(0, 0, 0, 0.10), 0px 20px 20px rgba(0, 0, 0, 0.10), 0px 30px 20px
		rgba(0, 0, 0, 0.10);
	tr
	{
	&
	:
	hover
	{
	
      
	background
	:
	 
	#f4f4f4;
	td
	{
	color
	:
	2px
	solid
	#00ff00;
}

}
}
th, td {
	border-color: 2px solid #00ff00;
	border: 2px solid #FF7373;
	padding: 20px 50px;
	border-collapse: collapse;
}

th {
	border-style: solid background: #ffb90f;
	border-color: 2px solid #ffb90f;
	text-transform: uppercase;
	font-size: 12px;
	&.
	last
	{
	border-right
	:
	none;
}
}
}
</style>
</head>
<center>

	<h1 style="color: #FE2E64;">Welcome To IPL 2016</h1>
	<br>
</center>
<table border="1" align="center" width="75%">
	<tr>
		<td><img src="<c:url value="/resources/images/DD.jpeg" />" alt=" "  style="width:150px; height:150;">
		</td>
		<td>
			<form action="teamnameinfo/DelhiDareDevils">
				<button type="submit" class="View  Team Info">Delhi
					Daredevils Team Information</button>
			</form>
		</td>

		<td>
			<form action="teamname/DelhiDareDevils">
				<button type="submit" class="View Player Info">Delhi
					Daredevils Players Information</button>
			</form>
		</td>
	</tr>
	<tr>
		<td>
		<img src="<c:url value="/resources/images/GL.gif" />" alt=" "  style="width:150px; height:150;">
		</td>
		<td>
			<form action="teamnameinfo/GujratLions">
				<button type="submit" class="View  Team Info">Gujarat Lions
					Team Information</button>
			</form>
		</td>

		<td>
			<form action="teamname/GujratLions">
				<button type="submit" class="View Player Info">Gujarat
					Lions Players Information</button>
			</form>
		</td>
	</tr>
	<tr>
		<td>
		<img src="<c:url value="/resources/images/KXIP.jpg" />" alt=" "  style="width:150px; height:150;">
		</td>
		<td>
			<form action="teamnameinfo/KingsXIPunjab">
				<button type="submit" class="View  Team Info">Kings XI
					Punjab Team Information</button>
			</form>
		</td>

		<td>
			<form action="teamname/KingsXIPunjab">
				<button type="submit" class="View Player Info">Kings XI
					Punjab Players Information</button>
			</form>
		</td>
	</tr>
	<tr>
		<td>
		<img src="<c:url value="/resources/images/KKR.jpg" />" alt=" "  style="width:150px; height:150;">
		</td>
		<td>
			<form action="teamnameinfo/KolkataKnightRiders">
				<button type="submit" class="View  Team Info">Kolkata
					Knight Riders Team Information</button>
			</form>
		</td>

		<td>
			<form action="teamname/KolkataKnightRiders">
				<button type="submit" class="View Player Info">Kolkata
					Knight Riders Players Information</button>
			</form>
		</td>
	</tr>
	<tr>
		<td>
		<img src="<c:url value="/resources/images/MI.jpg" />" alt=" "  style="width:180px; height:170;">
		</td>
		<td>
			<form action="teamnameinfo/MumbaiIndians">
				<button type="submit" class="View  Team Info">Mumbai
					Indians Team Information</button>
			</form>
		</td>

		<td>
			<form action="teamname/MumbaiIndians">
				<button type="submit" class="View Player Info">Mumbai
					Indians Players Information</button>
			</form>
		</td>
	</tr>
	<tr>
		<td>
		<img src="<c:url value="/resources/images/RPS.jpg" />" alt=" "  style="width:150px; height:150;">
		</td>
		<td>
			<form action="teamnameinfo/RisingPuneSupergiants">
				<button type="submit" class="View  Team Info">Rising Pune
					Supergiants Team Information</button>
			</form>
		</td>

		<td>
			<form action="teamname/RisingPuneSupergiants">
				<button type="submit" class="View Player Info">Rising Pune
					Supergiants Players Information</button>
			</form>
		</td>
	</tr>
	<tr>
		<td>
		<img src="<c:url value="/resources/images/RCB.jpg" />" alt=" "  style="width:150px; height:150;">
		</td>
		<td>
			<form action="teamnameinfo/RoyalChallengersBangalore">
				<button type="submit" class="View  Team Info">Royal
					Challengers Bangalore Team Information</button>
			</form>
		</td>

		<td>
			<form action="teamname/RoyalChallengersBangalore">
				<button type="submit" class="View Player Info">Royal
					Challengers Bangalore Players Information</button>
			</form>
		</td>
	</tr>
	<tr>
		<td>
		<img src="<c:url value="/resources/images/SRH.jpg" />" alt=" "  style="width:150px; height:150;">
		</td>
		<td>
			<form action="teamnameinfo/SunrisersHyderabad">
				<button type="submit" class="View  Team Info">Sunrisers
					Hyderabad Team Information</button>
			</form>
		</td>

		<td>
			<form action="teamname/SunriserHyderabad">
				<button type="submit" class="View Player Info">Sunrisers
					Hyderabad Players Information</button>
			</form>
		</td>
	</tr>
</table>
</body>
</html>