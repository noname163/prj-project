<%-- 
    Document   : userProfie
    Created on : Feb 1, 2022, 9:33:34 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/userProfile.css" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"/>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <style>
            body {
                font-family: 'Saira Semi Condensed', sans-serif;
                background-color: grey;
            }

            .tick {
                position: relative;
                top: 0.5vh
            }

            .main {
                height: auto;
                width: 35vw;
                background-color: white;
                margin: auto;
                position: relative;
                top: 15vh;
                padding: 3vh
            }

            .picture img {
                height: 8vw;
                width: 8vw;
                position: relative;
                top: 1vw
            }

            .add {
                background-color: #43a047;
                position: relative;
                top: 3vw;
                right: 2vw
            }

            .name {
                font-size: 20px
            }

            .details p {
                position: relative;
                top: 1vw
            }

            .name i {
                color: blue
            }

            td {
                text-align: center
            }

            tr {
                border: 2px solid white
            }

            .table {
                margin-top: 2vw
            }

            .edit {
                background-color: #43a047;
                width: 90%;
                color: #fff !important
            }

            @media only screen and (max-width: 425px) {
                .main {
                    width: 100vw;
                    height: auto
                }

                .picture img {
                    height: 40vw;
                    width: 40vw;
                    position: relative;
                    left: 5vw
                }

                .details p {
                    position: relative;
                    top: 5vw
                }

                .add {
                    position: relative;
                    top: 8vw
                }
            }

            @media only screen and (max-height: 725px) {
                .main {
                    height: auto
                }
            }
        </style>
    </head>
    <body>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <div class="z-depth-5 main">
            <div class="row">
                <div class="col-sm-6 picture">
                <div class="back-to-shop"><a href="Home">&leftarrow;</a><span class="text-muted">Back to home</span></div>
                    <center><img class="circle responsive-img" src="Img/avatar.jpg"><span><a class="btn-floating pulse waves-effect waves-light add"><i class="material-icons">add</i></a></span></center>
                </div>
                <div class="col-sm-6 details">
                    <center>
                        <p class="name"><b>${sessionScope.account.fullName}</b> <i class="material-icons tick">check_circle</i></p>
                    </center>
                    <center>
                        <p>Phone: ${sessionScope.account.phone}</p>
                    </center>
                    <center>
                        <p>Email: ${sessionScope.account.email}</p>
                    </center>
                </div>
            </div>
            <table class="table">
                <tr>
                    <td>
                        <p><b>Order</b></p>
                        <c:if test="${sessionScope.items==null}">
                            <p>0</p>
                        </c:if>
                        <c:if test="${sessionScope.items!=null}">
                            <a href="packagePage.jsp"><p style="color:black;">${sessionScope.items}</p></a>
                        </c:if>
                    </td>
                    <td>
                        <p><b>Role</b></p>
                        <c:if test="${sessionScope.account.role==1}">
                            <p>Customer</p>
                        </c:if>
                        <c:if test="${sessionScope.account.role==0}">
                            <p>Admin</p>
                        </c:if>
                    </td>
                    <td>
                        <p><b>Rank</b></p>
                        <p>1</p>
                    </td>
                </tr>
            </table>
                    <center><a class="waves-effect waves-light btn edit" href="editUserProfile.jsp">Edit Profile</a></center>
        </div>
    </body>
</html>
