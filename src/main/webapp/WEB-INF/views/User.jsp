<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Welcome User</title>
</head>
<body>
<h1 align="center">Welcome User</h1>
<table border = "1" align="center" class="table table-striped table-bordered" cellspacing="0">
    <thead>
    <tr>
        <th>Sl No</th>
        <th>Full Name</th>
        <th>Phone Number</th>
        <th>Email</th>
        <th>Date of Birth</th>
        <th>Department</th>
        <th>Gender</th>
    </tr>

    </thead>

    <tbody>
    <c:forEach items="${list}" var="e">
        <tr>
            <td>${e.slno}</td>
            <td>${e.name}</td>
            <td>${e.phn}</td>
            <td>${e.email}</td>
            <td>${e.dob}</td>
            <td>${e.dept}</td>
            <td>${e.gender}</td>
            <td>
                <a href = "/edit/${e.slno}">Edit</a>
                |
                <a href = "/delete/${e.slno}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>


    <tfoot>
    <tr>
        <td colspan="7" style="text-align: center;">
            <button class="btn btn-info btn-lg" onclick="window.location.href='${pageContext.request.contextPath}/Registration'">New Registration</button>
        </td>
    </tr>
    </tfoot>

</table>

<%--<div>--%>
<%--    <form:form action="imageData" method="post" modelAttribute="imageData">--%>
<%--        <div>--%>
<%--            <label>Upload Image Name:</label>--%>
<%--            <form:input type="text" path="imageName"/>--%>
<%--            <form:hidden path="imageId"/>--%>
<%--            <button>Submit</button>--%>
<%--        </div>--%>
<%--    </form:form>--%>
<%--</div>--%>

</body>
</html>