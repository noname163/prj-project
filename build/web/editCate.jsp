<%-- 
    Document   : editCate
    Created on : Feb 19, 2022, 9:45:55 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>
        <style>
            body {
                background-color: #00838F
            }

            .advanced {
                text-decoration: none;
                font-size: 15px;
                font-weight: 500
            }

            .btn-secondary,
            .btn-secondary:focus,
            .btn-secondary:active {
                color: #fff;
                background-color: #00838f !important;
                border-color: #00838f !important;
                box-shadow: none
            }

            .advanced {
                color: #00838f !important
            }

            .form-control:focus {
                box-shadow: none;
                border: 1px solid #00838f
            }
        </style>
    </head>
    <body>
        <div class="container mt-5">
            <div class="row d-flex justify-content-center">
                <div class="col-md-10">
                    <div class="card p-3 py-4">
                        <h5>Edit Categories ${cateId}</h5>
                        <div class="row g-3 mt-2">
                            <div class="col-md-3">
                                <div class="dropdown"> <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false"> Any Status </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                        <li><a class="dropdown-item" href="#">Rural</a></li>
                                        <li><a class="dropdown-item" href="#">Urban</a></li>
                                        <li><a class="dropdown-item" href="#">All</a></li>
                                    </ul>
                                </div>
                            </div>
                            <form action="editCate?action=editCate&action1=saveC&cId=${cateId}" method="post">
                                <div class="col-md-6">
                                    <input type="text" class="form-control" value="${oldCateName}" name="newCateName" placeholder="Enter categories name"> 
                                </div>
                                <div class="col-md-3"> 
                                    <button class="btn btn-secondary btn-block">Submit</button> 
                                </div>
                            </form>
                        </div>
                        <div class="mt-3"> <a data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample" class="advanced"> Advance Search With Filters <i class="fa fa-angle-down"></i> </a>
                            <div class="collapse" id="collapseExample">
                                <div class="card card-body">
                                    <div class="row">
                                        <div class="col-md-4"> <input type="text" placeholder="Property ID" class="form-control"> </div>
                                        <div class="col-md-4"> <input type="text" class="form-control" placeholder="Search by MAP"> </div>
                                        <div class="col-md-4"> <input type="text" class="form-control" placeholder="Search by Country"> </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
