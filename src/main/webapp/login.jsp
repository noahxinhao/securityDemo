<%--
  Created by IntelliJ IDEA.
  User: noahli
  Date: 2015/4/9
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <jsp:include page="head_meta.jsp"></jsp:include>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-4 col-xs-offset-4" style="padding-top: 150px">
            <form action="/j_spring_security_check" method="post">
                <div class="form-group">
                    <label for="name">Email address</label>
                    <input type="text" class="form-control" name="j_username" id="name" placeholder="请输入用户名">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="j_password" value="" id="password" placeholder="Password">
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="_spring_security_remember_me"> Check me out
                    </label>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</div>
<!-- /container -->
<jsp:include page="footer.jsp"/>
</body>
</html>