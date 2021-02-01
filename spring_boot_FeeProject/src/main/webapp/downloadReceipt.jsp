<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.zensar.beans.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

select {
	font-size: 15px;
	width: 100%;
	height: 30px;
}

table {
	width: 100%;
	text-align: left;
	background-color: aquamarine;
	padding: 20px;
	text-align: center;
	border: 1px dashed;
	border-spacing: 25px;
}

td {
	border-bottom: 1px dashed;
}
</style>

<title>Fee Receipt</title>
</head>
<body>
	<%
		Student student = (Student) request.getAttribute("student");
	%>

	<h4>
		THANKYOU for enrolling in
		<%=student.getStudCourse()%>
		course !
	</h4>
	<center>

		<h3>Student Details</h3>

		<table>
			<tr>
				<th style="color: #3F51B5;">Name :</th>
				<td><%=student.getStudName()%></td>
			</tr>
			<tr>
				<th style="color: #3F51B5;">Roll No</th>
				<td><%=student.getStudRoll()%></td>
			</tr>
			<tr>
				<th style="color: #3F51B5;">Gender</th>
				<td><%=student.getStudGender()%></td>
			</tr>
			<tr>
				<th style="color: #3F51B5;">Contact No.</th>
				<td><%=student.getStudContact()%></td>
			</tr>
			<tr>
				<th style="color: #3F51B5;">Email Id</th>
				<td><%=student.getStudEmail()%></td>
			</tr>
			<tr>
				<th style="color: #3F51B5;">Course</th>
				<td><%=student.getStudCourse()%></td>
			</tr>
			<tr>
				<th style="color: #3F51B5;">Total Fees</th>
				<td><%=student.getStudTotalFee()%></td>
			</tr>
			<tr>
				<th style="color: #3F51B5;">Paid Fees</th>
				<td><%=student.getStudPaidFee()%></td>
			</tr>
			<tr>
				<th style="color: #3F51B5;">Due Fees</th>
				<td><%=student.getStudDueFee()%></td>
			</tr>

		</table>
		<br> <br>
		<button type="button" name="myButton">Download</button>
	</center>

</body>
</html>