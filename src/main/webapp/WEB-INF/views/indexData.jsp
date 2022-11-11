<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 11/11/2022
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Image Upload Database</title>


    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <%--    <script>var pageContext = "${pageContext.request.contextPath}"</script>--%>

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>

<form action="${pageContext.request.contextPath}/downloadZipFile" method="post">
    <div class="container col-md-4" style="margin-top: 4rem">
        <div class="row">
            <div class="col-md-9">
                <label for="Image" class="form-label">Click Here To Download Zip</label>
                <div>
                    <button type="submit" class="btn btn-primary mt-3" style="width: 25%" id="Image">Download</button>
                </div>
            </div>
        </div>
    </div>
</form>

</body>
</html>
