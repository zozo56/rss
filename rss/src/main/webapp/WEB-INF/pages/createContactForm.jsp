<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add team page</title>
</head>
<body>
<h1>Création contact</h1>
<form:form method="POST" commandName="contact" action="${pageContext.request.contextPath}/add.html">
<table>
<tbody>
	<tr>
		<td>Nom:</td>
		<td><form:input path="lastname" /></td>
	</tr>
	<tr>
		<td>Prenom:</td>
		<td><form:input path="firstname" /></td>
	</tr>
	<tr>
		<td>E-mail:</td>
		<td><form:input path="email" /></td>
	</tr>
	<tr>
		<td>Téléphone:</td>
		<td><form:input path="telephone" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="Créer le contact" /></td>
		<td><input type="reset" value="Remettre à zéro" /></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>