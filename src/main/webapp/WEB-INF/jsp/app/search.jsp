<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Búsqueda de libros y películas</title>
</head>
<body>
	<h1>Search</h1>
	
	<spring:message code="label.welcome"/> <br />
	
	<a href='<c:url value="/app/books/new" />'>Alta libros</a>
	<a href='<c:url value="/app/movies/new" />'>Alta peliculas</a>
	
		<h1>Libros y peliculas</h1>
		<div id="filter">
			<span><spring:message code="label.filter.by"/></span>
			<form:form action="/booksmov/app/filter" modelAttribute="filterDto" method="POST">
				<form:label path="userName.value">
					<spring:message code="label.filter.user"/>
				</form:label>
				<form:input path="userName.value" /><br />
				<form:label path="rating.value">
					<spring:message code="label.filter.rating"/>
				</form:label>
				<form:radiobutton path="rating.value" value="1"/>1 
				<form:radiobutton path="rating.value" value="2"/>2 
				<form:radiobutton path="rating.value" value="3"/>3 
				<form:radiobutton path="rating.value" value="4"/>4 
				<form:radiobutton path="rating.value" value="5"/>5<br />
				<form:label path="title.value">
					<spring:message code="label.filter.title"/>
				</form:label>
				<form:input path="title.value" />
				<form:label path="borrowable.value">
					<spring:message code="label.filter.borrowable"/>
				</form:label>
				<form:checkbox path="borrowable.boolValue" />
				<br />
				<form:radiobutton path="type.value" value="all"/> 
				<form:label path="type.value">
					<spring:message code="label.filter.all"/>
				</form:label>
				<form:radiobutton path="type.value" value="books"/> 
				<form:label path="type.value">
					<spring:message code="label.filter.booksOnly"/>
				</form:label>
				<form:radiobutton path="type.value" value="movies"/> 
				<form:label path="type.value">
					<spring:message code="label.filter.moviesOnly"/>
				</form:label><br />
				<form:button><spring:message code="label.filter.submit"/></form:button>
			</form:form>
		</div>
		<table border="1">
			<tr>
				<th> <spring:message code="label.products.cover"/> </th>
 				<th> <spring:message code="label.products.title"/> </th>
				<th> <spring:message code="label.products.rating"/> </th>
				<th> <spring:message code="label.products.borrowable"/> </th>
				<th> <spring:message code="label.products.alreadyUsed"/> </th>
				<th> <spring:message code="label.products.extra.data"/> </th>
				<th> <spring:message code="label.products.action"/> </th>
			</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>
					<c:choose>
						<c:when test="${product.type eq 'movie'}">
							<c:set var="type" value="movie" />
						</c:when>
						<c:otherwise>
							<c:set var="type" value="book" />
						</c:otherwise>
					</c:choose>
					<img height="130" width="100" src='<c:url value="/app/image/${type}/${product.id}" />' />
				</td>
				<td>${product.title}</td>
				<td>${product.rating}</td>
				<td>
					<c:choose>
						<c:when test="${product.borrowable}">
							<spring:message code="label.yes"/>
						</c:when>
						<c:otherwise>
							<spring:message code="label.no"/>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${product.alreadyUsed}">
							<spring:message code="label.yes"/>
						</c:when>
						<c:otherwise>
							<spring:message code="label.no"/>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${type eq 'book'}">
							 <spring:message code="label.books.authors"/> <br />
							 <ul>
						 		<c:forEach var="author" items="${product.authorsList}">
									<li> ${author.fullName} </li>	
								</c:forEach>
							 </ul>
						</c:when>
						<c:otherwise>
							 <spring:message code="label.movies.formats"/> 
							  	 ${product.selectedFormat} <br />
							 <spring:message code="label.movies.director"/> 
								 ${product.director.fullName} <br />
						     <spring:message code="label.movies.actors"/> 
						     <ul>
						 		<c:forEach var="actor" items="${product.actorList}">
									<li> ${actor.fullName} </li>	
								</c:forEach>
							 </ul>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:if test="${product.userId eq sessionScope.user.id}">
						<a href='<c:url value="/app/${type}s/edit/${product.id}" />'>
							<img src='<c:url value="/resources/img/editar.gif" />' />
						</a>
					</c:if>
					<c:if test="${product.userId ne sessionScope.user.id and product.borrowable eq true}">
						<a href='<c:url value="/app/loan/${product.id}?type=${type}" />'>
							<img src='<c:url value="/resources/img/solicitud_prestamo.png" />' />
						</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>