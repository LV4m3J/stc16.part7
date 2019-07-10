<%--
  Created by IntelliJ IDEA.
  User: cocain
  Date: 2019-07-10
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Birthdate</th>
        <th>E-mail</th>
        <th>PhoneNum</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td scope="row">${person.id}</td>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.birthDate}</td>
            <td>${person.email}</td>
            <td>${person.phoneNum}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="/">Main page</a>
