<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 5/10/2022
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SMS Mobile</title>
</head>
<body>
<h3>Welcome Home</h3>
<button type="button" onclick="smsMobile()">SMS Mobile</button>
<script>
    function smsMobile(){
        console.log("Inside smsMobile Method.")
        var settings = {
            "url": "https://www.smsgateway.center/SMSApi/rest/send?",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/x-www-form-urlencoded",
                "Cookie": "SERVERID=webC1"
            },
            "data": {
                "userId": "sambit",
                "password": "Sambitkumar@16",
                "senderId": "SMSGAT",
                "sendMethod": "simpleMsg",
                "msg": "Your Instant Demo account is live. This is a Demo Test message. - Demo Message SMSGatewayCenter",
                "format": "json",
                "msgType": "text",
                "mobile": "7008095918",
                "duplicateCheck": "true"
            }
        };

        $.ajax(settings).done(function (response) {
            console.log(response);
        });
    }
</script>
</body>
</html>
