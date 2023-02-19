<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 18/02/2023
  Time: 10.40 AM
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
    <title>Gold Rate Calculation</title>
</head>
<body>

<div class="container pt-6">
    <div class="card text-center">

        <%--        Body Part--%>
        <div class="card-body ">
            <form action="${pageContext.request.contextPath}/goldRateFileUpload" method="post" id="goldRateFileUpload" enctype="multipart/form-data">
                <h3 class="card-title">Gold Rate Calculation</h3>

                <div class="form">

                    <div class="card">
                        <h5 class="card-header control-label">Provide Details</h5>
                        <div class="card-body">
                            <div class="hold">
                                <div class="row g-3 mb-4">

                                    <div class="col-md-4 control-label">
                                        <label for="excelFileUpload" class="form-label control-label">Upload File Slab Excel File</label>
                                        <input type="file" name="excelFileUpload" class="form-control" id="excelFileUpload" required />
                                    </div>
                                    <div class="col-md-4 control-label">
                                        <label for="goldRate" class="form-label control-label">Today's Gold Rate(Per 10gm)</label>
                                        <input type="text" name="goldRate" class="form-control" id="goldRate" required />
                                    </div>

                                </div>

                                <div class="btnhold mt-3">
                                    <button type="submit" class="btn btn-primary mr-3">Submit</button>
                                    <button type="reset" class="btn btn-secondary">Reset</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>


            <div id="view">
                <h3 class="card-title">Details</h3>
                <table class="table table-bordered" width="90%">
                    <thead>
                    <tr>
                        <th>Sl.No</th>
                        <th>Product Id</th>
                        <th>Product Type</th>
                        <th>Current Date</th>
                        <th>Weight</th>
                        <th>Rate Per Gram</th>
                        <th>Making Charge after Discussion</th>
                        <th>Gross Amount</th>
                        <th>GST</th>
                        <th>Net Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${priceDtlList}" var="price" varStatus="count">
                        <tr>
                            <td>${count.count}</td>
                            <td>${price.product.id}</td>
                            <td>${price.product.productType}</td>
                            <td>${price.currentDate}</td>
                            <td>${price.product.weight}</td>
                            <td>${price.currentGoldRatePerGram}</td>
                            <td>${price.makingChargeAfterDiscount}</td>
                            <td>${price.grossAmount}</td>
                            <td>${price.gstAmount}</td>
                            <td>${price.netPrice}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>



        </div>
    </div>
</div>



</body>
</html>
