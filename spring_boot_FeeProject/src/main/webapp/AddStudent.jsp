<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/FormStyle.css">
<title>AddStudent</title>
</head>
<body>
	<form class="myForm" action="addStudent" method="post">
		<h2>Add Student Form</h2>
		<!-- <input type="hidden" name="requestAction" value="addStudent" /> -->
		<table>

			<tr>
				<td>Name :</td>
				<td><input type="text" name="studName" /></td>
			</tr>

			<tr>
				<td>Roll No. :</td>
				<td><input type="text" name="studRoll" /></td>
			</tr>

			<tr>
				<td>Gender :</td>
				<td>Male<input type="radio" name="studGender" value="Male">
					Female<input type="radio" name="studGender" value="Female">
				</td>

			</tr>

			<tr>
				<td>Email-ID :</td>
				<td><input type="text" name="studEmail" /></td>
			</tr>

			<tr>
				<td>Course :</td>
				<td><select name="studCourse" id="stud_Course">
						<option value="C">C</option>
						<option value="C++">C++</option>
						<option value="Java">Java</option>
						<option value="AngularJS">AngularJS</option>
						<option value="Python">Python</option>
				</select></td>
			</tr>

			<tr>
				<td>Contact No.:</td>
				<td><input type="text" name="studContact" /></td>
			</tr>

			<tr>
				<td>Total Fees :</td>
				<td><input type="text" name="studTotalFee" /></td>
			</tr>

			<tr>
				<td>Paid Fees :</td>
				<td><input type="text" name="studPaidFee" /></td>
			</tr>

		</table>
		<input type="submit" class="myButton" value="Add Student" />
		<%
			if (request.getAttribute("message") != null) {
		%>
		<p><%=request.getAttribute("message")%></p>
		<%
			}
		%>
	</form>
	<form action="accountantButtons" class = "commonForm">
		<table>
			<tr>
				<td><input type="submit" class="logoutButton"
					name="requestAction" value="Logout Accountant"></td>
				<td><input type="submit" class="logoutButton"
					name="requestAction" value="Accountant Panel"></td>
			</tr>
		</table>
	</form>

</body>
</html>