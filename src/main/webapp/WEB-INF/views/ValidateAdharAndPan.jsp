<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 2/2/2022
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Personal Details</title>
</head>
<body>
    <h4 style="text-align: center">Fill Personal Details</h4>
    <form:form action="AddPersonalData" method="post" modelAttribute="personalDataBean">
        <div style="margin: auto" class="form-group col-md-8">

            <div class="form-group row">

                <div class="col-md-4">
                    <label class="form-label" for="inputName">Name</label>
                    <form:input path="name" type="text" class="form-control" id="inputName" placeholder="Enter Name"/>
                    <small class="form-text text-muted" >Name must not contains number</small>
                </div>

                <div class="col-md-4">
                    <label class="form-label" for="inputName">Pan Card ID</label>
                    <form:input path="panId" type="text" class="form-control" id="inputPan" placeholder="Enter Pan Card ID"/>
                    <small class="form-text text-muted">Personal details are don't shared</small>
                </div>

                <div class="col-md-4">
                    <label class="form-label" for="inputName">Adhar Card ID</label>
                    <form:input path="adharNo" type="text" class="form-control" id="inpurAdhar" placeholder="Enter Adhar Card ID"/>
                    <small class="form-text text-muted">Enter 16 digit adhar card number</small>
                </div>

            </div>

            <form:hidden path="pid"/>

            <div style="margin: auto; margin-top: 20px" class="form-group row col-md-3">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

        </div>
    </form:form>
</body>
</html>
