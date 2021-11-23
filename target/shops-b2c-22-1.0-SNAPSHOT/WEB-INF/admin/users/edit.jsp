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

                    <c:if test="${sessionScope.error !=null}">
                        <div class="alert alert-danger alert-dismissible col-md-12">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <h5><i class="icon fas fa-check"></i> Alert!</h5>
                                ${sessionScope.error}
                        </div>
                    </c:if>

                    <c:remove var="success" scope="session"></c:remove>
                    <c:remove var="error" scope="session"></c:remove>
                    <div class="col-md-12">
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">Form Edit User</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form method="post" action="${pageContext.request.contextPath}/user-edit">
                                <div class="card-body">
                                    <input type="hidden" name="id" value="${obj.getId()}"/>
                                    <div class="form-group">
                                        <label>Email address</label>
                                        <input type="email" name="email" class="form-control" value="${obj.getEmail()}"
                                               placeholder="Enter email">
                                    </div>

                                    <div class="form-group">
                                        <label>Phone</label>
                                        <input type="phone" name="phone" class="form-control" value="${obj.getPhone()}"
                                               placeholder="Phone">
                                    </div>


                                    <div class="form-group">
                                        <label>Address</label>
                                        <input type="text" name="address" class="form-control"
                                               value="${obj.getAddress()}" placeholder="Address">
                                    </div>

                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" class="form-control" name="password"
                                               placeholder="Password">
                                    </div>

                                    <div class="form-group">
                                        <label>Permission</label>
                                        <select name="permission" class="form-control">
                                            <option value="1" ${obj.getPermission()==1 ? 'selected="selected"':''}>
                                                Admin
                                            </option>
                                            <option value="2" ${obj.getPermission()==2 ? 'selected="selected"':''}>
                                                Staff
                                            </option>
                                            <option value="3" ${obj.getPermission()==3 ? 'selected="selected"':''}>
                                                User
                                            </option>
                                        </select>
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