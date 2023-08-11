<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 9/27/2022
  Time: 9:56 PM
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
    <title>Department</title>
</head>
<body>

<div class="container pt-6">
    <div class="card text-center">

<%--        Header Part--%>
        <div class="card-header">
            <ul class="nav nav-tabs card-header-tabs">
                <li class="nav-item"><a class="nav-link active" href="/add">Add</a></li>
                <li class="nav-item"><a class="nav-link" href="/view">View</a></li>
            </ul>
        </div>

<%--        Body Part--%>
        <div class="card-body ">
            <form action="" method="" id="">
                <h3 class="card-title">Title</h3>

                <div class="form">

                    <div class="row g-3 m-4">
                        <div class="col-md-4 control-label">
                            <label for="inputEmail4" class="form-label control-label">Label</label>
                        </div>
                        <div class="col-md-4 control-label">
                            <label for="inputEmail4" class="form-label control-label">Property Type</label>
                        </div>
                        <div class="col-md-4 control-label">
                            <label for="inputEmail4" class="form-label control-label">Property Cost</label>
                        </div>
                    </div>

                    <div class="card">
                        <h5 class="card-header control-label">Main Details</h5>
                        <div class="card-body">
                            <div class="hold">
                                <div class="row g-3 mb-4">

                                    <div class="col-md-4 control-label">
                                        <label for="inputEmail4" class="form-label control-label">Name</label>
                                        <input type="text" name="txtname" class="form-control" id="inputname" required />
                                    </div>
                                    <div class="col-md-4 control-label">
                                        <label for="inputEmail4" class="form-label"><span
                                                class="">Email</span> </label> <input type="email" name="txtemail" class="form-control" id="inputname" required />
                                    </div>
                                    <div class="col-md-4 control-label">
                                        <label for="inputEmail4" class="form-label control-label">Mobile</label>
                                        <input type="text" name="txtmobile" class="form-control" id="inputname" required />
                                    </div>

                                </div>

                                <div class="btnhold mt-3">
                                    <button type="submit" class="btn btn-outline-primary mr-3">Submit</button>
                                    <button type="reset" class="btn btn-outline-secondary">Reset</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>



    <div id="view">
        <h3 class="card-title">Employee Details</h3>

        <table class="table table-bordered" width="90%">
            <thead>
            <tr>
                <th>Sl.No</th>
                <th>Batch Name</th>
                <th>Batch Start Date</th>
                <th>Technology Name</th>
                <th>Employee Name</th>
                <th>Employee Phone</th>
                <th>Mark</th>
                <th>Grade</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tableListDTOList}" var="table" varStatus="count">
                <tr>
                    <td>${count.count}</td>
                    <td>${table.batchName}</td>
                    <td>${table.batchStartDate}</td>
                    <td>${table.technologyName}</td>
                    <td>${table.employeeName}</td>
                    <td>${table.employeePhone}</td>
                    <td>${table.mark}</td>
                    <td>${table.grade}</td>
                    <td>${table.status}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


    </div>
</div>

</body>
</html>
