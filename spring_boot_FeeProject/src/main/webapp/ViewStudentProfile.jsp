<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.zensar.beans.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {
	text-align: center;
	font-size: 25px;
	font-style: italic;
}
.design1 {
    width: 75%;
    background-color: #E0F7FA;
    margin: auto;
    padding: 35px;
    border: 2px dashed black;
    border-radius: 30px;
    position: absolute;
    top: 45%;
    left: 50%;
    transform: translate(-50%, -50%);}
    
table {
    border-spacing: 0px;
    width: 100%;
    margin: auto;
    border: 1px solid;
    font-size: 20px;
}

.myButton {
	background-color: #F44336;
    width: 20%;
    color: white;
    height: 39px;
	font-style: italic;
	font-size: 20px;
	border-radius: 8px;
	margin-top: 30px;
}
</style>

<title>Student Profile</title>
</head>
<body>
	<div class="design1">
		<h2>Profile</h2>

		<%
			Student student = (Student) request.getAttribute("student");
		%>

		<table border="1">
			<tr style="color: #3F51B5;">
				<th>Name</th>
				<td><%=student.getStudName()%></td>
			</tr>
			<tr>
				<th>Roll No</th>
				<td><%=student.getStudRoll()%></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><%=student.getStudGender()%></td>
			</tr>
			<tr>
				<th>Contact No.</th>
				<td><%=student.getStudContact()%></td>
			</tr>
			<tr>
				<th>Email Id</th>
				<td><%=student.getStudEmail()%></td>
			</tr>
			<tr>
				<th>Course</th>
				<td><%=student.getStudCourse()%></td>
			</tr>
			<tr>
				<th>Total Fees</th>
				<td><%=student.getStudTotalFee()%></td>
			</tr>
			<tr>
				<th>Paid Fees</th>
				<td><%=student.getStudPaidFee()%></td>
			</tr>
			<tr>
				<th>Due Fees</th>
				<td><%=student.getStudDueFee()%></td>
			</tr>
			<tr>
			<td>
			<a href="downloadFeeReceipt?studRoll=<%=student.getStudRoll() %>">Download Fee Receipt</a>
			</td>
			</tr>
		</table>
		<form action="logoutStudent">
			<input type="submit" class="myButton" name="requestAction"
				value="Student Panel">
		</form>
	</div>
</body>
</html>