<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 9/19/2026
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="./login" method="post">

    <label>Username:
    <input type="text" name="username" placeholder=" Enter Username">
    </label>

    <label>Password:
        <input type="password" name="password" placeholder=" Enter Password">
    </label><br>

    <label>Name:
        <input type="text" name="name" placeholder=" Enter name">
    </label>

    <label>Phone:
        <input type="text" name="phoneNumber" placeholder=" Enter phoneNumber">
    </label>

    <button type="submit">Login</button>

</form>

<a href="index.jsp">HOME</a><br>

</body>
</html>
