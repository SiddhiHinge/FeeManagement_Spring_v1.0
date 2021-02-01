<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {
	text-align: center;
	font-size: 20px;
	font-style: italic;
}

.login1 {
	width: 35%;
	float: left;
	margin-top: 75px;
	margin-left: 150px;
}

.login2 {
	width: 35%;
	float: right;
	margin-top: 75px;
	margin-right: 150px;
}

h2 {
	text-align: center;
	font-style: oblique;
	font-size: 30px;
}

form {
	width: 90%;
	margin: auto;
	padding: 35px;
	border-radius: 15px;
	background-color: #E0F7FA;
}

p {
	color: red;
	font-size: 20px;
}

.myButton {
	background-color: navy;
	width: 35%;
	color: white;
	height: 35px;
	font-style: italic;
	font-size: 20px;
	border-radius: 8px;
}

input {
	font-family: monospace;
	font-size: 18px;
	text-align: center;
}

table {
	border-spacing: 10px;
}
</style>
<title>Change Password</title>
</head>
<body>
	<h1>Change Password</h1>

	<%
		String message1 = (String) request.getAttribute("message1");
		if (message1 != null) {
	%>
	<h3 style="color: red"><%=message1%></h3>
	<%
		}
	%>

	<form action="changePassword">
		<table>
			<tr>
				<th>Roll Number</th>
				<th><input type="text" name="studRoll"></th>
			</tr>
			<tr>
				<th>Enter Old Password</th>
				<th><input type="password" name="oldPassword"></th>
			</tr>
			<tr>
				<th>Enter New Password</th>
				<th><input type="password" name="newPassword"></th>
			</tr>
			<tr>
				<th>Confirm Password</th>
				<th><input type="password" name="confirmPassword"></th>
			</tr>
		</table>
		<input type="submit" class="myButton" value="Change Password">
	</form>
</body>
</html>