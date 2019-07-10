<%--
  Created by IntelliJ IDEA.
  User: cocain
  Date: 2019-07-10
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="person" class="ru.inno.stc14.entity.Person" />
    <c:set target="${person}" property="name" value="Anonim" />
    <c:set target="${person}" property="birthDate" value="01.01.1900" />
    <c:set target="${person}" property="email" value="email@email.com" />
    <c:set target="${person}" property="phoneNum" value="89877891717" />

<h1>Adding a new student</h1>
<form method="post" action="${pageContext.request.contextPath}/person" autocomplete="off">
    <div class="form-group">
        <label for="name">Name</label>
        <input name="name" type="text" class="form-control" id="name" value="<jsp:getProperty name="person" property="name" />">
    </div>
    <div class="form-group">
        <label for="birth">Password</label>
        <input name="birth" type="text" class="form-control" id="birth" value="<jsp:getProperty name="person" property="birthDate" />">
    </div>
    <div class="form-group">
        <label for="email">email</label>
        <input name="email" type="text" class="form-control" id="email" value="<jsp:getProperty name="person" property="email" />">
    </div>
    <div class="form-group">
        <label for="phoneNum">phoneNum</label>
        <input name="phoneNum" type="text" class="form-control" id="phoneNum" value="<jsp:getProperty name="person" property="phoneNum" />">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>