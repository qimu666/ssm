<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

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
    <title>添加用户</title>
</head>
<body>
<div class="container">
    <div class="row" style="margin: 150px 200px">
        <form action="${pageContext.request.contextPath}/doUserAddAndUpdate" method="get" class="form-horizontal">
            <input type="hidden" name="empId" value="${user.empId}">
            <br>
            <div class="form-group">
                <div class="col-sm-6">
                    <label>用户名</label>
                    <input type="text" name="empName" value="${user.empName}" class=" form-control" placeholder="用户名">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-6">
                    <label for="nianl">年龄</label>
                    <input type="text" name="age" class="form-control" value="${user.age}" id="nianl" placeholder="年龄">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-6">
                    <label>性别</label>
                    <input type="text" name="gender" value="${user.gender}" class="form-control" placeholder="性别">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-6">
                    <label>Email address</label>
                    <input type="email" name="email" value="${user.email}" class="form-control" placeholder="Email">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-6">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" name="password" value="${user.password}" class="form-control"
                           id="exampleInputPassword1"
                           placeholder="Password">
                </div>
            </div>
            <div class="col-sm-6" style="margin-left: -5px">
                <button type="submit" class="btn btn-lg btn-primary btn-block"
                        >确认</button>
                <span style="color: red" class="lead">${errorAdd}</span>
            </div>
        </form>
    </div>
</div>
</body>
</html>
