<%@ page import="ru.inno.stc14.entity.Person" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Студенты</title>
    <meta charset="UTF-8"/>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Birthdate</th>
        <th>E-mail</th>
        <th>PhoneNum</th>
    </tr>
    <% List<Person> list = (List<Person>) request.getAttribute("persons");
        for (Person person : list) { %>
    <tr>
        <td><%=person.getId()%></td>
        <td><%=person.getName()%></td>
        <td><%=person.getBirthDate()%></td>
        <td><%=person.getEmail()%></td>
        <td><%=person.getPhoneNum()%></td>
    </tr>
    <br>
    <% } %>
</table>
<br>
<a href="/">Main page</a>
</body>
</html>
