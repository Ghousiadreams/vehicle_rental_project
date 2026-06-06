<%@page import="java.util.List"%>
<%@page import="model.Booking"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking History</title>
</head>
<body>

<%@page import="java.util.List"%>
<%@page import="model.Booking"%>

<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking History</title>
</head>
<body>

<h1>My Bookings</h1>

<a href="home">Back To Home</a>

<hr>

<%
List<Booking> bookingList =
(List<Booking>)request.getAttribute(
        "bookingList"
);

if(bookingList != null){

    for(Booking b : bookingList){
%>

<div>

    <p>
        Booking ID :
        <%= b.getBookingId() %>
    </p>

    <p>
        Vehicle ID :
        <%= b.getVehicleId() %>
    </p>

    <p>
        Start Date :
        <%= b.getStartDate() %>
    </p>

    <p>
        End Date :
        <%= b.getEndDate() %>
    </p>

    <p>
        Total Price :
        ₹ <%= b.getTotalPrice() %>
    </p>

    <p>
        Status :
        <%= b.getStatus() %>
    </p>

    <p>
        Booked On :
        <%= b.getCreatedAt() %>
    </p>

</div>

<hr>

<%
    }
}
%>

</body>
</html>

</body>
</html>