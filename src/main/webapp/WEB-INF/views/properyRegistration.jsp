<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 7/27/2022
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"> </script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>Property Registration</title>
</head>
<body style="margin: 2rem;">
<style>
    a{
        cursor: pointer;
    }
</style>
<h3>Property Registration Form</h3>
<div class="card text-center">
    <div class="card-header">
        <ul class="nav nav-tabs card-header-tabs">
            <li class="nav-item"><a class="nav-link active" id="addId" onclick="openAdd()" <%--href="/add"--%>>Add</a></li>
            <li class="nav-item"><a class="nav-link" id="viewId" onclick="openView()" <%--href="/view"--%>>View</a></li>
        </ul>
    </div>

    <div class="card-body">
        <div id="add">
            <form action="/propertyRegistration" method="post" id="propertyRegistrationForm">
                <h3 class="card-title">Property Registration Form</h3>
                <div class="form">
                    <div class="row g-3 m-4">
                        <div class="col-md-4 control-label">
                            <label for="housingProject" class="form-label control-label">Housing Project</label>
                            <select class="form-control form-control" name="housingProject" id="housingProject" onchange="getPropertyType()">
                                <option value="Kalinga Nagar">Kalinga Nagar</option>
                                <option value="New AG Colony">New AG Colony</option>
                                <option value="BRIT Colony">BRIT Colony</option>
                            </select>
                        </div>
                        <div class="col-md-4 control-label">
                            <label for="inputEmail4" class="form-label control-label">Property
                                Type</label> <select class="form-control form-control" name="pt">
                            <option value="MIG">MIG</option>
                            <option value="LIG">LIG</option>
                            <option value="HIG">HIG</option>
                        </select>
                        </div>
                        <div class="col-md-4 control-label">
                            <label for="inputEmail4" class="form-label control-label">Property
                                Cost</label>
                            <select class="form-control form-control" name="cost">
                                <option value="16000000">16000000</option>
                                <option value="19000000">19000000</option>
                                <option value="20000000">20000000</option>
                            </select>
                        </div>
                    </div>

                    <div class="card">
                        <h5 class="card-header control-label">Applicant Details</h5>
                        <div class="card-body">
                            <div class="hold">
                                <div class="row g-3 mb-4">
                                    <div class="col-md-4 control-label">
                                        <label for="inputEmail4" class="form-label control-label">Name</label>
                                        <input type="text" name="txtname" class="form-control"
                                               id="inputname" required />

                                    </div>
                                    <div class="col-md-4 control-label">
                                        <label for="inputEmail4" class="form-label"><span
                                                class="">Email</span> </label> <input type="email" name="txtemail"
                                                                                      class="form-control" id="inputname" required />

                                    </div>
                                    <div class="col-md-4 control-label">
                                        <label for="inputEmail4" class="form-label control-label">Mobile</label>
                                        <input type="text" name="txtmobile" class="form-control"
                                               id="inputname" required />

                                    </div>

                                </div>

                                <div class="row g-3">
                                    <div class="col-md-4 control-label">
                                        <label for="inputEmail4" class="form-label control-label">Date
                                            of Birth</label> <input type="date" name="txtdate"
                                                                    class="form-control" id="inputname" required />

                                    </div>
                                    <div class="col-md-4 control-label">
                                        <label for="inputEmail4" class="form-label control-label">Gender</label>
                                        <div class="row g-2">
                                            <div class="col-md-4">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio"
                                                           name="exampleRadios" id="exampleRadios1" value="Male"
                                                           checked> <label class="form-check-label"
                                                                           for="exampleRadios1"> Male </label>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio"
                                                           name="exampleRadios" id="exampleRadios2" value="FeMale">
                                                    <label class="form-check-label" for="exampleRadios2">
                                                        FeMale </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 control-label">
                                        <div class="form-group">
                                            <label for="exampleFormControlFile1">Upload id-proof</label>
                                            <input type="file" class="form-control-file" name="idproof"
                                                   id="exampleFormControlFile1">
                                        </div>

                                    </div>
                                </div>
                                <div class="btnhold mt-3">
                                    <button type="button" class="btn btn-outline-primary mr-3" onclick="validateForm()">Submit</button>
                                    <button type="reset" class="btn btn-outline-secondary">Reset</button>
                                </div>
                            </div>
            </form>
        </div>
        <div id="view">View Page</div>
    </div>
</div>

</body>

<script>
    $(document).ready(function (){
        $('#add').show();
        $('#edit').hide();
    });

    function openAdd(){
        $('#view').hide();
        $('#add').show();

        $('#addId').addClass("active");
        $('#viewId').removeClass("active");
    }
    function openView(){
        $('#view').show();
        $('#add').hide();

        $('#addId').removeClass("active");
        $('#viewId').addClass("active");
    }

</script>
</html>
