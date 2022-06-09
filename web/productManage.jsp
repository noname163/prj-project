<%-- 
    Document   : productManage
    Created on : Feb 13, 2022, 9:49:41 AM
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
                                <form action="filter?action=filter&from=productM" method="post" style="float: right">
                                    <input id="cate" type="number" name="cate" value=""  placeholder="Enter categories number" style="border: solid 2px #000; border-radius: 0.5em;" required="" >
                                   <select onclick="change()" id="status"  name="status" style="border: solid 2px #000; border-radius: 0.5em; background-color: gainsboro; text-align: center; height: fit-content; display: none;" >
                                            <option  value="1" onclick="change()" >Available</option>
                                            <option value="0" onclick="change()">UnAvailable</option>
                                        </select>
                                        <select onclick="change()" id="select" name="select" style="border: solid 2px #000; border-radius: 0.5em; background-color: gainsboro; text-align: center; ">
                                            <option value="cate" onclick="change()" >By Categories</option>
                                            <option  value="status" onclick="change()" >By Status</option>
                                            <option value="all" onclick="change()">All</option>
                                        </select>
                                        <button type="submit" style="border-radius: 0.5em" > Submit</button>      
                                        <script>
                                            function change(){
                                               var value = document.getElementById("select").value;
                                               var start = document.getElementById("status");
                                               if(value==="status" ){
                                                   start.style.display = "";
                                                   start.setAttribute("required", "");
                                                   document.getElementById("cate").removeAttribute("required");
                                                   document.getElementById("cate").style.display="none";
                                               }else if(value==="all" ){
                                                   start.style.display = "none";
                                                   document.getElementById("cate").style.display="none";
                                                   
                                                   start.removeAttribute("required");
                                                   document.getElementById("cate").removeAttribute("required");
                                                   document.getElementById("cate").style.display="none";
                                               }
                                               else{
                                                   start.style.display = "none";
                                                   start.removeAttribute("required");
                                                   document.getElementById("cate").style.display="";
                                               }
                                               console.log(value);
                                               console.log(document.getElementById("cate").value);
                                           }
                                        </script>
                                </form>
                            </div>
                            <div class="table-responsive" >
                                <table class="table table-hover table-nowrap">
                                    <thead class="thead-light">
                                        <tr >
                                            <th scope="col">Name</th>
                                            <th scope="col">Product Cate</th>
                                            <th scope="col">Quantity</th>
                                            <th scope="col">Price</th>
                                            <th scope="col">Status</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${sessionScope.p}" var="o">
                                        <tr >
                                            <td> <img alt="..." src="${o.productImg}" class="avatar avatar-sm rounded-circle me-2"> <a class="text-heading font-semibold" href="#"> ${o.productName} </a> </td>
                                            <td> ${o.cateId}  </td>
                                            <td> ${o.productDecription} </td>
                                            <td> $${o.productPrice} </td>
                                            <td> 
                                                <c:if test="${o.productStatus==1}">
                                                    <span class="badge badge-lg badge-dot"> <i class="bg-success"></i> Available </span>
                                                    
                                                </c:if> 
                                                <c:if test="${o.productStatus==0}">
                                                    <span class="badge badge-lg badge-dot"> <i class="bg-warning"></i>UnAvailable </span>
                                                    
                                                </c:if> 
                                                
                                            </td>
                                            <td class="text-end">
                                                <a href="editProduct?pId=${o.productId}" class="btn btn-sm btn-neutral">Edit</a>
                                                <c:if test="${o.productStatus==1}">
                                                    <a href="productManage?action1=UnAvailable&pId=${o.productId}" class="btn btn-sm btn-neutral">UnAvailable</a>
                                                </c:if>
                                                <c:if test="${o.productStatus==0}">
                                                    <a href="productManage?action1=Available&pId=${o.productId}" class="btn btn-sm btn-neutral">Available</a>
                                                </c:if>
                                                
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="card-footer border-0 py-5"> <span class="text-muted text-sm">${!sessionScope.p.isEmpty()?"Showing 10 items out of 250 results found":"O results was found"}</span> </div>
                        
                        </div>
                    </div>
                </main>
            </div>
        </div>
    </body>
</html>
