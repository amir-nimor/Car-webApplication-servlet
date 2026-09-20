<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 9/19/2026
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login successful</title>
</head>
<body style="background-color:dimgrey">
<%
String name =(String) request.getAttribute("name");
String username =(String) request.getAttribute("username");
Integer id =(Integer) request.getAttribute("id");
%>
<center>
    <h1 style="background-color: cadetblue">Login Successful</h1>
    <h1 style="background-color: cadetblue">id  = ${id}    name = ${name}    usename = ${username} </h1>
</center>


<a href="index.jsp">HOME</a><br>


</body>
</html>
