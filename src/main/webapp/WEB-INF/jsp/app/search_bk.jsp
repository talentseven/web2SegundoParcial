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
<title>Insert title here</title>
</head>
<body>
	<h1>Search</h1>
	
	<spring:message code="label.welcome"/> <br />
	
	<a href='<c:url value="/app/books/new" />'>Alta libros</a>
	<a href='<c:url value="/app/movies/new" />'>Alta peliculas</a>
	
	<c:if test="${not empty books}">
		<h1>Libros</h1>
		<div id="book-filter">
			<form:form action="/booksmov/app/filter/book" modelAttribute="bookDto"  method="GET">
				
			</form:form>
		</div>
		<table border="1">
			<tr>
				<th> <spring:message code="label.books.portada"/> </th>
 				<th> <spring:message code="label.books.title"/> </th>
				<th> <spring:message code="label.books.isbn"/> </th>
				<th> <spring:message code="label.books.rating"/> </th>
				<th> <spring:message code="label.books.borrowable"/> </th>
				<th> <spring:message code="label.books.alreadyRead"/> </th>
				<th> <spring:message code="label.books.authors"/> </th>
			</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td>
					<img height="130" width="100" src='<c:url value="/app/image/book/${book.isbn}" />' />
				</td>
				<td>${book.title}</td>
				<td>${book.isbn}</td>
				<td>${book.rating}</td>
				<td>
					<c:choose>
						<c:when test="${book.borrowable}">
							<spring:message code="label.yes"/>
						</c:when>
						<c:otherwise>
							<spring:message code="label.no"/>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${book.alreadyUsed}">
							<spring:message code="label.yes"/>
						</c:when>
						<c:otherwise>
							<spring:message code="label.no"/>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<ul>
						<c:forEach var="author" items="${book.authorsList}">
							<li> ${author.fullName} </li>	
						</c:forEach>
					</ul>
				</td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	<c:if test="${not empty movies}">
		<h1>Peliculas</h1>
		<div id="movie-filter">
		
		</div>
		<table border="1">
			<tr>
				<th> <spring:message code="label.movies.caratula"/> </th>
				<th> <spring:message code="label.movies.title"/> </th>
				<th> <spring:message code="label.movies.isan"/> </th>
				<th> <spring:message code="label.movies.rating"/> </th>
				<th> <spring:message code="label.movies.borrowable"/> </th>
				<th> <spring:message code="label.movies.alreadyUsed"/> </th>
				<th> <spring:message code="label.movies.actors"/> </th>
				<th> <spring:message code="label.movies.director"/> </th>
				<th> <spring:message code="label.movies.formats"/> </th>
			</tr>
			<c:forEach var="movie" items="${movies}">
				<tr>
					<td>
						<img height="130" width="100" src='<c:url value="/app/image/movie/${movie.isan}" />' />
					</td>
					<td>${movie.title}</td>
					<td>${movie.isan}</td>
					<td>${movie.rating}</td>
					<td>
						<c:choose>
							<c:when test="${movie.borrowable}">
								<spring:message code="label.yes"/>
							</c:when>
							<c:otherwise>
								<spring:message code="label.no"/>
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${movie.alreadyUsed}">
								<spring:message code="label.yes"/>
							</c:when>
							<c:otherwise>
								<spring:message code="label.no"/>
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<ul>
							<c:forEach var="actor" items="${movie.actorList}">
								<li> ${actor.fullName} </li>	
							</c:forEach>
						</ul>
					</td>
					<td>${movie.director.fullName}</td>
					<td>${movie.selectedFormat}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty books and empty movies}">
		<spring:message code="label.no.elements" />
	</c:if>
</body>
</html>