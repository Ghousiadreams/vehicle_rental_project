<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Vehicle</title>
</head>
<body>

<h2>Book Vehicle</h2>

<form action="confirmBooking" method="post">

    Vehicle ID:
    <input type="number" name="vehicleId" required>
    <br><br>

    User ID:
    <input type="number" name="userId" required>
    <br><br>

    Start Date:
    <input type="date" name="startDate" required>
    <br><br>

    End Date:
    <input type="date" name="endDate" required>
    <br><br>

    Total Price:
    <input type="number" step="0.01"
           name="totalPrice" required>
    <br><br>

    <input type="submit" value="Confirm Booking">

</form>

</body>
</html>