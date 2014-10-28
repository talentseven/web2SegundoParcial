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
	
	<ul>
	<h1>size de books: ${fn:length(bookDto.authors)}</h1>
	<c:forEach var="author" items="${bookDto.authors}">
		<li>${author.fullName}</li>
	</c:forEach>
	</ul>
</body>
</html>