<head>
    <title>Image Upload Database</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>
<%--<div class="alert alert-primary" role="alert">--%>
<%--    A simple primary alert—check it out!--%>
<%--</div>--%>

<form action="/saveImage" method="post" enctype="multipart/form-data">
    <div class="container col-md-4" style="margin-top: 4rem">
        <div class="row">
            <div class="col-md-9">
                <label for="Image" class="form-label">Upload Your Image:</label>
                <input class="form-control" type="file" id="Image" onchange="preview()" name="imageData">
                <small style="color: red">(.jpg/.jpeg/.gif only & Max size 500 KB)</small>
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
    function saveImage() {

    }
</script>
</body>
</html>