<%-- 
    Document   : editProductServlet
    Created on : Feb 13, 2022, 4:47:04 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Image File</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    </head>
    <body>
        <form class="form-horizontal"  enctype='multipart/form-data' action="editProduct?action=saveC&pId=${pId}" method="post">
            <fieldset>

                <!-- Form Name -->
                <legend><a href="mainController?action=adminDisplay">HOME</a></legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="product_name">PRODUCT NAME</label>  
                        <div class="col-md-4">
                            <input id="product_name" name="product_name" placeholder="PRODUCT NAME" value="${product.productName}" class="form-control input-md" required="" type="text">

                        </div>
                    </div>


                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="product_categorie">PRODUCT CATEGORY</label>
                        <div class="col-md-4">
                           
                            <input list="scripts" autofocus="" placeholder="${product.cateId}"  name="product_categorie">
                            <datalist id="scripts">
                                <c:forEach items="${sessionScope.cList}" var = "o">
                                    <option value="${o.id}">${o.categoriesName}</option>
                                </c:forEach>
                            </datalist>

                        </div>
                    </div>



                    <!-- Textarea -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="product_description">PRODUCT DESCRIPTION</label>
                        <div class="col-md-4">                     
                            <textarea class="form-control" id="product_description" name="product_description">
                                ${product.productDecription}
                            </textarea>
                        </div>
                    </div>



                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="price">Price</label>  
                        <div class="col-md-4">
                            <input id="author"  name="price" placeholder="Price" class="form-control input-md" required="" type="number" value="${product.productPrice}">

                        </div>
                    </div>


                    <!-- Text input-->
                    <div class="form-group">

                        <div class="col-md-8">


                            <!-- File Button --> 
                            <div class="form-group">
                                <label class="col-md-6 control-label" for="filebutton">main_image</label>
                                <div class="col-md-6">
                                    <input id="filebutton" name="filebutton" class="input-file"  type="file" >
                                </div>
                            </div>
                            <!-- File Button --> 


                            <!-- Button -->
                            <div class="form-group">
                                <label class="col-md-6 control-label" for="singlebutton">Submit</label>
                                <div class="col-md-6">
                                    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Submit</button>
                                </div>
                            </div>

                            </fieldset>
                            </form>

                        </body>
                        </html>