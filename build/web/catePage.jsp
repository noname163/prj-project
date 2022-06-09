<%-- 
    Document   : catePage
    Created on : Feb 18, 2022, 4:00:22 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <style>
            @import url(https://unpkg.com/@webpixels/css@1.1.5/dist/index.css);
            @import url("https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.4.0/font/bootstrap-icons.min.css");

        </style>
        <style>
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
        <!-- Banner -->
        <a href="https://webpixels.io/components?ref=bbbootstrap" class="btn w-full btn-primary text-truncate rounded-0 py-2 border-0 position-relative" style="z-index: 1000;"> <strong>Crafted with Webpixels CSS:</strong> The design system for Bootstrap 5. Browse all components →
        </a>
        <!-- Dashboard -->
        <div class="d-flex flex-column flex-lg-row h-lg-full bg-surface-secondary">
            <jsp:include page="leftAdmin.jsp"></jsp:include>
                <!-- Main content -->
                <div class="h-screen flex-grow-1 overflow-y-lg-auto">
                    <!-- Header -->
                <jsp:include page="headerAdmin.jsp"></jsp:include>
                    <!-- Main -->
                    <main class="py-6 bg-surface-secondary">
                        <div class="container-fluid">
                            <!-- Card stats -->
                            <div class="row g-6 mb-6">
                                <div class="col-xl-3 col-sm-6 col-12">
                                    <div class="card shadow border-0">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col"> <span class="h6 font-semibold text-muted text-sm d-block mb-2">Budget</span> <span class="h3 font-bold mb-0">$750.90</span> </div>
                                                <div class="col-auto">
                                                    <div class="icon icon-shape bg-tertiary text-white text-lg rounded-circle"> <i class="bi bi-credit-card"></i> </div>
                                                </div>
                                            </div>
                                            <div class="mt-2 mb-0 text-sm"> <span class="badge badge-pill bg-soft-success text-success me-2"> <i class="bi bi-arrow-up me-1"></i>13% </span> <span class="text-nowrap text-xs text-muted">Since last month</span> </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-3 col-sm-6 col-12">
                                    <div class="card shadow border-0">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col"> <span class="h6 font-semibold text-muted text-sm d-block mb-2">New projects</span> <span class="h3 font-bold mb-0">215</span> </div>
                                                <div class="col-auto">
                                                    <div class="icon icon-shape bg-primary text-white text-lg rounded-circle"> <i class="bi bi-people"></i> </div>
                                                </div>
                                            </div>
                                            <div class="mt-2 mb-0 text-sm"> <span class="badge badge-pill bg-soft-success text-success me-2"> <i class="bi bi-arrow-up me-1"></i>30% </span> <span class="text-nowrap text-xs text-muted">Since last month</span> </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-3 col-sm-6 col-12">
                                    <div class="card shadow border-0">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col"> <span class="h6 font-semibold text-muted text-sm d-block mb-2">Total hours</span> <span class="h3 font-bold mb-0">1.400</span> </div>
                                                <div class="col-auto">
                                                    <div class="icon icon-shape bg-info text-white text-lg rounded-circle"> <i class="bi bi-clock-history"></i> </div>
                                                </div>
                                            </div>
                                            <div class="mt-2 mb-0 text-sm"> <span class="badge badge-pill bg-soft-danger text-danger me-2"> <i class="bi bi-arrow-down me-1"></i>-5% </span> <span class="text-nowrap text-xs text-muted">Since last month</span> </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-3 col-sm-6 col-12">
                                    <div class="card shadow border-0">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col"> <span class="h6 font-semibold text-muted text-sm d-block mb-2">Work load</span> <span class="h3 font-bold mb-0">95%</span> </div>
                                                <div class="col-auto">
                                                    <div class="icon icon-shape bg-warning text-white text-lg rounded-circle"> <i class="bi bi-minecart-loaded"></i> </div>
                                                </div>
                                            </div>
                                            <div class="mt-2 mb-0 text-sm"> <span class="badge badge-pill bg-soft-success text-success me-2"> <i class="bi bi-arrow-up me-1"></i>10% </span> <span class="text-nowrap text-xs text-muted">Since last month</span> </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card shadow border-0 mb-7">
                                <div class="card-header">

                                </div>
                                <div class="table-responsive" >
                                    <table class="table table-hover table-nowrap">
                                        <thead class="thead-light">
                                            <tr >
                                                <th scope="col">Name</th>
                                                <th scope="col">Categories Id</th>

                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${cList}" var="o">
                                            <tr >
                                                <td> ${o.id}</td>
                                                <td> ${o.categoriesName}  </td>


                                                <td class="text-end">
                                                    <a href="editCate?action=editCate&action1=editCate&cId=${o.id}" class="btn btn-sm btn-neutral">Edit</a>
                                                    <a href="#" class="btn btn-sm btn-neutral">Deleted</a>

                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="pagination_rounded" style=" display: block; width: fit-content;height: fit-content; margin: 1em 0px 0px 20vw;">
                                <ul id="pagination-demo" style="display: block; width: fit-content;height: fit-content">
                                    <li> 
                                        <a href="paging?indexCate=${cateIndex==null||cateIndex==1?1:cateIndex-1}&from=adminPage" class="prev"> 
                                            <i class="fa fa-angle-left" aria-hidden="false"></i> 
                                            Prev </a>
                                    </li>
                                    <c:if test="${cateIndex!=null}">
                                        <c:if test="${cateIndex!=1&&cateIndex+5<=totalCate}">   
                                            <li class="visible-xs"><a href="#">...</a> </li>
                                            </c:if>
                                            <c:forEach begin="${cateIndex+5<=totalCate?cateIndex:(cateIndex-(cateIndex-1))}" end="${cateIndex+5<=totalCate?(cateIndex+5):totalCate}" var="o" >
                                            <li class="hidden-xs page" style="" >
                                                <a class="${cateIndex==o? "active":""}" style="color: ${cateIndex==o? "#fff":""};" href="paging?indexCate=${o}&from=adminPage">${o}</a>
                                            </li>
                                        </c:forEach>
                                        <c:if test="${cateIndex>6}">   
                                            <li class="visible-xs"><a href="#">...</a> </li>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${cateIndex==null}">
                                            <c:forEach begin="1" end="6" var="o" >
                                            <li class="hidden-xs page" style="" >
                                                <a class="${cateIndex==o? "active":""}" style="color: ${cateIndex==o? "#fff":""};" href="paging?indexCate=${o}&from=adminPage">${o}</a>
                                            </li>
                                        </c:forEach>
                                        <c:if test="${totalCate>6}">   
                                            <li class="visible-xs"><a href="#">...</a> </li>
                                            </c:if>
                                        </c:if>



                                    <li>
                                        <a href="paging?cateIndex=${page==pagination?page:page+1}&from=adminPage" style="d" class="next">
                                            Next <i class="fa fa-angle-right" aria-hidden="true">
                                            </i>
                                        </a> 
                                    </li>
                                </ul>
                                <div class="card-footer border-0 py-5"> <span class="text-muted text-sm">Showing 10 items out of 250 results found</span> </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>
    </body>
</html>
