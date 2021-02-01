<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.zensar.beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EditAccountant</title>
<style>
body {
	text-align: center;
	font-size: 20px;
	font-style: italic;
	position: absolute;
	top: 45%;
	left: 50%;
	transform: translate(-50%, -50%);
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
	margin-top: 30px;
	background-color: navy;
	width: 50%;
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

.logoutButton {
	background-color: #F44336;
	width: 25%;
	color: white;
	height: 39px;
	font-style: italic;
	font-size: 20px;
	border-radius: 8px;
	margin-top: 30px;
}

table {
	border-spacing: 10px;
}

.logoutButton {
	background-color: #F44336;
	width: 40%;
	color: white;
	height: 39px;
	font-style: italic;
	font-size: 20px;
	border-radius: 8px;
}
</style>
</head>

<%
	Accountant accountant = (Accountant) request.getAttribute("accountant");
%>

<body>
	<h2>Edit Accountant Form</h2>
	<form action="updateAccountant">
		<!-- <input type="hidden"  name="requestAction" value="updateAccountant" /> -->
		<table>
			<tr>
				<td>Accountant Name:</td>
				<td><input type="text" name="accName"
					value="<%=accountant.getAccName()%>" /></td>
			</tr>

			<tr>
				<td>Email Id:</td>
				<td><input type="text" name="accEmail"
					value="<%=accountant.getAccEmail()%>" readonly="readonly"/></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="accPassword"
					value="<%=accountant.getAccPassword()%>" readonly="readonly" /></td>
			</tr>

			<tr>
				<td>Contact Number:</td>
				<td><input type="text" name="accContact"
					value="<%=accountant.getAccContact()%>" /></td>
			</tr>

		</table>
		<input type="submit" class="myButton" value="Edit Accountant" /><br>
		<br>
		<%
			if (request.getAttribute("message") != null) {
		%>
		<p><%=request.getAttribute("message")%></p>
		<%
			}
		%>
	</form>
	<form action="adminButtons">
		<input type="submit" class="logoutButton" name="requestAction" value="Logout Admin"> 
		<input type="submit" class="logoutButton" name="requestAction" value="Admin Panel">
	</form>
</body>
</html>