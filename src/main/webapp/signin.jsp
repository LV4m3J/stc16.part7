<%--
  Created by IntelliJ IDEA.
  User: cocain
  Date: 2019-07-02
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Аутентификация</title>
    <meta charset="UTF-8"/>
</head>
<body>
    <h1>Аутентификация</h1>
    <form method="post" action="signin">
        <input type="text" required name="login" placeholder="login"><br/>
        <input type="password" required name="password" placeholder="password"><br/>
        <input type="submit" value="Enter"/>
    </form>
</body>
</html>
