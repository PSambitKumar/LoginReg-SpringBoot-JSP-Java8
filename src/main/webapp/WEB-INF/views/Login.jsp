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
				<td colspan="2"><div style="text-align: center;">Login Here</div><br></td>
			</tr>
		</thead>
		<tbody>
			<form:form action="Login" method="post" modelAttribute="loginBean">
				<tr>
					<td>UserName:</td>
					<td><form:input path="username"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="password"/></td>
				</tr>
				<tr>
					<td>&emsp;&emsp;&emsp;<button>Login</button></td>
					<td>&emsp;&emsp;<button type="reset">Reset</button></td>
				</tr>
			</form:form>
		</tbody>
		<tfoot>
			<tr>
				<td><center>New User: </center></td>
				<td><a href = "/Registration">Register Here</a></td>
			</tr>
		</tfoot>
	</table>
	
</body>
</html>