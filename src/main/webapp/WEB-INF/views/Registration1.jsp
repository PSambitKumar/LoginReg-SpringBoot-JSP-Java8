<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <link href="style/style.css" rel="stylesheet"/>
    <%--	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">--%>

    <!-- Fontawesome -->
    <link type="text/css" href="style/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet">
<title>Registration</title>
</head>
<body>
<!-- Section -->
<div class="section section-lg pt-4">
    <div class="container">
        <div class="row mb-4 mb-lg-5">
            <div class="col-lg-4 col-sm-6">

                <%--class="form-group mb-4"--%>
                <div class="form-group">
                    <label for="validationServer01">Full name</label>
                    <input type="text" class="form-control is-valid" id="validationServer01" required>
                    <div class="valid-feedback"></div>
                </div>

                <div class="form-group">
                    <label >Password</label>
                    <div class="input-group mb-4">
                        <input class="form-control"  placeholder="Password" type="password" aria-label="Password">
                        <div class="input-group-append">
                            <span class="input-group-text"><span class="fas fa-unlock-alt"></span></span>
                        </div>
                    </div>
                </div>


            </div>





            <div class="col-lg-4 col-sm-6">


                    <div class="form-group">
                        <label>Username</label>
                        <input type="text" class="form-control is-invalid" required>
                        <div class="invalid-feedback"></div>
                    </div>

                    <div class="form-group">
                        <label>Password</label>
                        <div class="input-group mb-4">
                            <input class="form-control"  placeholder="Password" type="password" aria-label="Password">
                            <div class="input-group-append">
                                <span class="input-group-text"><span class="fas fa-unlock-alt"></span></span>
                            </div>
                        </div>
                    </div>

            </div>






            <div class="col-lg-4 col-sm-6">

                <div class="form-group ">
                    <label>Email</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><span class="fas fa-envelope"></span></span>
                        </div>
                        <input class="form-control" id="exampleEmail712" placeholder="example@mail.com" type="email"  aria-label="Email" />
                    </div>
                </div>

                <div class="form-group">
                    <label>Department</label>
                    <div class="input-group mb-4">
                        <input class="form-control"  placeholder="Department" type="password" aria-label="Password">
                        <div class="input-group-append">
                            <span class="input-group-text"><span class="fas fa-building"></span></span>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>
</body>
</html>