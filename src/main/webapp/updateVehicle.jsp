<%@page import="model.Vehicle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Vehicle</title>
</head>
<body>

<%
Vehicle v = (Vehicle)request.getAttribute("vehicle");
%>

<h2>Update Vehicle</h2>

<form action="updateVehicle" method="post">

    <input type="hidden" name="vehicleId"
           value="<%= v.getVehicleId() %>">

    Vehicle Name:
    <input type="text" name="name"
           value="<%= v.getName() %>">
    <br><br>

    Brand:
    <input type="text" name="brand"
           value="<%= v.getBrand() %>">
    <br><br>

    Type:
    <input type="text" name="type"
           value="<%= v.getType() %>">
    <br><br>

    Price Per Day:
    <input type="number" step="0.01"
           name="pricePerDay"
           value="<%= v.getPricePerDay() %>">
    <br><br>

    Status:
    <input type="text" name="status"
           value="<%= v.getStatus() %>">
    <br><br>

    <input type="submit" value="Update Vehicle">

</form>

</body>
</html>