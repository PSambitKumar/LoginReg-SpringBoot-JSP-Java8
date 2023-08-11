<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 2/8/2022
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <%--    Bootstrap for Design--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%--    For Validation--%>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <%--    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">--%>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
    <title>View Personal Details</title>
</head>
<body style="margin: auto">
    <h4 style="text-align: center">All Personal Details</h4>

    <table border = "1" align="center" class="table table-striped table-bordered" cellspacing="0">
        <thead>
        <tr>
            <th>Sl No</th>
            <th>Name</th>
            <th>Pan Card No.</th>
            <th>Adhar No.</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var="e">
            <tr>
                <td>${e.pid}</td>
                <td>${e.name}</td>
                <td>${e.panId}</td>
                <td>${e.adharNo}</td>
                <td>
                    <a href = "/edit/${e.pid}">Edit</a>
                    |
                    <a href = "/delete/${e.pid}">Delete</a>
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
</body>

<script>
</script>
</html>
