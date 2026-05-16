<%@page import="java.util.List"%>
<%@page import="model.Vehicle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>

<h1>Available Vehicles</h1>

<a href="bookingHistory">My Bookings</a>
<a href="logout">Logout</a>

<hr>

<%
List<Vehicle> vehicleList =
(List<Vehicle>)request.getAttribute("vehicleList");

if(vehicleList != null){

    for(Vehicle v : vehicleList){
%>

<div>

    <h2><%= v.getName() %></h2>

    <p>
        Brand :
        <%= v.getBrand() %>
    </p>

    <p>
        Type :
        <%= v.getType() %>
    </p>

    <p>
        Price Per Day :
        ₹ <%= v.getPricePerDay() %>
    </p>

    <p>

        Availability :

        <%
        if(v.isAvailable()){
        %>

            Available

        <%
        } else {
        %>

            Not Available

        <%
        }
        %>

    </p>

    <p>
        Image URL :
        <%= v.getImageUrl() %>
    </p>

    <p>
        Added On :
        <%= v.getCreatedAt() %>
    </p>

    <form action="bookVehicle" method="post">

        <input type="hidden"
               name="vehicleId"
               value="<%= v.getVehicleId() %>">

        <input type="submit"
               value="Book Now">

    </form>

</div>

<hr>

<%
    }
}
%>

</body>
</html>