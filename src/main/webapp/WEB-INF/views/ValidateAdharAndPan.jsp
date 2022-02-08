<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 2/2/2022
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--    Bootstrap for Design--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<%--    For Validation--%>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<%--    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">--%>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
    <title>Personal Details</title>
</head>
<body>
<%--<script>--%>
<%--    $(document).ready(function (){--%>
<%--        $('#personalDetailForm').bootstrapValidator({--%>
<%--            container: '#namealert',--%>
<%--            feedbackIcons: {--%>
<%--                valid: 'glyphicon glyphicon-ok',--%>
<%--                invalid: 'glyphicon glyphicon-remove',--%>
<%--                validating: 'glyphicon glyphicon-refresh'--%>
<%--            },--%>
<%--            fields: {--%>
<%--                name: {--%>
<%--                    validators: {--%>
<%--                        notEmpty: {--%>
<%--                            message: 'The full name is required and cannot be empty!!'--%>
<%--                        }--%>
<%--                    }--%>
<%--                }--%>
<%--            }--%>
<%--        })--%>
<%--    });--%>
<%--</script>--%>

<script>
    $(document).ready(function (){
        $('#submit').click(function (e){
            var name  = $('#inputName').val();
            var panid = $('#inputPan').val();
            var adharid = $('#inputAdhar').val();

            var name_val = /^[a-zA-Z\s-, ]+$/;
            var mob_val = /[0-9]{10}/;
            var adhar_val = /[0-9]{12}/;
            var only_numbers = /^[0-9]*$/;

            // Name Validation:
            if (name.length == 0 || name.length <=4 || name.length >=20){
                $('#inputName').css('border', '2px solid red');
                $("#inputName").focus();
                $('#namealert').text("Name must be filled, less than 4 and greater than 20 characters!!").css('color', 'red');
                return false;
            }
            else if(!name.match(name_val) || name.length == 0){
                $('#inputName').css('border', '2px solid red');
                $('#inputName').focus();
                $('#namealert').text("For name use alphabets only !!").css('color', 'red');
                return false;
            }
            //Pan ID Validation:
            else if(panid.length != 10){
                $('#inputPan').focus();
                $('#inputPan').css('border', '2px solid red');
                $('#panalert').text("Pan ID must be 10 digit!!").css('color', 'red');
                $('#inputName').css('border', '2px solid green');
                $('#namealert').text("Looks Good!").css('color', 'green');
                return false;
            }
            //Adhar Validation:
            // adharid.length != 12 && !adharid.match(only_numbers)
            else if (!adharid.match(adhar_val)){
                $('#inputAdhar').focus();
                $('#inputAdhar').css('border', '2px solid red');
                $('#adharalert').text("Adhar range must be 12 digit!!").css('color', 'red');
                $('#inputPan').css('border', '2px solid green');
                $('#panalert').text("Looks Good!").css('color', 'green');
                return false;
            }
            else{
                $('#inputAdhar').css('border', '2px solid green');
                $('#adharalert').text("Looks Good!").css('color', 'green');

                $('#personalDetailForm').submit(function (event){
                    event.preventDefault();
                    loadData($(this));
                });
                return true;
            }
        });
    });

    // $(document).ready(function () {
    //     $("#personalDetailForm").submit(function (event) {
    //         //stop submit the form, we will post it manually.
    //         event.preventDefault();
    //         loadData();
    //     });
    // });

    function loadData(form) {
        /*            var xhttp = new XMLHttpRequest();
                    xhttp.onreadystatechange = function() {
                        if (this.readyState == 4 && this.status == 200) {
                            document.getElementById("display").innerHTML = this.responseText;
                            $("#display").html(this.responseText);
                        }
                    };
                    xhttp.open("POST", "AddPersonalData",modelAttribute="personalDataBean", true);
                    xhttp.send();
                }*/

        $.ajax({
            url: "AddPersonalData",
            method: "POST",
            data: form.serialize(),
            success: function (data) {
                console.log(data);
                $('#display').html(data);
            },
            error: function (data) {
                console.log(data);
            }
        });
    }
</script>

    <h4 style="text-align: center">Fill Personal Details</h4>

<%--action="AddPersonalData"--%>
    <form:form id="personalDetailForm" method="post" modelAttribute="personalDataBean">
        <div style="margin: auto" class="form-group col-md-8">

            <div class="form-group row">

                <div class="col-md-4">
                    <label class="form-label" for="inputName">Name</label>
                    <form:input path="name" type="text" class="form-control" id="inputName" name="name" placeholder="Enter Name"/>
<%--                    <small class="form-text text-muted" >Name must not contains number</small>--%>
                    <div id="namealert"></div>
                </div>

                <div class="col-md-4">
                    <label class="form-label" for="inputName">Pan Card ID</label>
                    <form:input path="panId" type="text" class="form-control" id="inputPan" name="panid" placeholder="Enter Pan Card ID"/>
<%--                    <small class="form-text text-muted">Personal details are don't shared</small>--%>
                    <div id="panalert"></div>
                </div>

                <div class="col-md-4">
                    <label class="form-label" for="inputName">Adhar Card ID</label>
                    <form:input path="adharNo" type="text" class="form-control" id="inputAdhar" placeholder="Enter Adhar Card ID"/>
<%--                    <small class="form-text text-muted">Enter 16 digit adhar card number</small>--%>
                    <div id="adharalert"></div>
                </div>

            </div>

            <form:hidden path="pid"/>

            <div style="margin: auto; margin-top: 20px" class="form-group row col-md-6">

                <div class="form-group row col-md-3">
<%--                    onclick="loadData()"--%>
                    <button type="submit" id="submit"   class="btn btn-success">Submit</button>
                </div>

                <div style="margin-left: 10px" class="form-group row col-md-3">
                    <button onclick="window.location='Registration'; return false;" class="btn btn-danger">Cancel</button>
                </div>

            </div>

            <div id="display"></div>

        </div>
    </form:form>



<%--Ajax Function:--%>
<%--<script>--%>
<%--    function loadData() {--%>
<%--        var xhttp = new XMLHttpRequest();--%>
<%--        xhttp.onreadystatechange = function() {--%>
<%--            if (this.readyState == 4 && this.status == 200) {--%>
<%--                document.getElementById("display").innerHTML = this.responseText;--%>
<%--            }--%>
<%--        };--%>
<%--        xhttp.open("POST", "AddPersonalData", true);--%>
<%--        xhttp.send();--%>
<%--    }--%>
<%--</script>--%>

</body>
</html>
