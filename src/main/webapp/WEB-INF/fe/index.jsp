<%--
  Created by IntelliJ IDEA.
  User: lrandom
  Date: 12/2/21
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>
        Shoe Pro vjp Luxury
    </title>
    <jsp:include page="./commons/head.jsp"/>
</head>
<body>
<div class="container">

    <jsp:include page="./commons/nav.jsp"/>

    <div style="position:relative;margin-top:10px" class="col-md-12">
        <h4>New Arial</h4>
        <div class="row">


            <c:forEach var="item" items="${latestProducts}">
                <div class="col">
                    <div class="card" style="width: 18rem;margin-top:10px">
                        <img src="${pageContext.request.contextPath}/image?path=${item.getImagePath()}"
                             class="card-img-top" style="height: 18rem; object-fit: cover; width:100%"
                             alt="${item.getName()}">
                        <div class="card-body">
                            <h5 class="card-title">${item.getName()}</h5>
                            <p style="font-weight: bold;font-size: 1.5em"><ftm:formatNumber type="currency"
                                                                                            value="${item.getPrice()}"/></p>
                            <a href="#" class="btn btn-primary">Add To Cart</a>
                        </div>
                    </div>
                </div>
            </c:forEach>


        </div>

    </div>

    <div style="position: relative;margin-top:10px; margin-bottom: 20px" class="col-md-12">
        <h4>Top Shoes</h4>
        <div class="row">
            <c:forEach var="item" items="${topProducts}">
                <div class="col">
                    <div class="card" style="width: 18rem;">
                        <img src="${pageContext.request.contextPath}/image?path=${item.getImagePath()}"
                             class="card-img-top" style="height: 18rem;width: 100%; object-fit: cover"
                             alt="${item.getName()}">
                        <div class="card-body">
                            <h5 class="card-title">${item.getName()}</h5>
                            <p style="font-weight: bold;font-size: 1.5em"><ftm:formatNumber type="currency"
                                                                                            value="${item.getPrice()}"/></p>
                            <a href="#" class="btn btn-primary">Add To Cart</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>


    <jsp:include page="./commons/footer.jsp"/>
</div>



</body>
</html>
