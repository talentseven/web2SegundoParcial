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
<title>Detalles</title>
</head>
<body>
		<ul>
			<li>
			 <img height="130" width="100" src='<c:url value="/app/image/book/${book.isbn}" />' />
			</li>
			<li>
			 <spring:message code="label.books.title"/>${book.title}
			</li>
			<li>
			 <spring:message code="label.books.isbn"/> 
			 ${book.isbn}
			</li>
			<li>
				<spring:message code="label.books.rating"/> 
				${book.rating}
			</li>
			<li>
			 <spring:message code="label.books.authors"/> 
			 <ol>
		 		<c:forEach var="author" items="${book.authorsList}">
					<li> ${author.fullName} </li>	
				</c:forEach>
			 </ol>
			</li>
		</ul>
</body>
</html>