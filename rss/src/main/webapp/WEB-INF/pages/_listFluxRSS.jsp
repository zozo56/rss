<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link type="text/css" rel="stylesheet" href="rss/WebContent/css/style.css" />
<title>FLUX RSS</title>
</head>
<body>

<h1>Flux rss : </h1>

<h3>${afriqueTitle}</h3>

<c:import url="header.jsp" />

<c:forEach var="feed" items="${allFeeds}">
	<table border="1px" cellpadding="0" cellspacing="0" width="80%">
		
		<caption>${feed.getTitle()} <br /> ${feed.getDescription()}</caption>
		<c:forEach var="feedMessage" items="${feed.getMessages()}">
			<tr>
				<td width="10%">Titre</td>
				<td>${feedMessage.value.getTitle()}</td>
			</tr>
			<tr>
				<td width="10%">Description</td>
				<td>${feedMessage.value.getDescription()}</td>
			</tr>
			<c:if test="${!empty feedMessage.value.getAuthor()}">
				<tr>
					<td>Auteur</td>
					<td>${feedMessage.value.getAuthor()}</td>
				</tr>
			</c:if>
			<tr>
				<td width="10%">Lien</td>
				<td><a href="${feedMessage.value.getLink()}" target="_blank">${feedMessage.value.getLink()}</a></td>
			</tr>
			<tr class="clear"></tr>
		</c:forEach>
	</table>
	<br /><br />
</c:forEach>


<!-- 
<table border="1px" cellpadding="0" cellspacing="0" width="100%">
	<c:forEach var="afrique" items="${afriqueMap}">
    
		<tr>
			<td width="10%">Titre</td>
			<td>${afrique.value.getTitle()}</td>
		</tr>
		<tr>
			<td width="10%">Description</td>
			<td>${afrique.value.getDescription()}</td>
		</tr>
		<c:if test="${!empty afrique.value.getAuthor()}">
			<tr>
				<td>Auteur</td>
				<td>${afrique.value.getAuthor()}</td>
			</tr>
		</c:if>
		<tr>
			<td width="10%">Lien</td>
			<td><a href="${afrique.value.getLink()}" target="_blank">${afrique.value.getLink()}</a></td>
		</tr>
	<br/><br/>
	</c:forEach>
</table>
 -->
 
<p><a href="${pageContext.request.contextPath}/index.html">Page d'accueil</a></p>

</body>
</html>