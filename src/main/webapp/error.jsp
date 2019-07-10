<%--
  Created by IntelliJ IDEA.
  User: cocain
  Date: 2019-07-10
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<myTags:template>
    <jsp:attribute name="header">
        <h1>Error default page</h1>
        <h2>Details</h2>
    </jsp:attribute>
    <jsp:body>
        <c:if test="${statusCode != 500}">
            <strong>Status Code</strong>: ${statusCode}<br/>
            <strong>Requested URI</strong>: ${requestUri}
        </c:if>
        <c:if test="${statusCode == 500}">
            <ul>
                <li>Servlet Name: ${servletName} </li>
                <li>Exception Name: ${throwableName} </li>
                <li>Requested URI: ${requestUri} </li>
                <li>Exception Message: ${throwableMessage} </li>
            </ul>
            <br><br>
            <a href="/">Main page</a>
        </c:if>
    </jsp:body>
</myTags:template>
