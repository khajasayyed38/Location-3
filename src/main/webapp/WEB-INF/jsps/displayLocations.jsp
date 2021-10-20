<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Locations</title>
</head>
<body>
	<h2>Display All Location</h2>
	<a href="showlocation">Click to add location</a>
	<table border='1'>
	<tr>
	<th>Id</th>
	<th>Code</th>
	<th>Name</th>
	<th>Type</th>
	<th>Delete</th>
	<th>update</th>
	</tr>
	
	<c:forEach items="${locations}" var="location">
	<tr>
		<td>${location.id}</td>
		<td>${location.code}</td>
		<td>${location.name}</td>
		<td>${location.type}</td>
		<td><a href="deleteReg?id=${location.id}">delete</a></td>
		<td><a href="updateReg?id=${location.id}">update</a></td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>