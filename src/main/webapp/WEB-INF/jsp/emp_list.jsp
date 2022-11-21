<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
            crossorigin="anonymous"></script>
    <title>用户列表</title>
</head>
<body>
<div class="container" style="margin-top: 50px">
    <form class="form-inline" action="${pageContext.request.contextPath}/empList" method="post">
        <div class="form-group">
            <input type="text" name="empName" class="form-control" placeholder="User name">
        </div>
        <button type="submit" class="btn btn-primary">查询用户</button>
    </form>

    <form class="form-inline" action="${pageContext.request.contextPath}/delete" method="get">
        <a class="btn btn-success" href="${pageContext.request.contextPath}/userAdd" role="button">添加用户</a>
        <button type="submit" class="btn btn-danger">批量删除</button>

        <table class="table table-hover">
            <tr>
                <th>选择</th>
                <th>id</th>
                <th>name</th>
                <th>age</th>
                <th>gender</th>
                <th>email</th>
                <th>操作</th>
            </tr>
            <c:forEach var="u" items="${list}">
                <tr>
                    <td><input type="checkbox" name="empId" value="${u.empId}"></td>
                    <td>${u.empId }</td>
                    <td>${u.empName }</td>
                    <td>${u.age }</td>
                    <td>${u.gender }</td>
                    <td>${u.email}</td>
                    <td>
                        <a class="btn btn-warning" href="${pageContext.request.contextPath}/userUpdate?empId=${u.empId}"
                           role="button">修改</a>
                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/delete?empId=${u.empId}"
                           role="button">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
