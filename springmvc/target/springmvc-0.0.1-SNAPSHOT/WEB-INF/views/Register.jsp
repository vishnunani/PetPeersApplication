<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTER</title>
<link href="<c:url value="/resources/css/Register.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/Register.js" />"></script>
</head>
<body>
	<h1>REGISTRATION FORM</h1>
	<p id="message">${message}</p>
	<div id="form">
	<form:form action="Register" method="post" modelAttribute="user">
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
				<td><form:label path="repeatPassword">Enter Repeat password : </form:label></td>
				<td><form:password path="repeatPassword" id="password" /> <br>
					<form:errors path="repeatPassword" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
	</div>
	<%-- <form name="regform" action="./Register" method="get" onsubmit="return validate()">
		<div class="formdivision">
			<table>
				<tr>
					<td><p>ENTER YOUR USER NAME</p></td>
					<td><input type="text" name="userName" required="required"></td>
				</tr>
				<tr>
					<td><p>ENTER PASSWORD</p></td>
					<td><input type="password" name="password" required="required"></td>
				</tr>
				<tr>
					<td><p>ENTER REPEAT PASSWORD</p></td>
					<td><input type="password" name="repeatPassword" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="REGISTER"></td>
				</tr>
			</table>
		</div>

	</form> --%>

</body>
</html>