<%@ page import="ir.maktabsharif.model.User" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 9/19/2026
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body style="background-color:dimgrey">

<%
    User user = (User) request.getAttribute("user");
    Integer id = user.getId();
    String name = user.getName();
    String username = user.getUsername();
    String password = user.getPassword();
    String phoneNumber = user.getPhoneNumber();
%>

<h2>id = ${id}</h2>
<h2>name = ${name}</h2>
<h2>username = ${username}</h2>
<h2>password = ${password}</h2>
<h2>phoneNumber = ${phoneNumber}</h2>

<a href="update">update</a><br>
<a href="index.jsp">HOME</a><br>

</body>
</html>
