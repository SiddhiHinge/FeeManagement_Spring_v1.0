<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.design {
	text-align: center;
	font-size: 25px;
	font-style: italic;
	padding: 20px;
	border-radius: 20px;
	background-color: #E0F7FA;;
	width: 50%;
	padding: 15px;
	height: 420px;
	margin: auto;
	border: 3px dashed black;
	position: absolute;
	top: 45%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.myButton {
	background-color: #F44336;
    width: 30%;
    color: white;
    height: 39px;
	font-style: italic;
	font-size: 20px;
	border-radius: 8px;
}
</style>
<title>Student Panel</title>
</head>
<body>
<form action="logoutStudent">
<div class="design">
		<h2 style="color: #E91E63;">Welcome Student !</h2>
		<%int studRoll = (int) request.getAttribute("studRoll"); %>
		<a href="viewStudent?studRoll=<%=studRoll %>" >View Profile</a><br><br>
		<a href="changePasswordForm">Change Password</a><br><br>
 		
		<input type="submit" class="myButton" name = "requestAction" value="Logout Student">
	</div>
</form>
</body>
</html>