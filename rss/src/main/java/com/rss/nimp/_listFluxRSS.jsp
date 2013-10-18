<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>FLUX RSS</title>
</head>
<body>

<h1>Flux rss : </h1>

<h3>${categorie}</h3>

<c:forEach var="fluxRSS" items="${fluxRSS}">
	<table border="1px" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td width="10%">Titre</td>
			<td>${fluxRSS.getTitle()}</td>
		</tr>
		<tr>
			<td width="10%">Description</td>
			<td>${fluxRSS.getDescription().getValue()}</td>
		</tr>
		<c:if test="${!empty fluxRSS.getAuthor()}">
			<tr>
				<td>Auteur</td>
				<td>${fluxRSS.getAuthor()}</td>
			</tr>
		</c:if>
		<tr>
			<td width="10%">Date publication</td>
			<td>${fluxRSS.getPublishedDate()}</td>
		</tr>
		<tr>
			<td width="10%">Lien</td>
			<td><a href="${fluxRSS.getLink()}" target="_blank">${fluxRSS.getLink()}</a></td>
		</tr>
	</table>
	<br /> <br />
</c:forEach>

<p><a href="${pageContext.request.contextPath}/index.html">Page d'accueil</a></p>

</body>
</html>