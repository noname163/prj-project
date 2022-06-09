<%-- 
    Document   : addToCart
    Created on : Jan 25, 2022, 9:40:32 AM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add to Cart Page</title>
        <link rel="stylesheet" href="CSS/addToCart.css" type="text/css" media="all"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="js/confirmWindow.js"></script>
        <style>
            body {
                background: #ddd;
                min-height: 100vh;
                vertical-align: middle;
                display: flex;
                font-family: sans-serif;
                font-size: 0.8rem;
                font-weight: bold
            }

            .title {
                margin-bottom: 5vh
            }

            .card {
                margin: auto;
                max-width: 950px;
                width: 90%;
                box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
                border-radius: 1rem;
                border: transparent
            }

            @media(max-width:767px) {
                .card {
                    margin: 3vh auto
                }
            }

            .cart {
                background-color: #fff;
                padding: 4vh 5vh;
                border-bottom-left-radius: 1rem;
                border-top-left-radius: 1rem
            }

            @media(max-width:767px) {
                .cart {
                    padding: 4vh;
                    border-bottom-left-radius: unset;
                    border-top-right-radius: 1rem
                }
            }

            .summary {
                background-color: #ddd;
                border-top-right-radius: 1rem;
                border-bottom-right-radius: 1rem;
                padding: 4vh;
                color: rgb(65, 65, 65)
            }

            @media(max-width:767px) {
                .summary {
                    border-top-right-radius: unset;
                    border-bottom-left-radius: 1rem
                }
            }

            .summary .col-2 {
                padding: 0
            }

            .summary .col-10 {
                padding: 0
            }

            .row {
                margin: 0
            }

            .title b {
                font-size: 1.5rem
            }

            .main {
                margin: 0;
                padding: 2vh 0;
                width: 100%
            }

            .col-2,
            .col {
                padding: 0 1vh
            }

            a {
                padding: 0 1vh
            }

            .close {
                margin-left: auto;
                font-size: 0.7rem
            }

            img {
                width: 3.5rem
            }

            .back-to-shop {
                margin-top: 4.5rem
            }

            h5 {
                margin-top: 4vh
            }

            hr {
                margin-top: 1.25rem
            }

            form {
                padding: 2vh 0
            }

            select {
                border: 1px solid rgba(0, 0, 0, 0.137);
                padding: 1.5vh 1vh;
                margin-bottom: 4vh;
                outline: none;
                width: 100%;
                background-color: rgb(247, 247, 247)
            }

            input {
                border: 1px solid rgba(0, 0, 0, 0.137);
                padding: 1vh;
                margin-bottom: 4vh;
                outline: none;
                width: 100%;
                background-color: rgb(247, 247, 247)
            }

            input:focus::-webkit-input-placeholder {
                color: transparent
            }

            .btn {
                background-color: #000;
                border-color: #000;
                color: white;
                width: 100%;
                font-size: 0.7rem;
                margin-top: 4vh;
                padding: 1vh;
                border-radius: 0
            }

            .btn:focus {
                box-shadow: none;
                outline: none;
                box-shadow: none;
                color: white;
                -webkit-box-shadow: none;
                -webkit-user-select: none;
                transition: none
            }

            .btn:hover {
                color: white
            }

            a {
                color: black
            }

            a:hover {
                color: black;
                text-decoration: none
            }

            #code {
                background-image: linear-gradient(to left, rgba(255, 255, 255, 0.253), rgba(255, 255, 255, 0.185)), url("https://img.icons8.com/small/16/000000/long-arrow-right.png");
                background-repeat: no-repeat;
                background-position-x: 95%;
                background-position-y: center
            }
            /*            product suggestion*/





        </style>
    </head>
    <body>
        <div class="card">
            <div class="row">
                <div class="col-md-8 cart">
                    <div class="title">
                        <div class="row">
                            <div class="col">
                                <h4><b>Shopping Cart</b></h4>
                            </div>
                            <div class="col align-self-center text-right text-muted" id="items">3 items</div>
                        </div>
                    </div>

                    <div class="row border-top border-bottom">
                        <c:forEach items="${sessionScope.tmpCart}" var="o">
                            <div class="row main align-items-center">
                                <div class="col-2"><img class="img-fluid" src="${o.productImg}"></div>
                                <div class="col">
                                    <div class="row text-muted">Flower</div>
                                    <div class="row">${o.productName}</div>
                                </div>
                                <div class="col" style=" display: block; margin-top: 2em;"> 
                                    <a href="addToCart?action=subtract&pId=${o.productId}" >-</a>
                                    <input type="number" class="quantity" name="amount" id="${o.productId}" value="${o.quantity}")}" style="width:45px; text-align: center">
                                    <a href="addToCart?action=plush&pId=${o.productId}">+</a> 

                                </div>
                                <div class="col">&dollar; <span class="price"> ${o.productPrice}</span><a href="addToCart?action=cancel&pId=${o.productId}"><span class="close">&#10005;</span></a></div><br>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="back-to-shop"><a href="paging?action=pageIndex&index=${page}">&leftarrow;</a><span class="text-muted">Back to shop</span></div>
                    <div id="product-suggestion" style=" width: 45em; height: 20em; " >
                        <div><h5>You might like</h5></div>
                        <div class="" style="display: inline-block; width: 45em; clear: both">
                            <c:forEach items="${sessionScope.suggestion==null||sessionScope.suggestion.isEmpty()?sessionScope.topProduct:sessionScope.suggestion}" var="o" >
                                <div class="card" style="margin-top: 1em; margin-left: 2em;display: block; float: left; width: 11.5em; height: 15em">
                                    <img class="card-img-top" src="${o.productImg}" alt="Card image cap" width="20em" height="92em">
                                    <div class="card-body">
                                        <div style="display: block; width: 115px; height: 45px; ">
                                            <h6 class="card-title show_txt" style=" text-align: center" >
                                                <a href="detail?action=detail&Dvalue=${o.productName}"  title="View Product" style="font-size: large; font-weight: bold;text-align: center">${o.productName}</a>
                                            </h6>
                                        </div>
                                        <div class="row" style="">
                                            <div  style=" display: inline-block; width: 20em; height: 2.5em; clear: both">
                                                <div style="display: block; width: 4.5em; height: 2em; float: left">
                                                    <p class="btn btn-danger btn-block" style="display: contents; font-size: large; color: blue"  >${o.productPrice}</p>
                                                </div>
                                                <div style=" display: block; width: fit-content; height: fit-content; float: left; margin-left: 1.5em">
                                                    <a href="addToCart?action=addToCart&pId=${o.productId}" style="display: contents" ><img src="Img/round-add-button.png" alt="addtocardbutton" style="display: block; width: 2em" /></a>  
                                                </div> 
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div> 
                    </div>
                </div>
                <div class="col-md-4 summary">
                    <div>
                        <h5><b>Summary</b></h5>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col" id="nItems" style="padding-left:0;">ITEMS 0
                            <script>
                                document.getElementById("nItems").innerHTML = "ITEMS " + document.getElementsByClassName("quantity").length;
                                document.getElementById("items").innerHTML = "ITEMS " + document.getElementsByClassName("quantity").length;
                            </script>
                        </div>
                        <div class="col text-right" id="sum">&dollar; ${sessionScope.total1}</div>
                    </div>
                    <form>
                        <p>SHIPPING</p> <select>
                            <option class="text-muted">Standard-Delivery- &dollar;5.00</option>
                        </select>
                        <p>GIVE CODE</p> <input id="code" placeholder="Enter your code">
                    </form>
                    <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                        <div class="col">TOTAL PRICE</div>
                        <div class="col text-right" id="total" >&dollar; ${sessionScope.total1+5}
                        </div>
                        <c:if test="${sessionScope.tmpCart!=null&&sessionScope.tmpCart.size()!=0}">
                            </div> <a class="btn" href="" onclick="myFunction()" id="submitConfirm" name="submit" style="color: white;">CONFIRM</a>
                        </c:if>
                </div>

            </div>
        </div> 
        <script>
            function myFunction() {
                let text = "Press a button!\nEither OK or Cancel.";
                var a = document.getElementById('submitConfirm');
                if (confirm(text) == true) {
                    a.href = "order?action=confirm";
                } else {
                    a.href = "#";
                }
                console.log(a.herf);
            }
        </script>
    </body>
</html>
