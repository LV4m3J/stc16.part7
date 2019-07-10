<%--
  Created by IntelliJ IDEA.
  User: cocain
  Date: 2019-07-10
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<myTags:template>
    <jsp:body>
        <ul>
            <li><a href="${pageContext.request.contextPath}/person/list">List students</a></li>
            <li><a href="${pageContext.request.contextPath}/person">New student</a></li>
        </ul>
    </jsp:body>
</myTags:template>
