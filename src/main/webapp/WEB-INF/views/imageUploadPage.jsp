<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Image Upload Database</title>
<%--    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>--%>
<%--    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>--%>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>
<%--<div class="alert alert-primary" role="alert">--%>
<%--    A simple primary alert—check it out!--%>
<%--</div>--%>

<%--Working Fine--%>
<%--<c:if test="${flashMessage ne Empty}">--%>
<%--    <script>swal("${flashMessage}");</script>--%>
<%--</c:if>--%>

<%--<c:if test="${flashMessage ne Empty}">--%>
<%--    <script>swal("Good job!", "${flashMessage}", "danger");</script>--%>
<%--</c:if>--%>


<%--Working Fine--%>
<%--<c:if test="${flashMessage ne Empty}">--%>
<%--    <script>--%>
<%--        swal({--%>
<%--            title: "Are you sure?",--%>
<%--            text: "Once deleted, you will not be able to recover this imaginary file!",--%>
<%--            icon: "warning",--%>
<%--            buttons: true,--%>
<%--            dangerMode: true,--%>
<%--        })--%>
<%--            .then((willDelete) => {--%>
<%--                if (willDelete) {--%>
<%--                    swal("Poof! Your imaginary file has been deleted!", {--%>
<%--                        icon: "success",--%>
<%--                    });--%>
<%--                } else {--%>
<%--                    swal("Your imaginary file is safe!");--%>
<%--                }--%>
<%--            });--%>
<%--    </script>--%>
<%--</c:if>--%>


<c:if test="${flashMessage ne Empty}">
    <script>swal("Successful", "${flashMessage}", "success")</script>
</c:if>

<form action="/saveImage" method="post" enctype="multipart/form-data">
    <div class="container col-md-4" style="margin-top: 4rem">
        <div class="row">
            <div class="col-md-9">
                <label for="Image" class="form-label">Upload Your Image:</label>
                <input class="form-control" type="file" id="Image" onchange="preview()" name="imageData">
                <small style="color: orangered">(.jpg/.jpeg/.gif only & Max size 500 KB)</small>
                <div>
                    <button type="submit" class="btn btn-primary mt-3" style="width: 25%">Submit</button>
                    <button type="reset" class="btn btn-danger mt-3">Reset</button>
                </div>
            </div>
            <div class="col-md-3">
                <img src="images/default.jpg" id="frame" class="img-fluid">
            </div>
        </div>
    </div>
</form>

<script>
    function preview() {
        frame.src = URL.createObjectURL(event.target.files[0]);
    }

</script>
</body>
</html>