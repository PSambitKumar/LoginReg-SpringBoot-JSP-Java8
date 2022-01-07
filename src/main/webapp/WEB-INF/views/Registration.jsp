<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<title>Home</title>
</head>
<body>
	
	<table align="center">
		<thead>
			<tr>
				<td colspan="2" style="text-align: center;">Registration Here</td>
			</tr>
		</thead>
		<tbody>
			<form:form action="Registration" method="post" modelAttribute="regBean">
				<tr>
					<td>Username:</td>
					<td><form:input path="username"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password"/></td>
				</tr>
				<tr>
					<td>Full Name:</td>
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td>Phone Number::</td>
					<td><form:input path="phn"/></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td><form:input type="date" path="dob"/></td>
				</tr>
				<tr>
					<td>Department:</td>
					<td><form:input path="dept"/></td>
				</tr>
				<tr>
					<td colspan="2">Select Gender: <form:radiobutton path="gender" value = "Male"/>Male&nbsp;
						<form:radiobutton path="gender" value = "Female"/>Female&nbsp;<br/></td>
				</tr>
				<tr>
					<td style="text-align: center;">
						<button >Register</button>
					</td>
					<td style="text-align: center;">
						<button type="reset">Reset</button>
					</td>
				</tr>
			</form:form>
		</tbody>
		<tfoot>
			<tr>
				<td>Already a User: </td>
				<td>&emsp;&emsp;<a href = "/Login">Login</a></td>
			</tr>
		</tfoot>
	</table>
	
</body>
</html>