<%-- 
    Document   : headerAdmin
    Created on : Feb 5, 2022, 4:56:13 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <style>
            @import url(https://unpkg.com/@webpixels/css@1.1.5/dist/index.css);
            @import url("https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.4.0/font/bootstrap-icons.min.css");
        </style>
    </head>
    <body>
        <header class="bg-surface-primary border-bottom pt-6">
            <div class="container-fluid">
                <div class="mb-npx">
                    <div class="row align-items-center">
                        <div class="col-sm-6 col-12 mb-4 mb-sm-0">
                            <!-- Title -->
                            <h1 class="h2 mb-0 ls-tight">Application</h1>
                        </div> <!-- Actions -->
                        <div class="col-sm-6 col-12 text-sm-end">
                            <div class="mx-n1"> 
                                <a href="#" class="btn d-inline-flex btn-sm btn-neutral border-base mx-1"> <span class=" pe-2"> <i class="bi bi-pencil"></i> </span> <span>Edit</span> </a> 
                                <a href="upNewProduct.jsp?action=createdNewP" class="btn d-inline-flex btn-sm btn-primary mx-1"> <span class=" pe-2"> <i class="bi bi-plus"></i> </span> <span>Create</span> </a> </div>
                        </div>
                    </div> <!-- Nav -->
                    <ul class="nav nav-tabs mt-4 overflow-x border-0">
                        <li class="nav-item "> <a href="#" class="nav-link active">All files</a> </li>
                        <li class="nav-item"> <a href="#" class="nav-link font-regular">Shared</a> </li>
                        <li class="nav-item"> <a href="#" class="nav-link font-regular">File requests</a> </li>
                    </ul>
                </div>
            </div>
        </header>
    </body>
</html>
