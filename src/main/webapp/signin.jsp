<%--
  Created by IntelliJ IDEA.
  User: cocain
  Date: 2019-07-10
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Аутентификация</h1>
<form method="post" action="${pageContext.request.contextPath}/signin" autocomplete="off">
    <div class="form-group">
        <label for="login">Name</label>
        <input name="login" type="text" class="form-control" id="login">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input name="password" type="password" class="form-control" id="password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
