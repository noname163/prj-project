<%-- 
    Document   : imgUpload
    Created on : Feb 4, 2022, 10:54:50 AM
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
        <form class="form-horizontal"  enctype='multipart/form-data' action="uploadProduct" method="post">
            <fieldset>

                <!-- Form Name -->
                <legend><a href="adminPage.jsp">HOME</a></legend>


                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="product_name">PRODUCT NAME</label>  
                    <div class="col-md-4">
                        <input id="product_name" name="product_name" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text">

                    </div>
                </div>


                <!-- Select Basic -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="product_categorie">PRODUCT CATEGORY</label>
                    <div class="col-md-4">

                        <input list="scripts" autofocus="" name="product_categorie">
                        <datalist id="scripts">
                            <c:forEach items="${sessionScope.allC}" var = "o">
                                <option value="${o.id}">${o.categoriesName}</option>
                            </c:forEach>
                        </datalist>

                    </div>
                </div>



                <!-- Textarea -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="product_description">PRODUCT DESCRIPTION</label>
                    <div class="col-md-4">                     
                        <textarea class="form-control" id="product_description" name="product_description"></textarea>
                    </div>
                </div>



                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="price">Price</label>  
                    <div class="col-md-4">
                        <input id="author" name="price" placeholder="Price" class="form-control input-md" required="" type="number">

                    </div>
                </div>


                <!-- Text input-->
                <div class="form-group">

                    <div class="col-md-8">


                        <!-- File Button --> 
                        <div class="form-group">
                            <label class="col-md-6 control-label" for="filebutton">main_image</label>
                            <div class="col-md-6">
                                <input id="filebutton" name="filebutton" class="input-file"  type="file" required="">
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
