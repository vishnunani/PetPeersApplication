<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROFILE</title>
<link href="<c:url value="/resources/css/Profile.css" />" rel="stylesheet">
</head>
<body>
	<nav>
		<ul>
			<li><a class="active" href="Profile">HOME</a></li>
			<li><a href="AddPetPage">ADD_PET</a></li>
			<li><a href="MyPets">MY_PETS</a></li>
			<li style="float: right;"><a href="Logout">LOGOUT</a></li>
		</ul>
	</nav>
	<h1>WELCOME ${validUser.userName}</h1>
	<p id="message">${message}</p>
	<table border="1">
		<thead>
			<tr>
				<th>Pet ID</th>
				<th>Pet Name</th>
				<th>Pet Place</th>
				<th>Pet Age</th>
				<th>STATUS</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pet" items="${pets}">
				<tr>
					<td><c:out value="${pet.petId}" /></td>
					<td><c:out value="${pet.petName}" /></td>
					<td><c:out value="${pet.petPlace}" /></td>
					<td><c:out value="${pet.petAge}" /></td>
					<td><c:choose>
							<c:when test="${pet.userId != null}">  
       							SOLD
    						</c:when>
							<c:otherwise>
								<a href="<c:url value='/Buy/${pet.petId}' />">BUY</a>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>