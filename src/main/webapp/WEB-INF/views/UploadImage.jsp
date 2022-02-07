<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 2/7/2022
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <title>Uplaod Image</title>
</head>
<body>
<h4 style="text-align: center">Welcome Image Upload Page</h4>
<form th :object="${imageBean}" action="UploadImageData" method="post" enctype="multipart/form-data">
    <form:input type="file" name="image" accept="image/png, image/jpeg" cssStyle="alignment: center" path="imageName"/>
    <button>Submit</button>
</form>
</body>
</html>
