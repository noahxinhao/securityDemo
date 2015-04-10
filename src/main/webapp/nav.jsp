<%--
  Created by IntelliJ IDEA.
  User: noahli
  Date: 2015/4/9
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">OA</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#about">common</a></li>
        <li><a href="#contact">admin</a></li>

      </ul>
      <ul class="nav navbar-nav navbar-right">
          <li><a><sec:authentication property="name"/></a></li>
          <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
            <li><a href="/j_spring_security_logout">退出登陆</a></li>
          </sec:authorize>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>
