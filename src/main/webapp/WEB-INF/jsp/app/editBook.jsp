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
	<script src='<c:url value="/resources/js/lib/jquery-1.8.2.js" />'></script>
	<script src='<c:url value="/resources/js/lib/json2.js" />'></script>
	<title>Insert title here</title>
</head>
<body>
	<h1>Editar libro</h1>
	
	<form:form method="POST" modelAttribute="bookDto" action="/booksmov/app/books/edit" enctype="multipart/form-data" >
		<img height="130" width="100" src='<c:url value="/app/image/book/${bookDto.isbn}" />' />
		<form:label path="isbn">
			<spring:message code="label.books.isbn" /> 
		</form:label>
		<form:input path="isbn" readonly="true" /> <form:errors path="isbn" cssStyle="color: red" /><br/>
		<form:label path="title">
			<spring:message code="label.books.title" /> 
		</form:label>
		<form:input path="title" maxlength="200"/> <form:errors path="title" cssStyle="color: red" /><br/><br/>
		<form:label path="authors">
			<spring:message code="label.books.authors"/>
			<spring:message code="label.books.authors.example"/>
		</form:label>
		<form:input path="authors" maxlength="100"/> <form:errors path="authors" cssStyle="color: red" /><br/>
		<form:label path="rating">
			<spring:message code="label.books.rating" /> 
		</form:label>
		<form:radiobutton path="rating" value="1"/>1 
		<form:radiobutton path="rating" value="2"/>2 
		<form:radiobutton path="rating" value="3"/>3 
		<form:radiobutton path="rating" value="4"/>4 
		<form:radiobutton path="rating" value="5"/>5
		<form:errors path="rating" cssStyle="color: red" /><br/>
		
		<form:label path="description">
			<spring:message code="label.books.description" /> 
		</form:label>
		<form:textarea path="description" rows="5" cols="30" /><br/>
		
		<form:label path="borrowable">
			<spring:message code="label.books.borrowable" /> 
		</form:label> 
		<form:checkbox path="borrowable" /><br />
		
		<form:label path="alreadyUsed">
			<spring:message code="label.books.alreadyRead" /> 
		</form:label> 
		<form:checkbox path="alreadyUsed" /><br />
		
		<form:label path="image">
			<spring:message code="label.books.image" /> 
		</form:label>
		<form:input type="file" path="image" />
		<form:errors path="image" cssStyle="color: red" /><br/>
		<form:hidden path="id" />
		<form:button><spring:message code="label.products.modify"/></form:button>
	</form:form>
	
	<c:if test="${bookDto.success}">
		<h2>El libro se ha actualizado exitosamente!</h2>
	</c:if>
	
	<script src="<c:url value="/resources/js/authors.js" />"></script>
	<script>
		//author.init();
	</script>
</body>
</html>