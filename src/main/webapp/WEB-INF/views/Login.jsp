<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<link href="style/style.css" rel="stylesheet"/>

	<%--    Bootstrap for Design--%>
<%--	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>
	<%--    For Validation--%>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<%--    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">--%>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
	<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>


<%--	Bootstrap icons--%>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<%--	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">--%>

	<!-- Fontawesome -->
	<link type="text/css" href="style/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet">

	<title>Sign In</title>
</head>
<body>

<script>

	$(document).ready(function (){
		$('#submit').click(function (e){
			var username_regX = /^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$/;
			var password_regX = /^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\d]){1,})(?=(.*[\W]){1,})(?!.*\s).{8,}$/;
			var alphaNumeric_regX = /[a-zA-Z0-9]{6,18}/;

			var username = $('#usernameInput').val();
			var password = $('#passwordInput').val();

			if(username.length == 0){
				$('#userError').text("Username Must not be Empty.").css('color', 'red');
				$('#usernameInput').focus();
				$('#usernameInput').css('border', '2px solid red');
				return false;
			}
			else if(!username.match(username_regX)){
				$('#userError').text("Username Must be Alphanumeric and 6-18 Characters.").css('color', 'red');
				$('#usernameInput').focus();
				$('#usernameInput').css('border', '2px solid red');
				return false;
			}
			else if(password.length == 0){
				$('#userError').text("Looks Good!").css('color', 'green');
				$('#usernameInput').css('border', '2px solid green');
				$('#passworderror').text("Password Must not be Empty").css('color', 'red');
				$(this).focus();
				$('#passwordInput').css('border', '2px solid red');
				return false;
			}
			else if (!password.match(password_regX)){
				$('#passworderror').text("Password Must be 8 Characters, and contains atleast one digit, one Upper letter and one Special Characters.").css('color', 'red');
				$(this).focus();
				$('#passwordInput').css('border', '2px solid red');
				return false;
			}
			else {
				$('#passworderror').text("Looks Good!").css('color', 'green');
				$('#passwordInput').css('border', '2px solid green');
				return true;
			}
		});
	});

</script>

<div style="margin-left: 55%;" class="col-12 col-md-6 col-lg-5 mb-5 mb-lg-0">
	<div class="card bg-primary shadow-soft border-light p-4">
		<div class="card-header text-center pb-0">
			<h2 class="h4">Sign In</h2>
			<span>Login here using your username and password</span>
		</div>
		<div class="card-body">
			<form:form id="loginForm" method="post" modelAttribute="loginBean" class="mt-4">
				<!-- Form -->
				<div class="form-group">
					<label>Your Usename</label>
					<div class="input-group mb-4">
						<div class="input-group-prepend">
							<span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
																							<path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
																							</svg></span>
						</div>
						<form:input class="form-control" id="usernameInput" placeholder="Username" type="text" aria-label="username" path="username"/>
					</div>
					<div id="userError"></div>
				</div>

				<!-- End of Form -->
				<div class="form-group">
					<!-- Form -->
					<div class="form-group">
						<label for="">Password</label>
						<div class="input-group mb-4">
							<div class="input-group-prepend">
								<span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">
																							  <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>
																							</svg></span></span>
							</div>
							<form:input path="password" class="form-control" id="passwordInput" placeholder="Password" type="password" aria-label="Password" />
						</div>
						<div id="passworderror"></div>
					</div>


					<!-- End of Form -->
					<div class="d-block d-sm-flex justify-content-between align-items-center mb-4">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value="" id="defaultCheck545">
							<label class="form-check-label" for="defaultCheck545">
								Remember me
							</label>
						</div>
						<div><a href="#" class="small text-right">Forget password?</a></div>
					</div>
				</div>
<%--				<span style="margin-right: 1rem"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">--%>
<%--																																													  <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>--%>
<%--																																													</svg></span>--%>
				<button type="submit" id="submit"  style="font-size: 18px" class="btn btn-block btn-primary">Sign in</button>
			</form:form>
			<div class="mt-3 mb-4 text-center">
				<span class="font-weight-normal">or login with</span>
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
				<button style="margin-left: 7px" class="btn btn-primary btn-pill btn-icon-only text-google" type="button" aria-label="google button" title="google button">
					<span aria-hidden="true" class="fab fa-google"></span>
				</button>
			</div>
			<div class="d-block d-sm-flex justify-content-center align-items-center mt-4">
                            <span class="font-weight-normal">
                                Not registered?
                                <a href="Registration" style="color: blue" class="font-weight-bold">Create account</a>
                            </span>
			</div>
		</div>
	</div>
</div>
	
<%--	<table align="center">--%>
<%--		<thead>--%>
<%--			<tr>--%>
<%--				<td colspan="2"><div style="text-align: center;">Login Here</div><br></td>--%>
<%--			</tr>--%>
<%--		</thead>--%>
<%--		<tbody>--%>
<%--			<form:form action="Login" method="post" modelAttribute="loginBean">--%>
<%--				<tr>--%>
<%--					<td>UserName:</td>--%>
<%--					<td><form:input path="username"/></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<td>Password:</td>--%>
<%--					<td><form:input path="password"/></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<td>&emsp;&emsp;&emsp;<button>Login</button></td>--%>
<%--					<td>&emsp;&emsp;<button type="reset">Reset</button></td>--%>
<%--				</tr>--%>
<%--			</form:form>--%>
<%--		</tbody>--%>
<%--		<tfoot>--%>
<%--			<tr>--%>
<%--				<td><center>New User: </center></td>--%>
<%--				<td><a href = "/Registration">Register Here</a></td>--%>
<%--			</tr>--%>
<%--		</tfoot>--%>
<%--	</table>--%>
	
</body>
</html>