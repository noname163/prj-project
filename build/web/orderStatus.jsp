<%-- 
    Document   : orderStatus
    Created on : Jan 24, 2022, 2:14:08 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  errorPage="errosPage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js" integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/" crossorigin="anonymous"></script>

    </head>
    <body>
        <div class="container my-5">
            <form action="controller" method="get" class="d-md-flex d-sm-block justify-content-between"> <input type="hidden" name="command" value="select-orders">
                <h1 class="h5 align-self-center col-3">Search Order</h1>
                <div class="btn-group align-self-center col-12 col-sm-12 col-md-8 col-lg-6"> <select name="searchType" class="btn btn-outline-dark col-3 col-sm-3">
                        <option value="orderId">Order ID</option>
                        <option value="created">Created</option>
                        <option value="customer">Customer</option>
                        <option value="status">Status</option>
                    </select> <input type="search" name="searchBy" class="col-6 col-sm-6"> <input type="submit" value="Search" class="btn btn-outline-dark col-3 col-sm-3"> </div>
            </form>
            <div class="d-md-flex d-none justify-content-md-between justify-content-sm-center align-content-center border-bottom border-2 my-2 bg-dark text-light p-3 rounded-3">
                <div class="col-2 text-sm-center text-md-start align-self-center">
                    <h1 class="h5 fw-bold">Order ID</h1>
                </div>
                <div class="col-2 align-self-center">
                    <h1 class="h5 fw-bold">Created</h1>
                </div>
                <div class="col-3 align-self-center">
                    <h1 class="h5 fw-bold">Customer</h1>
                </div>
                <div class="col-2 align-self-center">
                    <h1 class="h5 fw-bold">Show details</h1>
                </div>
                <div class="col-2 align-self-center">
                    <h1 class="h5 fw-bold">Status</h1>
                </div>
            </div>
            <div class="d-md-flex d-sm-block justify-content-md-between justify-content-sm-center text-center border-bottom border-2 my-2 bg-light p-2 rounded-3">
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
                    <h1 class="h6">2F456DA</h1>
                </div>
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
                    <h1 class="h6">04/12/2021 3:15:24:299</h1>
                </div>
                <div class="col-md-3 text-sm-center text-md-start align-self-center my-2">
                    <h1 class="h6">Robert Tailor Hamonovych</h1>
                </div>
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2"> <a class="btn btn-outline-dark w-100" href="#">Details</a> </div>
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
                    <form method="get" action="controller" class="d-flex btn-group"> <input type="hidden" name="command" value="refresh-order-status"> <select name="status" class="btn btn-outline-dark">
                            <option value="REGISTERED" class="form-select-button">REGISTERED</option>
                            <option value="PAID" class="form-select-button">PAID</option>
                            <option value="CANCELED" class="form-select-button">CANCELED</option>
                        </select> <input type="submit" class="btn btn-outline-dark" value="OK"> </form>
                </div>
            </div>
            <div class="d-md-flex d-sm-block justify-content-md-between justify-content-sm-center text-center border-bottom border-2 my-2 bg-light p-2 rounded-3">
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
                    <h1 class="h6">D2903WE</h1>
                </div>
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
                    <h1 class="h6">03/09/2021 3:15:24:299</h1>
                </div>
                <div class="col-md-3 text-sm-center text-md-start align-self-center my-2">
                    <h1 class="h6">Jason Tailor Hamonovych</h1>
                </div>
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2"> <a class="btn btn-outline-dark w-100" href="#">Details</a> </div>
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
                    <form method="get" action="controller" class="d-flex btn-group"> <input type="hidden" name="command" value="refresh-order-status"> <select name="status" class="btn btn-outline-dark">
                            <option value="REGISTERED" class="form-select-button">REGISTERED</option>
                            <option value="PAID" class="form-select-button">PAID</option>
                            <option value="CANCELED" class="form-select-button">CANCELED</option>
                        </select> <input type="submit" class="btn btn-outline-dark" value="OK"> </form>
                </div>
            </div>
            <div class="d-md-flex d-sm-block justify-content-md-between justify-content-sm-center text-center border-bottom border-2 my-2 bg-light p-2 rounded-3">
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
                    <h1 class="h6">5463783D</h1>
                </div>
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
                    <h1 class="h6">19/10/2021 3:34:24:299</h1>
                </div>
                <div class="col-md-3 text-sm-center text-md-start align-self-center my-2">
                    <h1 class="h6">Mike Orley Hemington</h1>
                </div>
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2"> <a class="btn btn-outline-dark w-100" href="#">Details</a> </div>
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
                    <form method="get" action="controller" class="d-flex btn-group"> <input type="hidden" name="command" value="refresh-order-status"> <select name="status" class="btn btn-outline-dark">
                            <option value="REGISTERED" class="form-select-button">REGISTERED</option>
                            <option value="PAID" class="form-select-button">PAID</option>
                            <option value="CANCELED" class="form-select-button">CANCELED</option>
                        </select> <input type="submit" class="btn btn-outline-dark" value="OK"> </form>
                </div>
            </div>
            <div class="d-md-flex d-sm-block justify-content-md-between justify-content-sm-center text-center border-bottom border-2 my-2 bg-light p-2 rounded-3">
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
                    <h1 class="h6">324516AD</h1>
                </div>
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
                    <h1 class="h6">03/02/2021 22:45:44:999</h1>
                </div>
                <div class="col-md-3 text-sm-center text-md-start align-self-center my-2">
                    <h1 class="h6">Jessy Koper Fauer</h1>
                </div>
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2"> <a class="btn btn-outline-dark w-100" href="#">Details</a> </div>
                <div class="col-md-2 text-sm-center text-md-start align-self-center my-2">
                    <form method="get" action="controller" class="d-flex btn-group"> <input type="hidden" name="command" value="refresh-order-status"> <select name="status" class="btn btn-outline-dark">
                            <option value="REGISTERED" class="form-select-button">REGISTERED</option>
                            <option value="PAID" class="form-select-button">PAID</option>
                            <option value="CANCELED" class="form-select-button">CANCELED</option>
                        </select> <input type="submit" class="btn btn-outline-dark" value="OK"> </form>
                </div>
            </div>
        </div>
    </body>
</html>
