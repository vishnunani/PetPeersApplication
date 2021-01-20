<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MY PETS</title>
<link href="<c:url value="/resources/css/MyPet.css" />"
	rel="stylesheet">
</head>
<body>
	<nav>
		<ul>
			<li><a href="Profile">HOME</a></li>
			<li><a href="AddPetPage">ADD_PET</a></li>
			<li><a class="active" href="MyPets">MY_PETS</a></li>
			<li style="float: right;"><a href="Logout">LOGOUT</a></li>
		</ul>
	</nav>
	<table border="1">
		<thead>
			<tr>
				<th>Pet ID</th>
				<th>Pet Name</th>
				<th>Pet Place</th>
				<th>Pet Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pet" items="${pets}">
				<tr>
					<td><c:out value="${pet.petId}" /></td>
					<td><c:out value="${pet.petName}" /></td>
					<td><c:out value="${pet.petPlace}" /></td>
					<td><c:out value="${pet.petAge}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>