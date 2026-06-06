<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Vehicle</title>
</head>
<body>

<h2>Add Vehicle</h2>

<form action="addVehicle" method="post">

    Vehicle Name:
    <input type="text" name="name">
    <br><br>

    Type:
    <input type="text" name="type">
    <br><br>

    Brand:
    <input type="text" name="brand">
    <br><br>

    Price Per Day:
    <input type="number"
           step="0.01"
           name="pricePerDay">
    <br><br>

    Available:
    <select name="available">

        <option value="true">
            Available
        </option>

        <option value="false">
            Not Available
        </option>

    </select>
    <br><br>

    Image URL:
    <input type="text" name="imageUrl">
    <br><br>

    <input type="submit" value="Add Vehicle">

</form>

</body>
</html>