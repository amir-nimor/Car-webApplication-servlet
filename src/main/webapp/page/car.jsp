<%@ page import="java.util.List" %>
<%@ page import="ir.maktabsharif.model.Car" %><%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 9/20/2026
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>car</title>
</head>
<body style="background-color:dimgrey">

<center>
    <ul>

            <%
    List<Car> cars = (List<Car>) request.getAttribute("car");


    for (Car c : cars) {
%>
        <li style="background-color: saddlebrown "><%= c%>></li>
            <%
    }


%>
</center>

</ul>


</body>
</html>
