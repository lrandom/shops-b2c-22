<%--
  Created by IntelliJ IDEA.
  User: lrandom
  Date: 11/23/21
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<jsp:include page="./../commons/head.jsp"/>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <jsp:include page="./../commons/nav.jsp"/>
    <jsp:include page="./../commons/sidebar.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">Starter Page</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Starter Page</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <c:if test="${sessionScope.success !=null}">
                            <div class="alert alert-success alert-dismissible col-md-12">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                <h5><i class="icon fas fa-check"></i> Alert!</h5>
                                    ${sessionScope.success}
                            </div>
                        </c:if>

                        <c:if test="${sessionScope.error !=null}">
                            <div class="alert alert-danger alert-dismissible col-md-12">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                <h5><i class="icon fas fa-check"></i> Alert!</h5>
                                    ${sessionScope.error}
                            </div>
                        </c:if>

                        <c:remove var="success" scope="session"></c:remove>
                        <c:remove var="error" scope="session"></c:remove>

                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">Form Add Product</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form method="post" enctype="multipart/form-data"
                                  action="${pageContext.request.contextPath}/product-add">
                                <div class="card-body">

                                    <input type="file" name="img_1"/>
                                    <input type="file" name="img_2"/>
                                    <input type="file" name="img_3"/>

                                    <div class="form-group">
                                        <label>Name</label>
                                        <input type="text" name="name" class="form-control" placeholder="Enter name">
                                    </div>

                                    <div class="form-group">
                                        <label>Content</label>
                                        <textarea name="content" placeholder="Content" class="form-control">

                                        </textarea>
                                    </div>

                                    <div class="form-group">
                                        <label>Meta Keyword</label>
                                        <input type="text" name="meta_keyword" class="form-control"
                                               placeholder="Enter Meta Keyword">
                                    </div>

                                    <div class="form-group">
                                        <label>Meta Title</label>
                                        <input type="text" name="meta_title" class="form-control"
                                               placeholder="Enter Meta Title">
                                    </div>

                                    <div class="form-group">
                                        <label>Meta Description</label>
                                        <textarea name="meta_description" class="form-control"
                                                  placeholder="Enter Meta Description"></textarea>
                                    </div>


                                    <div class="form-group">
                                        <label>Price</label>
                                        <input type="number" name="price" class="form-control" placeholder="Price">
                                    </div>

                                    <div class="form-group">
                                        <label>Quantity</label>
                                        <input type="number" name="quantity" class="form-control"
                                               placeholder="Quantity">
                                    </div>

                                    <div class="form-group">
                                        <label>Category</label>
                                        <select name="category_id" class="form-control">
                                            <c:forEach var="category" items="${categories}">
                                                <option value="${category.id}">${category.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label>Material</label>
                                        <c:forEach var="materialItem" items="${material}">
                                            <div>
                                                <input type="checkbox" value="${materialItem.getId()}"
                                                       name="material_id"/>&nbsp;<label
                                                    style="font-weight: normal">${materialItem.getName()}</label>
                                            </div>
                                        </c:forEach>
                                    </div>

                                    <div class="form-group">
                                        <label>Color</label>
                                        <c:forEach var="colorItem" items="${color}">
                                            <div>
                                                <input type="checkbox" value="${colorItem.getId()}"
                                                       name="color_id"/>&nbsp;<label
                                                    style="font-weight: normal;">${colorItem.getName()}</label>
                                            </div>
                                        </c:forEach>
                                    </div>

                                    <div class="form-group">
                                        <label>Size</label>
                                        <c:forEach var="sizeItem" items="${size}">
                                            <div>
                                                <input type="checkbox" value="${sizeItem.getId()}"
                                                       name="size_id"/>&nbsp;<label
                                                    style="font-weight: normal">${sizeItem.getName()}</label>
                                            </div>
                                        </c:forEach>
                                    </div>


                                </div>
                                <!-- /.card-body -->

                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="./../commons/footer.jsp"/>
</div>
<!-- ./wrapper -->

<jsp:include page="./../commons/include_scripts.jsp"/>
</body>
</html>