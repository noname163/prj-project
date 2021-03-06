<%-- 
    Document   : test
    Created on : Jan 18, 2022, 9:25:01 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Untitled</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Bitter:400,700">
        <style>
            .header-dark {
                background:url(../../assets/img/mountain_bg.jpg) #444;
                background-size:cover;
                padding-bottom:80px;
            }

            @media (min-width:768px) {
                .header-dark {
                    padding-bottom:120px;
                }
            }

            .header-dark .navbar {
                background:transparent;
                padding-top:0;
                padding-bottom:0;
                color:#fff;
                border-radius:0;
                box-shadow:none;
                border:none;
            }

            @media (min-width:768px) {
                .header-dark .navbar {
                    padding-top:.75rem;
                    padding-bottom:.75rem;
                }
            }

            .header-dark .navbar .navbar-brand {
                font-weight:bold;
                color:inherit;
            }

            .header-dark .navbar .navbar-brand:hover {
                color:#f0f0f0;
            }

            .header-dark .navbar .navbar-collapse span {
                margin-top:5px;
            }

            .header-dark .navbar .navbar-collapse span .login {
                color:#d9d9d9;
                margin-right:.5rem;
                text-decoration:none;
            }

            .header-dark .navbar .navbar-collapse span .login:hover {
                color:#fff;
            }

            .header-dark .navbar .navbar-toggler {
                border-color:#747474;
            }

            .header-dark .navbar .navbar-toggler:hover, .header-dark .navbar-toggler:focus {
                background:none;
            }

            .header-dark .navbar .navbar-toggler {
                color:#eee;
            }

            .header-dark .navbar .navbar-collapse, .header-dark .navbar .form-inline {
                border-color:#636363;
            }

            @media (min-width: 992px) {
                .header-dark .navbar.navbar .navbar-nav .nav-link {
                    padding-left:1.2rem;
                    padding-right:1.2rem;
                }
            }

            .header-dark .navbar.navbar-dark .navbar-nav .nav-link {
                color:#d9d9d9;
            }

            .header-dark .navbar.navbar-dark .navbar-nav .nav-link:focus, .header-dark .navbar.navbar-dark .navbar-nav .nav-link:hover {
                color:#fcfeff !important;
                background-color:transparent;
            }

            .header-dark .navbar .navbar-nav > li > .dropdown-menu {
                margin-top:-5px;
                box-shadow:0 4px 8px rgba(0,0,0,.1);
                background-color:#fff;
                border-radius:2px;
            }

            .header-dark .navbar .dropdown-menu .dropdown-item:focus, .header-dark .navbar .dropdown-menu .dropdown-item {
                line-height:2;
                font-size:14px;
                color:#37434d;
            }

            .header-dark .navbar .dropdown-menu .dropdown-item:focus, .header-dark .navbar .dropdown-menu .drodown-item:hover {
                background:#ebeff1;
            }

            .header-dark .navbar .action-button, .header-dark .navbar .action-button:active {
                background:#208f8f;
                border-radius:20px;
                font-size:inherit;
                color:#fff;
                box-shadow:none;
                border:none;
                text-shadow:none;
                padding:.5rem .8rem;
                transition:background-color 0.25s;
            }

            .header-dark .navbar .action-button:hover {
                background:#269d9d;
            }

            .header-dark .navbar .form-inline label {
                color:#ccc;
            }

            .header-dark .navbar .form-inline .search-field {
                display:inline-block;
                width:80%;
                background:none;
                border:none;
                border-bottom:1px solid transparent;
                border-radius:0;
                color:#ccc;
                box-shadow:none;
                color:inherit;
                transition:border-bottom-color 0.3s;
            }

            .header-dark .navbar .form-inline .search-field:focus {
                border-bottom:1px solid #ccc;
            }

            .header-dark .hero {
                margin-top:60px;
            }

            @media (min-width:768px) {
                .header-dark .hero {
                    margin-top:20px;
                }
            }

            .header-dark .hero h1 {
                color:#fff;
                font-family:'Bitter', serif;
                font-size:40px;
                margin-top:20px;
                margin-bottom:80px;
            }

            @media (min-width:768px) {
                .header-dark .hero h1 {
                    margin-bottom:50px;
                    line-height:1.5;
                }
            }

            .header-dark .hero .embed-responsive iframe {
                background-color:#666;
            }


        </style>
    </head>

    <body>
        <div>
            <div class="header-dark">
                <nav class="navbar navbar-dark navbar-expand-md navigation-clean-search">
                    <div class="container"><a class="navbar-brand" href="Home">DaLat Flower</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse"
                             id="navcol-1">
                            <ul class="nav navbar-nav">
                                <li class="nav-item" role="presentation"><a class="nav-link" href="#">Link</a></li>
                                <li class="dropdown">
                                    <a class="dropdown-toggle nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">More</a>
                                    <div class="dropdown-menu" role="menu">
                                        <c:if test="${sessionScope.account!=null}">
                                            <a class="dropdown-item" role="presentation" href="user">Profile</a>
                                        </c:if>
                                        <a class="dropdown-item" role="presentation" href="#">Setting</a>
                                        <c:if test="${sessionScope.account.role==0}">
                                            <a class="dropdown-item" role="presentation" href="Admin">Manager</a>
                                        </c:if>
                                    </div>
                                </li>
                            </ul>
                            <form class="form-inline mr-auto" target="_self" action="search?action=search" method="post">
                                <div class="form-group">
                                    <label for="search-field">
                                        <i class="fa fa-search"></i>
                                    </label>
                                    <input class="form-control search-field" value="${sessionScope.searchValue}" type="search" name="search" id="search-field">
                                </div>
                            </form>
                            <c:if test="${sessionScope.account==null}" >
                                <span class="navbar-text">
                                <a href="Login" class="login">Login</a>
                            </span>
                            </c:if>
                            <c:if test="${sessionScope.account!=null}" >
                                <span class="navbar-text">
                                <a href="logout" class="login">Logout</a>
                            </span>
                            </c:if>
                            <c:if test="${sessionScope.account==null}">
                                <a class="btn btn-light action-button" role="button" href="registerPage.jsp">SignUp</a>
                            </c:if>
                            <c:if test="${sessionScope.account!=null}">
                                <a class="btn btn-light action-button" role="button" href="loadOrder">Cart</a>
                            </c:if>
<!--                            <button id="btnChangeBg" onclick="myFunc()">Change Background</button>-->
                        </div>
                    </div>
                </nav>

            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
    </body>

</html>
