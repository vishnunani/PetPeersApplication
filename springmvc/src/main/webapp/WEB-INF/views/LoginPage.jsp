<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/Login.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/Login.js" />"></script>
<title>LOGIN</title>
</head>
<body>
	<h1>LOGIN FORM</h1>
	<p id="message">${message}</p>
	<div id="form">
	<form:form action="LoginValidate" method="post" modelAttribute="user"
		onsubmit="return validate()">
		<table>
			<tr>
				<td><form:label path="userName">Enter user name: </form:label>
				</td>
				<td><form:input path="userName" id="userName" /> <br> <form:errors
						path="userName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="password">Enter password: </form:label></td>
				<td><form:password path="password" id="password" /> <br>
					<form:errors path="password" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="LOGIN"></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>