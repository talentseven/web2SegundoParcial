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
	<script type="text/javascript" src='<c:url value="/resources/js/lib/jquery-1.8.2.js" />'></script>
	<title>Insert title here</title>
</head>
<body>
	<h1>Alta libros</h1>
	
	<form:form method="POST" commandName="bookDto" action="/booksmov/app/books/new" enctype="multipart/form-data" >
		<form:label path="isbn">
			<spring:message code="label.books.isbn" /> 
		</form:label>
		<form:input path="isbn" /> <form:errors path="isbn" cssStyle="color: red" /><br/>
<%-- 		<form:label path="title"> --%>
<%-- 			<spring:message code="label.books.title" />  --%>
<%-- 		</form:label> --%>
<%-- 		<form:input path="title" maxlength="200"/> <form:errors path="title" cssStyle="color: red" /><br/> --%>
<%-- 		<form:label path="authors"> --%>
<%-- 			<spring:message code="label.books.authors"/><br/> --%>
<%-- 		</form:label> --%>
<%-- 		<c:forEach items="${book.authors}" var="author" varStatus="counter"> --%>
<!-- 		    <table> -->
<!-- 		        <tr> -->
<!-- 		            <th>First Name</th> -->
<!-- 		            <th>Last Name</th> -->
<!-- 		        </tr> -->
<!-- 		        <tr> -->
<!-- 		            <td> -->
<%-- 		            	<form:input path="author.firstName" value="author.firstName" /> --%>
<!-- 		            </td> -->
<!-- 		            <td> -->
<%-- 		            	<form:input path="author.lastName" value="author.lastName" /> --%>
<!-- 		            </td> -->
<!-- 		        </tr> -->
<!-- 		    </table> -->
<!-- 		    <hr /> -->
<%-- 		</c:forEach> --%>
<!-- 		<label> -->
<%-- 			<spring:message code="label.books.authors.firstname"/> --%>
<!-- 		</label> -->
<%-- 		<form:input path="newAuthor.firstName" maxlength="100"/> <form:errors path="authors" cssStyle="color: red" /><br/> --%>
<!-- 		<label> -->
<%-- 			<spring:message code="label.books.authors.lastname"/> --%>
<!-- 		</label> -->
<%-- 		<form:input path="newAuthor.lastName" maxlength="100"/> <form:errors path="authors" cssStyle="color: red" /><br/> --%>
<%-- 		<form:button><spring:message code="label.add.author.submit"/></form:button> <br /> --%>
		
<%-- 		<form:label path="rating"> --%>
<%-- 			<spring:message code="label.books.rating" />  --%>
<%-- 		</form:label> --%>
<%-- 		<form:radiobutton path="rating" value="1"/>1  --%>
<%-- 		<form:radiobutton path="rating" value="2"/>2  --%>
<%-- 		<form:radiobutton path="rating" value="3"/>3  --%>
<%-- 		<form:radiobutton path="rating" value="4"/>4  --%>
<%-- 		<form:radiobutton path="rating" value="5"/>5 --%>
<%-- 		<form:errors path="rating" cssStyle="color: red" /><br/> --%>
		
<%-- 		<form:label path="description"> --%>
<%-- 			<spring:message code="label.books.description" />  --%>
<%-- 		</form:label> --%>
<%-- 		<form:textarea path="description" rows="5" cols="30" /><br/> --%>
		
<%-- 		<form:label path="borrowable"> --%>
<%-- 			<spring:message code="label.books.borrowable" />  --%>
<%-- 		</form:label>  --%>
<%-- 		<form:checkbox path="borrowable" /><br /> --%>
		
<%-- 		<form:label path="alreadyUsed"> --%>
<%-- 			<spring:message code="label.books.alreadyRead" />  --%>
<%-- 		</form:label>  --%>
<%-- 		<form:checkbox path="alreadyUsed" /><br /> --%>
		
<%-- 		<form:label path="image"> --%>
<%-- 			<spring:message code="label.books.image" />  --%>
<%-- 		</form:label> --%>
<!-- 		<input type="file" name="image" /><br /> -->
		
		<form:button><spring:message code="label.submit"/></form:button>
	</form:form>
	
</body>
</html>