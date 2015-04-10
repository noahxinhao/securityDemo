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
    <jsp:include page="../head_meta.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../nav.jsp"/>
<div class="container">
    <div class="row">
        这个页面只有管理员课件，普通用户将会被拒绝访问该页面
        <a href="/rs/main/common">进入普通用户主页</a>
    </div>
</div>
</div>
<!-- /container -->
<jsp:include page="../footer.jsp"/>
</body>
</html>
