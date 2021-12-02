<%--
  Created by IntelliJ IDEA.
  User: lrandom
  Date: 12/2/21
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <div>
        <a class="nav-item" href="/">Home</a>
        <a class="nav-item" href="${pageContext.request.contextPath}/category">Category</a>
    </div>

    <div>
        <form action="${pageContext.request.contextPath}/search" style="margin-top:20px;">
            <input type="text" name="keyword"/>
        </form>
    </div>

    <div>
        <a class="nav-item" href="${pageContext.request.contextPath}/login">Login</a>
        <a class="nav-item" href="${pageContext.request.contextPath}/register">Register</a>
    </div>

</nav>

<style>
    nav {
        padding: 10px;
        width: 100%;
        display: flex;
        align-items: center;
        justify-content: space-between;
        height: 60px;
        background-color: #cdcdcd;
        font-size: 20px
    }

    nav .nav-item {
        text-decoration: none;
        color: #000b16;
    }
</style>