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

                    <c:if test="${sessionScope.success !=null}">
                        <div class="alert alert-success alert-dismissible col-md-12">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <h5><i class="icon fas fa-check"></i> Alert!</h5>
                                ${sessionScope.success}
                        </div>
                    </c:if>

                    <c:remove var="success" scope="session"></c:remove>

                    <!--NỘI DUNG BẢNG LIST DANH SÁCH USER-->
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">Bordered Table</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th style="width: 10px">#</th>
                                        <th>Email</th>
                                        <th>Phone</th>
                                        <th>Address</th>
                                        <th>Permission</th>
                                        <th>Operation</th>
                                    </tr>
                                    </thead>


                                    <tbody>
                                    <c:forEach var="item" items="${list}">
                                        <tr>
                                            <td>${item.getId()}</td>
                                            <td>${item.getEmail()}</td>
                                            <td>
                                                    ${item.getPhone()}
                                            </td>

                                            <td>
                                                    ${item.getAddress()}
                                            </td>
                                            <td>
                                                <span class="badge badge-sucess">
                                                        ${item.getPermissionName()}

                                                </span></td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/user?action=edit&id=${item.getId()}"
                                                   class="btn btn-primary">Edit</a>

                                                <a href="${pageContext.request.contextPath}/user?action=delete&id=${item.getId()}"
                                                   class="btn btn-danger"
                                                   onclick="return confirm('Are you sure you want to delete this ?')">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>


                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
                            <div class="card-footer clearfix">
                                <ul class="pagination pagination-sm m-0 float-right">
                                    <c:forEach var="pageItem" begin="1" end="${totalPage}">
                                        <li class="page-item">
                                            <a class="page-link ${pageItem==activePage ? 'active-page-item':''}"
                                               href="${pageContext.request.contextPath}/user?page=${pageItem}">${pageItem}</a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <!-- /.card -->
                    </div>
                    <!--END NỘI DUNG-->


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