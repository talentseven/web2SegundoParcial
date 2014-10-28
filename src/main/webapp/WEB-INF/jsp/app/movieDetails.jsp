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
	<ul>
		<li>
		 <img height="130" width="100" src='<c:url value="/app/image/movie/${movie.isan}" />' />
		</li>
		<li>
		 <spring:message code="label.movies.title"/>${movie.title}
		</li>
		<li>
		 <spring:message code="label.movies.isan"/> 
		 ${movie.isan}
		</li>
		<li>
			<spring:message code="label.movies.rating"/> 
			${movie.rating}
		</li>
		<li>
			<spring:message code="label.movies.formats"/> 
			${movie.selectedFormat}
		</li>
		<li>
			<spring:message code="label.movies.director"/> 
			${movie.director.fullName}
		</li>
		<li>
		 <spring:message code="label.movies.actors"/> 
		 <ol>
	 		<c:forEach var="actor" items="${movie.actorList}">
				<li> ${actor.fullName} </li>	
			</c:forEach>
		 </ol>
		</li>
	</ul>
</body>
</html>