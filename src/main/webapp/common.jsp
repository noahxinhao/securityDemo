<%--
  Created by IntelliJ IDEA.
  User: noahli
  Date: 2015/4/9
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <jsp:include page="head_meta.jsp"></jsp:include>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
  <div class="row">
    <div class="col-xs-4">
      <sec:authorize access="hasRole('ROLE_USER')">
          common页面普通用户是可见的
      </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            common页面管理员也是可见的，但是这部分数据只有管理员能看见。
        </sec:authorize>
    </div>
    <a href="/rs/main/admin">管理员主页</a>
  </div>
</div>
</div>
<!-- /container -->
<jsp:include page="footer.jsp"/>
</body>
</html>
