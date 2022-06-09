<%-- 
    Document   : leftAdmin
    Created on : Feb 5, 2022, 4:53:27 PM
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
        <!-- Vertical Navbar -->
            <nav class="navbar show navbar-vertical h-lg-screen navbar-expand-lg px-0 py-3 navbar-light bg-white border-bottom border-bottom-lg-0 border-end-lg" id="navbarVertical">
                <div class="container-fluid">
                    <!-- Toggler --> <button class="navbar-toggler ms-n2" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarCollapse" aria-controls="sidebarCollapse" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button> <!-- Brand --> <a class="navbar-brand py-lg-2 mb-lg-5 px-lg-6 me-0" href="#"> <img src="https://preview.webpixels.io/web/img/logos/clever-primary.svg" alt="..."> </a> <!-- User menu (mobile) -->
                    <div class="navbar-user d-lg-none">
                        <!-- Dropdown -->
                        <div class="dropdown">
                            <!-- Toggle --> <a href="#" id="sidebarAvatar" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <div class="avatar-parent-child"> <img alt="Image Placeholder" src="https://images.unsplash.com/photo-1548142813-c348350df52b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80" class="avatar avatar- rounded-circle"> <span class="avatar-child avatar-badge bg-success"></span> </div>
                            </a> <!-- Menu -->
                            <div class="dropdown-menu dropdown-menu-end" aria-labelledby="sidebarAvatar"> <a href="#" class="dropdown-item">Profile</a> <a href="#" class="dropdown-item">Settings</a> <a href="#" class="dropdown-item">Billing</a>
                                <hr class="dropdown-divider"> <a href="logout" class="dropdown-item">Logout</a> </div>
                        </div>
                    </div> <!-- Collapse -->
                    <div class="collapse navbar-collapse" id="sidebarCollapse">
                        <!-- Navigation -->
                        <ul class="navbar-nav">
                            <li class="nav-item"> <a class="nav-link" href="Admin"> <i class="bi bi-house"></i> Dashboard </a> </li>
                            <li class="nav-item"> <a class="nav-link" href="Home"> <i class="bi bi-bar-chart"></i> Home Page </a> </li>
                            <li class="nav-item"> <a class="nav-link" href="catePage.jsp"> <i class="bi bi-chat"></i> Categories <span class="badge bg-soft-primary text-primary rounded-pill d-inline-flex align-items-center ms-auto">${cList.size()}</span> </a> </li>
                            <li class="nav-item"> <a class="nav-link" href="productManage"> <i class="bi bi-bookmarks"></i> Products </a> </li>
                            <li class="nav-item"> <a class="nav-link" href="manageUser?action=userList"> <i class="bi bi-people"></i> Users </a> </li>
                        </ul> <!-- Divider -->
                        <hr class="navbar-divider my-5 opacity-20"> <!-- Navigation -->
                        <ul class="navbar-nav mb-md-4">
                            <li>
                                <div class="nav-link text-xs font-semibold text-uppercase text-muted ls-wide"> Contacts <span class="badge bg-soft-primary text-primary rounded-pill d-inline-flex align-items-center ms-4">13</span> </div>
                            </li>
                            <li> <a href="#" class="nav-link d-flex align-items-center">
                                    <div class="me-4">
                                        <div class="position-relative d-inline-block text-white"> <img alt="Image Placeholder" src="https://images.unsplash.com/photo-1548142813-c348350df52b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80" class="avatar rounded-circle"> <span class="position-absolute bottom-2 end-2 transform translate-x-1/2 translate-y-1/2 border-2 border-solid border-current w-3 h-3 bg-success rounded-circle"></span> </div>
                                    </div>
                                    <div> <span class="d-block text-sm font-semibold"> Marie Claire </span> <span class="d-block text-xs text-muted font-regular"> Paris, FR </span> </div>
                                    <div class="ms-auto"> <i class="bi bi-chat"></i> </div>
                                </a> </li>
                            <li> <a href="#" class="nav-link d-flex align-items-center">
                                    <div class="me-4">
                                        <div class="position-relative d-inline-block text-white"> <span class="avatar bg-soft-warning text-warning rounded-circle">JW</span> <span class="position-absolute bottom-2 end-2 transform translate-x-1/2 translate-y-1/2 border-2 border-solid border-current w-3 h-3 bg-success rounded-circle"></span> </div>
                                    </div>
                                    <div> <span class="d-block text-sm font-semibold"> Michael Jordan </span> <span class="d-block text-xs text-muted font-regular"> Bucharest, RO </span> </div>
                                    <div class="ms-auto"> <i class="bi bi-chat"></i> </div>
                                </a> </li>
                            <li> <a href="#" class="nav-link d-flex align-items-center">
                                    <div class="me-4">
                                        <div class="position-relative d-inline-block text-white"> <img alt="..." src="https://images.unsplash.com/photo-1610899922902-c471ae684eff?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=3&w=256&h=256&q=80" class="avatar rounded-circle"> <span class="position-absolute bottom-2 end-2 transform translate-x-1/2 translate-y-1/2 border-2 border-solid border-current w-3 h-3 bg-danger rounded-circle"></span> </div>
                                    </div>
                                    <div> <span class="d-block text-sm font-semibold"> Heather Wright </span> <span class="d-block text-xs text-muted font-regular"> London, UK </span> </div>
                                    <div class="ms-auto"> <i class="bi bi-chat"></i> </div>
                                </a> </li>
                        </ul> <!-- Push content down -->
                        <div class="mt-auto"></div> <!-- User (md) -->
                        <ul class="navbar-nav">
                            <li class="nav-item"> <a class="nav-link" href="#"> <i class="bi bi-person-square"></i> Account </a> </li>
                            <li class="nav-item"> <a class="nav-link" href="#"> <i class="bi bi-box-arrow-left"></i> Logout </a> </li>
                        </ul>
                    </div>
                </div>
            </nav>
    </body>
</html>
