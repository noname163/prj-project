<%-- 
    Document   : packagePage
    Created on : Jan 24, 2022, 3:52:22 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Package Page</title>
        <link rel="stylesheet" href="CSS/package.css" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <style>
            body {
                min-height: 100vh;
                background-size: cover;
                font-family: 'Lato', sans-serif;
                color: rgba(116, 116, 116, 0.667);
                background: linear-gradient(140deg, #fff, 50%, #BA68C8)
            }

            .container-fluid {
                margin-top: 200px
            }

            p {
                font-size: 14px;
                margin-bottom: 7px
            }

            .small {
                letter-spacing: 0.5px !important
            }

            .card-1 {
                box-shadow: 2px 2px 10px 0px rgb(190, 108, 170)
            }

            hr {
                background-color: rgba(248, 248, 248, 0.667)
            }

            .bold {
                font-weight: 500
            }

            .change-color {
                color: #AB47BC !important
            }

            .card-2 {
                box-shadow: 1px 1px 3px 0px rgb(112, 115, 139)
            }

            .fa-circle.active {
                font-size: 8px;
                color: #AB47BC
            }

            .fa-circle {
                font-size: 8px;
                color: #aaa
            }

            .rounded {
                border-radius: 2.25rem !important
            }

            .progress-bar {
                background-color: #AB47BC !important
            }

            .progress {
                height: 5px !important;
                margin-bottom: 0
            }

            .invoice {
                position: relative;
                top: -70px
            }

            .Glasses {
                position: relative;
                top: -12px !important
            }

            .card-footer {
                background-color: #AB47BC;
                color: #fff
            }

            h2 {
                color: rgb(78, 0, 92);
                letter-spacing: 2px !important
            }

            .display-3 {
                font-weight: 500 !important
            }

            @media (max-width: 479px) {
                .invoice {
                    position: relative;
                    top: 7px
                }

                .border-line {
                    border-right: 0px solid rgb(226, 206, 226) !important
                }
            }

            @media (max-width: 700px) {
                h2 {
                    color: rgb(78, 0, 92);
                    font-size: 17px
                }

                .display-3 {
                    font-size: 28px;
                    font-weight: 500 !important
                }
            }

            .card-footer small {
                letter-spacing: 7px !important;
                font-size: 12px
            }

            .border-line {
                border-right: 1px solid rgb(226, 206, 226)
            }
        </style>
    </head>
    <body>
      
            <div class="container-fluid my-5 d-flex justify-content-center">
                <div class="card card-1">
                    <div class="card-header bg-white">
                        <div class="media flex-sm-row flex-column-reverse justify-content-between ">
                            <div class="col my-auto">
                            <c:if test="${sessionScope.product==null}">
                                <h4 class="mb-0">Your Order Empty,<span class="change-color"><a href="Home" style="color:greenyellow" >Click Here To Order</a></span> !</h4>
                            </c:if>
                            <c:if test="${sessionScope.product!=null}">
                                <form action="filter?action=filter&from=cart" method="post" style="display: block">
                                    <select onclick="change()" id="status"  name="status" style="border: solid 2px #000; border-radius: 0.5em; background-color: gainsboro; text-align: center; height: fit-content" >
                                            <option  value="1" onclick="change()" >Processing</option>
                                            <option value="2" onclick="change()">Completed</option>
                                            <option value="3" onclick="change()" >Cancel</option>
                                        </select>
                                        <input id="start-date" value=""  type="date" name="start-date" style="border: solid 2px #000; border-radius: 0.5em; display:none;"  >
                                        <input id="end-date" value=""  type="date" name="end-date"   style="border: solid 2px #000; border-radius: 0.5em; display: none;"  >
                                        <select onclick="change()" id="select" name="select" style="border: solid 2px #000; border-radius: 0.5em; background-color: gainsboro; text-align: center; ">
                                            <option value="status" onclick="change()" >By Status</option>
                                            <option  value="date" onclick="change()" >By Date</option>
                                            <option value="all" onclick="change()">All</option>
                                        </select>
                                        <button type="submit" style="border-radius: 0.5em" > Submit</button>      
                                        <script>
                                            function change(){
                                               var value = document.getElementById("select").value;
                                               var start = document.getElementById("start-date");
                                               var end = document.getElementById("end-date");
                                               if(value==="date" ){
                                                   start.style.display = "";
                                                   end.style.display="";
                                                   end.setAttribute("required", "");
                                                   start.setAttribute("required", "");
                                                   document.getElementById("status").removeAttribute("required");
                                                   document.getElementById("status").style.display="none";
                                               }else if(value==="all" ){
                                                   start.style.display = "none";
                                                   end.style.display="none";
                                                   document.getElementById("status").style.display="none";
                                                   end.removeAttribute("required");
                                                   start.removeAttribute("required");
                                                   document.getElementById("status").removeAttribute("required");
                                                   document.getElementById("status").style.display="none";
                                               }
                                               else{
                                                   start.style.display = "none";
                                                   end.style.display="none";
                                                   end.removeAttribute("required");
                                                   start.removeAttribute("required");
                                                   document.getElementById("status").style.display="";
                                               }
                                               console.log(value);
                                               console.log(document.getElementById("status").value);
                                           }
                                        </script>
                                </form>
                                <h4 class="mb-0">Thanks For Order,<span class="change-color">${sessionScope.account.fullName}</span> !</h4>
                                
                            </c:if>
                        </div>
                        <div class="col-auto text-center my-auto pl-0 pt-sm-4"> 
                            <a  href="Home" >
                                <img class="img-circle my-auto align-items-center mb-0 pt-3" src="Img/HomeIcon1.png" width="115" height="115" >
                            </a>
                            <p class="mb-4 pt-0 Glasses">Flowers For Everyone</p>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row justify-content-between mb-3">
                        <div class="col-auto">
                            <h6 class="color-1 mb-0 change-color">Receipt</h6>
                        </div>
                        <div class="col-auto "> <small>Receipt Voucher : 1KAU9-84UIL</small> </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="card card-2">
                                <c:forEach items="${sessionScope.product}" var="o">
                                    <div class="card-body">
                                        <div class="media">
                                            <div class="sq align-self-center "> <a href="detail?Dvalue=${o.productName}"><img class="img-fluid my-auto align-self-center mr-2 mr-md-4 pl-0 p-0 m-0" src="${o.productImg}" width="135" height="135" /></a> </div>
                                            <div class="media-body my-auto text-right">
                                                <div class="row my-auto flex-column flex-md-row">
                                                    <div class="col my-auto">
                                                        <h6 class="mb-0" style="font-size:12px">OrderId: ${o.orderId}</h6>
                                                    </div>
                                                    <div class="col my-auto"> <small style="font-size:10px">${o.orderDate}</small></div>
                                                    <div class="col my-auto" style="text-align: center;"> <small style="font-size:10px">${o.productName}</small></div>
                                                    <div class="col my-auto"> <small style="font-size:10px">Qty : ${o.quantity}</small></div>
                                                    <div class="col my-auto">
                                                        <h6 class="mb-0">&dollar;${o.productPrice}</h6>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <hr class="my-3 ">
                                        <div class="row">
                                            <div class="col-md-3 mb-3"> <small> Track Order <span><i class=" ml-2 fa fa-refresh" aria-hidden="true"></i></span></small> </div>

                                            <div class="col mt-auto">
                                                <div class="progress my-auto">
                                                    <c:if test="${o.orderStatus==1}">
                                                        <div class="progress-bar progress-bar rounded" style="width: 26%" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>  
                                                    </c:if>
                                                    <c:if test="${o.orderStatus==2}">
                                                        <div class="progress-bar progress-bar rounded" style="width: 100%" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>  
                                                    </c:if>

                                                </div>
                                                <div class="media row justify-content-between ">
                                                    <div class="col-auto text-right"><span> <small class="text-right mr-sm-2">Order Processing</small> <i class="fa fa-circle ${o.orderStatus>=1 ? "active" : ""}"></i> </span></div>
                                                    <div class="flex-col"> <span> <small class="text-right mr-sm-2">Out for delivary</small><i class="fa fa-circle ${o.orderStatus>=2 ? "active" : ""}"></i></span></div>
                                                    <div class="col-auto flex-col-auto"><small class="text-right mr-sm-2">Delivered</small><span> <i class="fa fa-circle ${o.orderStatus>=2 ? "active" : ""}"></i></span></div>
                                                </div>
                                            </div>

                                        </div>
                                        <c:if test="${o.orderStatus==1}">
                                            <a id="cancel" onclick="alterF('cancel','You want to cancel the orderID:${o.orderId}','cancelOrder?action=cancel&pId=${o.orderId}','#')" href="cancelOrder?action=cancel&pId=${o.orderId}" style="color:red;">Cancel Order</a>
                                        </c:if>
                                        <c:if test="${o.orderStatus==3}">
                                            <a id="re-order" onclick="alterF('re-order','You want to  re-order the orderId:${o.orderId}','cancelOrder?action=re-order&pId=${o.orderId}','#')" href="cancelOrder?action=re-order&pId=${o.orderId}" style="color:greenyellow;">Re-order</a>
                                        </c:if>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="col">
                            <div class="row justify-content-between">
                                <div class="col-auto">
                                    <p class="mb-1 text-dark"><b>Order Details</b></p>
                                </div>
                                <div class="flex-sm-col text-right col">
                                    <p class="mb-1"><b>Total</b></p>
                                </div>
                                <div class="flex-sm-col col-auto">
                                    <p class="mb-1">&dollar; ${sessionScope.total}</p>
                                </div>
                            </div>
                            <div class="row justify-content-between">
                                <div class="flex-sm-col text-right col">
                                    <p class="mb-1"> <b>Discount</b></p>
                                </div>
                                <div class="flex-sm-col col-auto">
                                    <p class="mb-1">&#8377;150</p>
                                </div>
                            </div>
                            <div class="row justify-content-between">
                                <div class="flex-sm-col text-right col">
                                    <p class="mb-1"><b>GST 18%</b></p>
                                </div>
                                <div class="flex-sm-col col-auto">
                                    <p class="mb-1">843</p>
                                </div>
                            </div>
                            <div class="row justify-content-between">
                                <div class="flex-sm-col text-right col">
                                    <p class="mb-1"><b>Delivery Charges</b></p>
                                </div>
                                <div class="flex-sm-col col-auto">
                                    <p class="mb-1">Free</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row invoice ">
                        <div class="col">
                            <p class="mb-1" > Name : ${sessionScope.account.fullName}</p>
                            <p class="mb-1">Invoice Date : ${sessionScope.orderDate}</p>
                            <p class="mb-1">Recepits Voucher:18KU-62IIK</p>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="jumbotron-fluid">
                        <div class="row justify-content-between ">
                            <div class="col-sm-auto col-auto my-auto"><img class="img-fluid my-auto align-self-center " src="https://i.imgur.com/7q7gIzR.png" width="115" height="115"></div>
                            <div class="col-auto my-auto ">
                                <h2 class="mb-0 font-weight-bold">TOTAL PAID</h2>
                            </div>
                            <div class="col-auto my-auto ml-auto">
                                <h1 class="display-3 ">&#8377; 5,528</h1>
                            </div>
                        </div>
                        <div class="row mb-3 mt-3 mt-md-0">
                            <div class="col-auto border-line"> <small class="text-white">PAN:AA02hDW7E</small></div>
                            <div class="col-auto border-line"> <small class="text-white">CIN:UMMC20PTC </small></div>
                            <div class="col-auto "><small class="text-white">GSTN:268FD07EXX </small> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function alterF(id,alter,href1,href2) {
                let text = alter;
                var a = document.getElementById(id);
                if (confirm(text) === true) {
                    a.href = href1;
                } else {
                    a.href = "#";
                }
            }
        </script>
    </body>
</html>
