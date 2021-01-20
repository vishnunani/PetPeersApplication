<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD PETS</title>
<link href="<c:url value="/resources/css/AddPet.css" />" rel="stylesheet">
</head>
<body>
<nav>
		<ul>
			<li><a href="Profile">HOME</a></li>
			<li><a class="active" href="AddPetPage">ADD_PET</a></li>
			<li><a href="MyPets">MY_PETS</a></li>
			<li style="float: right;"><a href="Logout">LOGOUT</a></li>
		</ul>
	</nav>
	<div id="form">
	<form:form action="AddPet" method="post" modelAttribute="pet">
		<table>
			<tr>
				<td><form:label path="petName">Enter pet name: </form:label>
				</td>
				<td><form:input path="petName" id="petName" /> <br> <form:errors
						path="petName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="petAge">Enter pet Age: </form:label></td>
				<td><form:input path="petAge" id="petAge" /> <br>
					<%-- <form:errors path="petAge" cssClass="error"></form:errors></td> --%>
			</tr>
			<tr>
				<td><form:label path="petPlace">Enter pet place : </form:label></td>
				<td><form:input path="petPlace" id="petPlace" /> <br>
					<form:errors path="petPlace" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add"></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>