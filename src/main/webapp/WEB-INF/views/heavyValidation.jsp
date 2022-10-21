<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 10/11/2022
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title>Title</title>
<%--    <style>--%>
<%--        #submitBtn{--%>
<%--            margin-left: 7rem;--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>

<h3 class="text-center">Create New Employee</h3>

<div class="col-md-8 offset-md-5">
    <form>
        <div class="form-group col-md-4">
            <label class="form-label">Full Name</label>
            <input class="form-control" type="text" id="empFullName" name="empFullName" placeholder="Enter Full Name" autocomplete="off">
            <div id="empNameAlert"></div>
        </div>

        <div class="form-group col-md-4">
            <label class="form-label">Email</label>
            <input class="form-control" type="email" id="empEmail" name="empEmail" placeholder="Enter Email Address">
            <div id="empEmailAlert"></div>
        </div>

        <div style="margin-top: 2rem; margin-left: 7rem;" class="form-group col-md-4">
            <button id="submitBtn" type="submit" class="btn btn-success" onmouseover="validateData()">Submit</button>
        </div>

        <input type="hidden" id="val" value="0">

    </form>

</div>

<%--<div id="javaIntro" class="text-center form-control" style="width: 20%; margin-left: 43%"></div>--%>


</body>
</html>

<script>

    // Prevent Submitting Form on Enter Key Press
    $(document).ready(function() {
        display();
        $(window).keydown(function(event){
            if(event.keyCode === 13) {
                // alert("Enter Key Is Pressed");
                event.preventDefault();
                return false;
            }
        });
    });

    function display(){
        let javaIntro = "JAVA was developed by James Gosling at Sun Microsystems Inc in the year 1995, later acquired by Oracle Corporation. It is a simple programming language. Java makes writing, compiling, and debugging programming easy. It helps to create reusable code and modular programs. Java is a class-based, object-oriented programming language and is designed to have as few implementation dependencies as possible. A general-purpose programming language made for developers to write once run anywhere that is compiled Java code can run on all platforms that support Java. Java applications are compiled to byte code that can run on any Java Virtual Machine. The syntax of Java is similar to c/c++."
        $('#javaIntro').html(javaIntro.substring(0, 9) + "<span onclick='displayFullText()' style='cursor: pointer'>...</span>");
    }

    function displayFullText(){
        $('#javaIntro').html("JAVA was developed by James Gosling at Sun Microsystems Inc in the year 1995, later acquired by Oracle Corporation. It is a simple programming language. Java makes writing, compiling, and debugging programming easy. It helps to create reusable code and modular programs. Java is a class-based, object-oriented programming language and is designed to have as few implementation dependencies as possible. A general-purpose programming language made for developers to write once run anywhere that is compiled Java code can run on all platforms that support Java. Java applications are compiled to byte code that can run on any Java Virtual Machine. The syntax of Java is similar to c/c++." + "<span onclick='display()' style='cursor: pointer'>⇱</span>");
    }


    function validateData() {
        let val = $('#val').val();

        let empNameValid = false;
        let empEmailValid = false;

        let empName = $('#empFullName').val();
        let empEmail = $('#empEmail').val();

        let nameRegex = /^[a-zA-Z ]{5,30}$/;
        let emailRegEx = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;

        if (empName === "" || empName == null){
            // $('#empFullName').css('border', '2px solid red');
            $('#empFullName').addClass('is-invalid');
            $('#empNameAlert').html("<span style='color: #d21010'>Please Enter Employee Name</span>");
            if (val == 0) {
                $('#submitBtn').css('margin-left', '7rem');
                $('#val').val(1);
            }else {
                $('#submitBtn').removeAttr('style');
                $('#val').val(0);
            }
        }else if (!nameRegex.test(empName)){
            // $('#empFullName').css('border', '2px solid red');
            $('#empFullName').addClass('is-invalid');
            $('#empNameAlert').html('<span style="color: #d21010">Name must be 5-30 characters long</span>');
            if (val == 0) {
                $('#submitBtn').css('margin-left', '7rem');
                $('#val').val(1);
            }else {
                $('#submitBtn').removeAttr('style');
                $('#val').val(0);
            }
        }else {
            // $('#empFullName').css('border', '2px solid green');
            $('#empFullName').removeClass("is-invalid").addClass('is-valid');
            $('#empNameAlert').html('<span style="color: green">Name is valid</span>');
            empNameValid = true;
        }


        //Employee Email Validation
        if (empEmail === "" || empEmail == null){
            // $('#empEmail').css('border', '2px solid red');
            $('#empEmail').addClass('is-invalid');
            $('#empEmailAlert').html('<span style="color: #d21010">Please Enter Email Address</span>');
            if (val == 0) {
                $('#submitBtn').css('margin-left', '7rem');
                $('#val').val(1);
            } else {
                $('#submitBtn').removeAttr('style');
                $('#val').val(0);
            }
        }else if (!emailRegEx.test(empEmail)){
            // $('#empEmail').css('border', '2px solid red');
            $('#empEmail').addClass('is-invalid');
            $('#empEmailAlert').html('<span style="color: #d21010">Email is not valid</span>');
            if (val == 0) {
                $('#submitBtn').css('margin-left', '7rem');
                $('#val').val(1);
            } else {
                $('#submitBtn').removeAttr('style');
                $('#val').val(0);
            }
        }else {
            // $('#empEmail').css('border', '2px solid green');
            $('#empEmail').removeClass("is-invalid").addClass('is-valid');
            $('#empEmailAlert').html('<span style="color: green">Email is valid</span>');
            empEmailValid = true;
        }
    }
</script>
