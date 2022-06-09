<%-- 
    Document   : editUserProfile
    Created on : Feb 1, 2022, 9:37:07 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/editUserProfile.css" type="text/css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="container d-flex justify-content-center align-items-center">
            <div class="card py-4">
                <h5 class="font-weight-normal">Personal Details</h5> <span class="notify-text">Feel free to edit your basic information such as name, email etc.</span>
                <div class="mt-3"> <span class="accounts">Merged Accounts</span>

                </div>
                <div class="mt-3">
                    <form action="user?action=saveChange" method="post">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="inputbox mt-3"> <input type="text" name="fullName" class="form-control" value="${sessionScope.account.fullName}" required="required"> <span>Full Name</span> </div>
                            </div>
                            <div class="col-md-6">
                                <div class="inputbox mt-3"> <input type="text" name="phone" class="form-control" value="${sessionScope.account.phone}" required="required"> <span>Phone </span> </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="inputbox mt-3"> <input type="text" name="email" class="form-control" value="${sessionScope.account.email}" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" > <span>Email Address</span> </div>
                                <c:if test="${sessionScope.alter!=null}">
                                <p class="align-self-center" style="color: red;">${sessionScope.alter}</p>
                                </c:if>
                            </div>
                        </div>
                        <button class="btn btn-primary btn-sm buttons">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
