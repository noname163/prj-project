<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  errorPage="errosPage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css"/>

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
            /*            PaginationCss*/
            .pagination_rounded,
            .pagination_square {
                display: inline-block;
                margin-left: 400px;
                margin-top: 300px
            }

            .pagination_rounded ul {
                margin: 0;
                padding: 0;
                list-style: none
            }

            .pagination_rounded li:first-child {
                margin-left: 0px
            }

            .pagination_rounded ul li {
                float: left;
                margin-left: 20px
            }

            .pagination_rounded ul li a:hover {
                background: #4285f4;
                color: #fff;
                border: 1px solid #4285f4
            }
            .pagination_rounded ul li a.active {
                background: #4285f4;
                color: #fff;
                border: 1px solid #4285f4
            }

            a:link {
                text-decoration: none
            }

            .pagination_rounded .prev {
                margin-left: 0px;
                border-radius: 35px;
                width: 90px;
                height: 34px;
                line-height: 34px
            }

            .pagination_rounded ul li a {
                float: left;
                color: #4285f4;
                border-radius: 50%;
                line-height: 30px;
                height: 30px;
                width: 30px;
                text-align: center;
                margin-bottom: 40px;
                border: 1px solid #e0e0e0
            }

            .pagination_rounded .prev i {
                margin-right: 10px
            }

            .pagination_rounded .next {
                border-radius: 35px;
                width: 90px;
                height: 34px;
                line-height: 34px
            }

            .visible-xs {
                /*                display: none ; */
            }

        </style>
    </head>
    <body>
        <!--begin of menu-->
        <jsp:include page="header.jsp"></jsp:include>

            <!--end of menu-->
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="Home">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">Category</a></li>
                                <li class="breadcrumb-item active">Sub-category</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>

                    <div class="col-sm-9">
                        <div class="row">
                        <c:forEach items="${ListP}" var="o">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card" style="margin-top: 1em;">
                                    <img class="card-img-top" src="${o.productImg}" alt="Card image cap" width="200px" height="250px">
                                    <div class="card-body">

                                        <h4 class="card-title show_txt" ><a href="detail?action=detail&Dvalue=${o.productName}"  title="View Product">${o.productName}</a></h4>
                                        <p class="card-text show_txt">${o.productDecription}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${o.productPrice} $</p>
                                            </div>
                                            <div class="col">
                                                <a href="addToCart?action=addToCart&pId=${o.productId}" class="btn btn-success btn-block">Add to cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <c:if test="${tag==null}">
                    <div class="pagination_rounded" style=" display: block; width: fit-content;height: fit-content; margin: 1em 0px 0px 35vw;">
                        <ul id="pagination-demo" style="display: block; width: fit-content;height: fit-content">
                            <li> 
                                <a href="paging?index=${page==null||page==1?1:page-1}" class="prev"> 
                                    <i class="fa fa-angle-left" aria-hidden="false"></i> 
                                    Prev </a>
                            </li>
                            <c:if test="${page!=null}">
                                <c:if test="${page!=1&&page+5<=pagination}">   
                                    <li class="visible-xs"><a href="#">...</a> </li>
                                </c:if>
                                <c:forEach begin="${page+5<=pagination?page:(page-(page-1))}" end="${page+5<=pagination?(page+5):pagination}" var="o" >
                                    <li class="hidden-xs page" style="" >
                                        <a class="${page==o? "active":""}" style="color: ${page==o? "#fff":""};" href="paging?index=${o}">${o}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${page>6}">   
                                    <li class="visible-xs"><a href="#">...</a> </li>
                                </c:if>
                                </c:if>
                                <c:if test="${page==null}">
                                    <c:forEach begin="1" end="6" var="o" >
                                    <li class="hidden-xs page" style="" >
                                        <a class="${page==o? "active":""}" style="color: ${page==o? "#fff":""};" href="paging?index=${o}">${o}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pagination>6}">   
                                    <li class="visible-xs"><a href="#">...</a> </li>
                                    </c:if>
                                </c:if>



                            <li>
                                <a href="paging?index=${page==pagination?page:page+1}" style="d" class="next">
                                    Next <i class="fa fa-angle-right" aria-hidden="true">
                                    </i>
                                </a> 
                            </li>
                        </ul>
                    </div>
                </c:if>

            </div>

        </div>


        <!-- Footer -->
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>

