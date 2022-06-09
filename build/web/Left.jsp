

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3" >
    <div class="card bg-light mb-3" style="display: block; height: fit-content; margin-bottom: 0px; padding-bottom: 0px">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>

        <ul class="list-group category_block">
            <c:forEach items="${cList}" var="o">
                <li class="list-group-item text-white ${tag==o.id ? "active":""} " ><a href="Home?action=categories&CValue=${o.id}" style="color:black">${o.categoriesName}</a></li>                 
                </c:forEach>
        </ul>
         <div style="display: block;">
                <a class="page-link" href="paging?indexCate=${cateIndex-1}" aria-label="Previous" style=" visibility: ${cateIndex!=1?"none":"hidden"} ;display: inline-block" >
                <span aria-hidden="true">&laquo;</span>
                <span class="sr-only">Previous</span>
                </a>
             
             
                <a class="page-link" href="paging?indexCate=${cateIndex+1}" aria-label="Next" style=" visibility: ${cateIndex!=totalCate?"none":"hidden"} ;display: inline-block; float: right">
                <span aria-hidden="true">&raquo;</span>
                <span class="sr-only">Next</span>
                </a>
             
        </div>
    </div>
    
    <div class="card bg-light mb-3 col-md-12" style=" display: block; ">
        <div class="card-header bg-success text-white text-uppercase" >Top Products</div>
        <c:forEach items="${sessionScope.topProduct}" var="o">
            <div class="card-body col-md-6" style=" display: inline-block; float: right; " >
                <img class="img-fluid " src="${o.productImg}"  style="display: block; width:80em; height:5em; margin-bottom: 1em" />
                <a href="detail?Dvalue=${o.productName}" >
                    <h5 class="card-title" style="display: block; font-size: small; text-align: center; color: black" >${o.productName}</h5>
                </a>
            </div>
        </c:forEach>
    </div>
</div>