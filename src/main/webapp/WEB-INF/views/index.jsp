<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home de la aplicacion</title>
	</head>
	<body>
		<h1>Bienvenido a la biblioteca de libros y peliculas</h1>
		<c:choose>
			<c:when test="${empty sessionScope.user}">
				<a href="/booksmov/login">Logueate</a>
			</c:when>
			<c:otherwise>
				<a href="/booksmov/app/search">Ingresar</a>
			</c:otherwise>
		</c:choose>
	</body>
</html>