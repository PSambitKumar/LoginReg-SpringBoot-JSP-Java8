<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 5/30/2022
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <link href="style/style.css" rel="stylesheet"/>

    <%--    Bootstrap for Design--%>
    <%--	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>
    <%--    For Validation--%>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<%--        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">--%>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
    <title>Issue</title>
</head>
<body>
<h3>Welcome Home</h3>
<form:form class="customform" id="issueForm" action="/saveIssue" method="post" autocomplete="off">
    <div class="card-body">

        <div class="row form-group">
            <div class="col-lg-3 col-sm-12">
                <div class="row ">
                    <label class="col-lg-12 col-sm-12"> Issue <strong class="red">*</strong></label>
                    <div class="col-lg-12 col-sm-12">
                        <input type="text" class="form-control" name = "issue" id="issue" />
                    </div>
                </div>
            </div>


            <div class="col-lg-3 col-sm-12">
                <div class="row">
                    <label class="col-lg-12 col-sm-12"> Sensitive<strong class="redcolor">*</strong></label>
                    <div class="col-lg-12 col-sm-12">
                        <select name="sensitive" id="sensitive" class="form-control">
                            <option selected="selected" value="0">Select</option>
                            <option  value="1">Low</option>
                            <option  value="2">Medium</option>
                            <option  value="3">High</option>
                        </select>

                    </div>
                </div>
            </div>





            <div class="col-md-4">
                <label class="control-label no-padding-right" for="txtPagename">Description<span class="text-danger">*</span></label>
                <div class="form-group">
								<textarea maxlength="500" rows="4" class="form-control" id="description" onkeyup="return countChar('description', 'descriptionct',500);" onmouseup="return countChar('description','descriptionct',500)" name="description" autocomplete="off"><c:out value="${Data.captionEnglish}"></c:out></textarea>
                    <span class="text-danger" id="descriptionct">Maximum <span class="ct">500</span> characters
                    </span>
                </div>
            </div>



        </div>


        <div class="col-sm-3 col-sm-4">
            <div class="col-sm-12 text-center">
                <button type="button" name="btmSubmit" id="btmSubmit" class="btn btn-success mr-1" onclick="saveIssue()">Save</button>
            </div>
        </div>
    </div>
    </div>


    <input type="hidden" name="issueSensitiveMasterId" id="issueSensitiveMasterId"">
    <input type="hidden" id="jsonData" name="jsonData">
    <div class="row">

    </div>
    </div>


</form:form>
</body>


<script>
    var jsonData = {};
    function saveIssue(){
        jsonData.issue = $('#issue').val();
        jsonData.sensitive = $('#sensitive').val();
        jsonData.description = $('#description').val();
        console.log(jsonData);
        $('#jsonData').val(JSON.stringify(jsonData));
        issueForm .submit();
    }
</script>
</html>
