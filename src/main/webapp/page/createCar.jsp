<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 9/20/2026
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create car</title>
</head>
<body style="background-color:dimgrey">

<center>
    <form method="POST" action="createCar">


        <label>car model
            <input type="text" name="carmodel" placeholder="carmodel">
        </label>


        <label>car year
        <input type="text" name="caryear" placeholder="caryear">
        </label>

        <label>car color
        <input type="text" name="carcolor" placeholder="carcolor">
        </label>

        <label>car engin
        <input type="number" name="carengine" placeholder="carengine">
        </label>

        <button type="submit">submit</button>

    </form>
</center>

<a href="index.jsp">HOME</a><br>

</body>
</html>
