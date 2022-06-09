<%-- 
    Document   : errosPage
    Created on : Jan 13, 2022, 7:58:35 PM
    Author     : ADMIN
--%>

<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach items="${sessionScope.order.value}" var="o">

            <h1>test${sessionScope.order.get("1")}</h1>
            <p>${o.quantity}</p>

        </c:forEach>
        <h1>${sessionScope.account}</h1>
        <c:if test="${sessionScope.account==null}">
            <h1>not null</h1>
        </c:if>
        <h1>${pId}</h1>
        <h1>${action}</h1>
        <h1>${sessionScope.product.size()}</h1>
        <h1>${sessionScope.orderId}</h1>
        <div >
            <div > <input type="date" name="start-date" value="2019-12-21" required> </div>
            <div > <input type="date" name="end-date" value="2019-12-21" required> </div>
        </div>
        <h1>start: ${sDate}</h1>
        <h1>end: ${eDate}</h1>
        <h1>cus: ${cus}</h1>
        <table class="table table-hover table-nowrap">
            <thead class="thead-light">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Status</th>
                    <th scope="col">Role</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${sessionScope.product}" var="o">
                    <tr>
                        <td> <img alt="..." src="${o.productImg}" class="avatar avatar-sm rounded-circle me-2" width="100px" height="95px"> <a class="text-heading font-semibold" href="#"> </a> </td>
                        <td>${o.orderId}</td>
                        <td>  <a class="text-heading font-semibold" href="#"> ${o.productName} </a> </td>
                        
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <h1>Token${token}</h1>
        <h1>${action}</h1>
        <h1>Accid ${accId}</h1>
        <h1>status ${status}</h1>
        <c:set var="varNameTest" value="3" scope="session"/>
        
        <h1>${varNameTest}</h1>
        <c:remove var="varNameTest" scope="session"/>
        <h1>${varNameTest}</h1>
        <h1>filterTest ${filterTest}</h1>
        <h1>filterTest ${filterTest1}</h1>
        
    </body>
</html>
