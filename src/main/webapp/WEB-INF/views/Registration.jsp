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

<div style="margin-left: 55%;" class="col-12 col-md-6 col-lg-5 mb-5 mb-lg-0">
    <div class="card bg-primary shadow-soft border-light p-4">
        <div class="card-header text-center pb-0">
            <h2 class="mb-0 h5">Create Account</h2>
        </div>
        <div class="card-body">
            <form:form action="Registration" method="post" modelAttribute="regBean">
                <!-- Form -->
                <div class="form-group">
                    <label for="exampleInputIcon999">Username</label>
                    <div class="input-group mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><span class="fas fa-user"></span></span>
                        </div>
                        <form:input path="username" class="form-control" id="exampleInputIcon999" placeholder="Username" type="text" aria-label="username"/>
                    </div>
                </div>
                <!-- End of Form -->
                <div class="form-group">
                    <!-- Form -->
                    <div class="form-group">
                        <label for="exampleInputPassword345">Password</label>
                        <div class="input-group mb-4">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span class="fas fa-unlock-alt"></span></span>
                            </div>
                            <form:input path="password" class="form-control" id="exampleInputPassword345" placeholder="Password" type="password" aria-label="Password"/>
                        </div>
                    </div>
                    <!-- End of Form -->
                    <!-- Form -->
                    <div class="form-group">
                        <label for="exampleConfirmPassword712">Confirm Password</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span class="fas fa-unlock-alt"></span></span>
                            </div>
                            <input class="form-control" id="exampleConfirmPassword712" placeholder="Confirm Password" type="password" aria-label="Password" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="exampleName712">Name</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span class="fas fa-pen"></span></span>
                            </div>
                            <form:input path="name" class="form-control" id="exampleName712" placeholder="Your Name" type="text" aria-label="Name" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="examplePhone712">Phone</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span class="fas fa-phone"></span></span>
                            </div>
                            <form:input path="phn" class="form-control" id="examplePhone712" placeholder="Phone Number" type="number" aria-label="Phone" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="exampleEmail712">Email Address</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span class="fas fa-envelope"></span></span>
                            </div>
                            <form:input path="email" class="form-control" id="exampleEmail712" placeholder="example@mail.com" type="email"  aria-label="Email" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="exampleDOB712">Date of Birth</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span class="fas fa-calendar"></span></span>
                            </div>
                            <form:input path="dob" class="form-control" id="exampleDOB712" placeholder="" type="date"  aria-label="DOB" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="exampleDept712">Department</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span class="fas fa-building"></span></span>
                            </div>
                            <form:input path="dept" class="form-control" id="exampleDept712" placeholder="Your Department" type="text"  aria-label="Department" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label>Select Gender</label>
                        <div class="input-group-prepend">
                        </div>
                        <div style="margin-left: 2rem">
                            <form:radiobutton path="gender" value = "Male"/>Male&nbsp;
                            <form:radiobutton path="gender" value = "Female"/>Female
                        </div>
                    </div>
                    <!-- End of Form -->
                    <div class="form-check mb-4">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck634">
                        <label class="form-check-label" for="defaultCheck634">
                            I agree to the <a href="#">terms and conditions</a>
                        </label>
                    </div>
                </div>
                <button type="submit" class="btn btn-block btn-primary">Register</button>
            </form:form>
            <div class="mt-3 mb-4 text-center">
                <span class="font-weight-normal">or</span>
            </div>
            <div class="btn-wrapper my-4 text-center">
                <button class="btn btn-primary btn-pill btn-icon-only text-facebook mr-2" type="button" aria-label="facebook button" title="facebook button">
                    <span aria-hidden="true" class="fab fa-facebook-f"></span>
                </button>
                <button class="btn btn-primary btn-pill  btn-icon-only text-twitter mr-2" type="button" aria-label="twitter button" title="twitter button">
                    <span aria-hidden="true" class="fab fa-twitter"></span>
                </button>
                <button class="btn btn-primary btn-pill btn-icon-only text-facebook" type="button" aria-label="github button" title="github button">
                    <span aria-hidden="true" class="fab fa-github"></span>
                </button>
            </div>
            <div class="d-block d-sm-flex justify-content-center align-items-center mt-4">
                            <span class="font-weight-normal">
                                Already have an account?
                                <a href="Login" class="font-weight-bold">Login here</a>
                            </span>
            </div>
        </div>
    </div>
</div>


<%--	<table align="center">--%>
<%--		<thead>--%>
<%--			<tr>--%>
<%--				<td colspan="2" style="text-align: center;">Registration Here</td>--%>
<%--			</tr>--%>
<%--		</thead>--%>
<%--		<tbody>--%>
<%--			<form:form action="Registration" method="post" modelAttribute="regBean">--%>
<%--				<tr>--%>
<%--					<td>Username:</td>--%>
<%--					<td><form:input path="username"/></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<td>Password:</td>--%>
<%--					<td><form:input path="password"/></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<td>Full Name:</td>--%>
<%--					<td><form:input path="name"/></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<td>Phone Number::</td>--%>
<%--					<td><form:input path="phn"/></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<td>Email:</td>--%>
<%--					<td><form:input path="email"/></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<td>Date of Birth:</td>--%>
<%--					<td><form:input type="date" path="dob"/></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<td>Department:</td>--%>
<%--					<td><form:input path="dept"/></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<td colspan="2">Select Gender: <form:radiobutton path="gender" value = "Male"/>Male&nbsp;--%>
<%--						<form:radiobutton path="gender" value = "Female"/>Female&nbsp;<br/></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<td style="text-align: center;">--%>
<%--						<button >Register</button>--%>
<%--					</td>--%>
<%--					<td style="text-align: center;">--%>
<%--						<button type="reset">Reset</button>--%>
<%--					</td>--%>
<%--				</tr>--%>
<%--			</form:form>--%>
<%--		</tbody>--%>
<%--		<tfoot>--%>
<%--			<tr>--%>
<%--				<td>Already a User: </td>--%>
<%--				<td>&emsp;&emsp;<a href = "/Login">Login</a></td>--%>
<%--			</tr>--%>
<%--		</tfoot>--%>
<%--	</table>--%>
	
</body>
</html>