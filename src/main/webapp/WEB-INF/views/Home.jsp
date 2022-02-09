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

    <link rel="canonical" href="https://themesberg.com/product/ui-kits/neumorphism-ui/" />

    <!--  Social tags -->
    <meta name="keywords" content="neumorphism, neumorphism ui, neomorphism, neomorphism ui, neomorphism css, neumorphism css, neumorph, neumorphic, design system, login, form, table, tables, card, cards, navbar, modal, icons, icons, map, chat, carousel, menu, datepicker, gallery, slider, date, social, dropdown, search, tab, nav, footer, date picker, forms, tabs, time, button, select, input, timeline, cart, about us, account, log in, blog, profile, portfolio, landing page, ecommerce, shop, landing, register, app, contact, one page, sign up, signup, store, bootstrap 4, bootstrap4, dashboard, bootstrap 4 dashboard, bootstrap 4 design, bootstrap 4 system, bootstrap 4, bootstrap 4 uit kit, bootstrap 4 kit, themesberg, html kit, html css template, web template, bootstrap, bootstrap 4, css3 template, frontend, responsive bootstrap template, bootstrap ui kit, responsive ui kit">
    <meta name="description" content="Start developing neumorphic web applications and pages using Neumorphism UI. It features over 100 individual components and 5 example pages.">

    <!-- Schema.org markup for Google+ -->
    <meta itemprop="name" content="Neumorphism UI by Themesberg">
    <meta itemprop="description" content="Start developing neumorphic web applications and pages using Neumorphism UI. It features over 100 individual components and 5 example pages.">
    <meta itemprop="image" content="https://themesberg.s3.us-east-2.amazonaws.com/public/products/neumorphism-ui/neumorphism-thumbnail.jpg">

    <!-- Twitter Card data -->
    <meta name="twitter:card" content="product">
    <meta name="twitter:site" content="@themesberg">
    <meta name="twitter:title" content="Neumorphism UI by Themesberg">
    <meta name="twitter:description" content="Start developing neumorphic web applications and pages using Neumorphism UI. It features over 100 individual components and 5 example pages.">
    <meta name="twitter:creator" content="@themesberg">
    <meta name="twitter:image" content="https://themesberg.s3.us-east-2.amazonaws.com/public/products/neumorphism-ui/neumorphism-thumbnail.jpg">

    <!-- Open Graph data -->
    <meta property="fb:app_id" content="214738555737136">
    <meta property="og:title" content="Neumorphism UI by Themesberg" />
    <meta property="og:type" content="article" />
    <meta property="og:url" content="https://demo.themesberg.com/neumorphism-ui/" />
    <meta property="og:image" content="https://themesberg.s3.us-east-2.amazonaws.com/public/products/neumorphism-ui/neumorphism-thumbnail.jpg"/>
    <meta property="og:description" content="Start developing neumorphic web applications and pages using Neumorphism UI. It features over 100 individual components and 5 example pages." />
    <meta property="og:site_name" content="Themesberg" />

    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="120x120" href="./assets/img/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="./assets/img/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="./assets/img/favicon/favicon-16x16.png">
    <link rel="manifest" href="./assets/img/favicon/site.webmanifest">
    <link rel="mask-icon" href="./assets/img/favicon/safari-pinned-tab.svg" color="#ffffff">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="theme-color" content="#ffffff">

    <!-- Fontawesome -->
    <link type="text/css" href="./vendor/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet">


    <!-- NOTICE: You can use the _analytics.html partial to include production code specific code & trackers -->
    <title>Home</title>
</head>
<body>
<%--<h4>Welcome Home, Sambit.</h4>--%>
<nav id="main-nav" class="navbar navbar-main navbar-expand-lg navbar-theme-primary headroom navbar-light navbar-transparent navbar-theme-primary">
    <a class="navbar-brand shadow-soft py-2 px-3 rounded border border-light mr-lg-4" href="/Home">Sambit</a>

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
    </div>
</nav>

<div class="typing-container">
    <span id="sentence" class="sentence">Here, take this </span>
    <span id="feature-text"></span>
    <span class="input-cursor"></span>
</div>

<script>
    const carouselText = [
        {text: "Apple", color: "red"},
        {text: "Orange", color: "orange"},
        {text: "Lemon", color: "yellow"}
    ]

    $( document ).ready(async function() {
        carousel(carouselText, "#feature-text")
    });

    async function typeSentence(sentence, eleRef, delay = 100) {
        const letters = sentence.split("");
        let i = 0;
        while(i < letters.length) {
            await waitForMs(delay);
            $(eleRef).append(letters[i]);
            i++
        }
        return;
    }

    async function deleteSentence(eleRef) {
        const sentence = $(eleRef).html();
        const letters = sentence.split("");
        let i = 0;
        while(letters.length > 0) {
            await waitForMs(100);
            letters.pop();
            $(eleRef).html(letters.join(""));
        }
    }

    async function carousel(carouselList, eleRef) {
        var i = 0;
        while(true) {
            updateFontColor(eleRef, carouselList[i].color)
            await typeSentence(carouselList[i].text, eleRef);
            await waitForMs(1500);
            await deleteSentence(eleRef);
            await waitForMs(500);
            i++
            if(i >= carouselList.length) {i = 0;}
        }
    }

    function updateFontColor(eleRef, color) {
        $(eleRef).css('color', color);
    }

    function waitForMs(ms) {
        return new Promise(resolve => setTimeout(resolve, ms))
    }
</script>
</body>
</html>
