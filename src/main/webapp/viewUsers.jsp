<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users</title>
</head>
<body>

<h2>All Users</h2>

<%
List<User> userList =
(List<User>)request.getAttribute("userList");

if(userList != null){

    for(User u : userList){
%>

<div>

    <p>User ID : <%= u.getUserId() %></p>

    <p>Name : <%= u.getName() %></p>

    <p>Email : <%= u.getEmail() %></p>

    <p>Phone : <%= u.getPhone() %></p>

    <p>Role : <%= u.getRole() %></p>

</div>

<hr>

<%
    }
}
%>

</body>
</html>