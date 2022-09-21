<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 2/8/2022
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    Linking CSS Design--%>
    <link href="style/style.css" rel="stylesheet"/>
<%--    Font Awesome--%>
    <link type="text/css" href="style/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Festive&family=Lato&family=Nunito+Sans&display=swap" rel="stylesheet">

    <link rel="canonical" href="https://themesberg.com/product/ui-kits/neumorphism-ui/" />

    <title>Home</title>
    <style>
        .countup {
            text-align: center;
            margin: 120px;
        }
        .countup .timeel {
            display: inline-block;
            padding: 10px;
            background: #151515;
            margin: 0;
            color: white;
            min-width: 2.6rem;
            margin-left: 13px;
            border-radius: 10px 0 0 10px;
        }
        .countup span[class*="timeRef"] {
            border-radius: 0 10px 10px 0;
            margin-left: 0;
            background: #e8c152;
            color: black;
        }

    </style>
</head>
<body>

<div style="background-color: #ecf2f4" class="col-12">
    <div class="card bg-primary shadow-soft border-light px-4 py-5 text-center mb-5">


        <nav id="main-nav" class="navbar navbar-main navbar-expand-lg navbar-theme-primary headroom navbar-light navbar-transparent navbar-theme-primary">
            <a style="color: black; font-weight: normal" class="navbar-brand shadow-soft py-2 px-3 rounded border border-light mr-lg-4" href="/Home">Sambit</a>

            <div class="navbar-collapse collapse" id="navbar_global">

                <div class="navbar-collapse-header">
                    <div class="row">
                        <div class="col-6 collapse-brand">
                            <a href="./index.html" class="navbar-brand shadow-soft py-2 px-3 rounded border border-light">
                                <img src="./assets/img/brand/dark.svg" alt="Themesberg logo">
                            </a>
                        </div>
                        <div class="col-6 collapse-close">
                            <a href="#navbar_global" class="fas fa-times" data-toggle="collapse" data-target="#navbar_global" aria-controls="navbar_global" aria-expanded="false" title="close" aria-label="Toggle navigation"></a>
                        </div>
                    </div>
                </div>

                <ul class="navbar-nav navbar-nav-hover align-items-lg-center">

                    <li class="nav-item dropdown">
                        <a  onclick="window.location='Home'" class="nav-link" data-toggle="dropdown" >
                            <span class="nav-link-inner-text">Home</span>
<%--                            <span class="fas fa-angle-down nav-link-arrow ml-2"></span>--%>
                        </a>
                    </li>

                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link" data-toggle="dropdown" >
                            <span class="nav-link-inner-text">Pages</span>
                            <span class="fas fa-angle-down nav-link-arrow ml-2"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" onclick="window.location='About'">About</a></li>
                            <li><a class="dropdown-item" onclick="window.location='Contact'">Contact</a></li>
                            <li><a class="dropdown-item" onclick="window.location='Login'">Login</a></li>
                            <li><a class="dropdown-item" onclick="window.location='Registration'">Sign up</a></li>
                        </ul>
                    </li>

                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link" data-toggle="dropdown" >
                            <span class="nav-link-inner-text">Support</span>
                            <span class="fas fa-angle-down nav-link-arrow ml-2"></span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-lg">
                            <div class="col-auto px-0" data-dropdown-content>
                                <div class="list-group list-group-flush">
                                    <a href="resume/myresume.pdf" target="_blank" class="list-group-item list-group-item-action d-flex align-items-center p-0 py-3 px-lg-4">
                                        <span class="icon icon-sm icon-secondary"><span class="fas fa-file-alt"></span></span>
                                        <div class="ml-4">
                                            <span class="text-dark d-block">Resume<span class="badge badge-sm badge-secondary ml-2">v1.0</span></span>
                                            <span class="small">View and Download</span>
                                        </div>
                                    </a>
                                    <a href="https://github.com/PSambitKumar" target="_blank" class="list-group-item list-group-item-action d-flex align-items-center p-0 py-3 px-lg-4">
                                        <span class="icon icon-sm icon-secondary"><span class="fas fa-microphone-alt"></span></span>
                                        <div class="ml-4">
                                            <span class="text-dark d-block">Support</span>
                                            <span class="small">Looking for answers? Ask us!</span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>

                <div style="margin-left: 420px" class="d-flex align-items-center">
                    <a href="Login" style="width: 8rem" target="_blank" class="btn btn-primary text-secondary d-none d-md-inline-block mr-3"><i class="fas fa-lock mr-2"></i>Sign In</a>
                    <a href="Registration" style="width: 8rem" target="_blank" class="btn btn-primary"><i class="fas fa-user"></i>   Register</a>
                    <button class="navbar-toggler ml-2" type="button" data-toggle="collapse" data-target="#navbar_global" aria-controls="navbar_global" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>
            </div>
        </nav>


        <div style="margin: 120px; font-family: Lato" class="col-12 col-lg-10">
            <div class="card bg-primary shadow-soft border-light px-4 py-1 mb-6">
                <div class="card-body text-center text-md-left">
                    <div class="row align-items-center">
                        <div class="col-md-6">
                            <h2 class="mb-3">Hello, <b style="color: orangered">I' M Sambit.</b></h2>
                            <p style="color: black" class="mb-4">
                                This is my official Portfolio website to showcase my all works related to
                                Java Software Engineer and part time Android development, web development and ui design.
                            </p>
                            <a style="font-weight: bold; color: #0b7ec4" href="resume/myresume.pdf" class="btn btn-primary">
                                    <span class="mr-1">
                                        <span><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-earmark-text-fill" viewBox="0 0 16 16">
                                          <path d="M9.293 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V4.707A1 1 0 0 0 13.707 4L10 .293A1 1 0 0 0 9.293 0zM9.5 3.5v-2l3 3h-2a1 1 0 0 1-1-1zM4.5 9a.5.5 0 0 1 0-1h7a.5.5 0 0 1 0 1h-7zM4 10.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 1 0-1h4a.5.5 0 0 1 0 1h-4z"/>
                                        </svg></span>
                                    </span>
                                View Resume
                            </a>
                        </div>
                        <div style="" class="col-12 col-md-6 mt-4 mt-md-0 text-md-right">
                            <img src="images/sambit.png" alt="Sambit">
                        </div>
                    </div>
                </div>
            </div>

            <%--        Count Up Timer--%>
            <div class="countup" id="countup1">
                <span class="timeel years">00</span>
                <span class="timeel timeRefYears">years</span>
                <span class="timeel days">00</span>
                <span class="timeel timeRefDays">days</span>
                <span class="timeel hours">00</span>
                <span class="timeel timeRefHours">hours</span>
                <span class="timeel minutes">00</span>
                <span class="timeel timeRefMinutes">minutes</span>
                <span class="timeel seconds">00</span>
                <span class="timeel timeRefSeconds">seconds</span>
                <span style="color: orangered; font-weight: bold; font-size: 22px; margin-left: 1rem;">Spent At CSM Technologies.</span>
            </div>

        </div>
    </div>
</div>


</body>
</html>

<script>
    window.onload = function() {
        // Month Day, Year Hour:Minute:Second, id-of-element-container
        countUpFromTime("Sept 16, 2021 10:00:00", 'countup1'); // ****** Change this line!
    };
    function countUpFromTime(countFrom, id) {
        countFrom = new Date(countFrom).getTime();
        var now = new Date(),
            countFrom = new Date(countFrom),
            timeDifference = (now - countFrom);

        var secondsInADay = 60 * 60 * 1000 * 24,
            secondsInAHour = 60 * 60 * 1000;

        days = Math.floor(timeDifference / (secondsInADay));
        years = Math.floor(days / 365);
        if (years > 1){ days = days - (years * 365) }
        hours = Math.floor((timeDifference % (secondsInADay)) / (secondsInAHour));
        mins = Math.floor(((timeDifference % (secondsInADay)) % (secondsInAHour)) / (60 * 1000));
        secs = Math.floor((((timeDifference % (secondsInADay)) % (secondsInAHour)) % (60 * 1000)) / 1000);

        var idEl = document.getElementById(id);
        idEl.getElementsByClassName('years')[0].innerHTML = years;
        idEl.getElementsByClassName('days')[0].innerHTML = days;
        idEl.getElementsByClassName('hours')[0].innerHTML = hours;
        idEl.getElementsByClassName('minutes')[0].innerHTML = mins;
        idEl.getElementsByClassName('seconds')[0].innerHTML = secs;

        clearTimeout(countUpFromTime.interval);
        countUpFromTime.interval = setTimeout(function(){ countUpFromTime(countFrom, id); }, 1000);
    }
</script>
