<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<title>FLUX RSS - ${feed.getTitle()}</title>

</head>
<body>
	<div id="wrapper">
		<header id="entete">
           	<%@ include file="header.jsp" %>
		</header>
		
		<section id="contenu">
			<div id="menuprincipal">
				<%@ include file="menu.jsp" %>
			</div>
			
			<div id="cContent">
				<div id="search">
					<input type="text" name="search" id="search"/>
					<input type="submit" value="Rechercher" id="btSearch" class="btSearch" />
				</div>
				<div id="content">
					
						<table border="1px" cellpadding="0" cellspacing="0" >
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
										
				</div>
			</div>
		</section>
		
		<footer id="pied">
           	<%@ include file="pied.jsp" %>
		</footer>
	</div>
</body>
</html>