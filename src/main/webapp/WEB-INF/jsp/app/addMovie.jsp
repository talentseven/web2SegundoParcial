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
	<h1>Alta Peliculas</h1>
	
	<form:form method="POST" modelAttribute="movieDto" action="/booksmov/app/movies/new" enctype="multipart/form-data" >
		<form:label path="title">
			<spring:message code="label.movies.title" /> 
		</form:label>
		<form:input path="title" maxlength="200"/> <form:errors path="title" cssStyle="color: red" /><br/><br/>
		<form:label path="actors">
			<spring:message code="label.movies.actors"/>
			<spring:message code="label.movies.actors.example"/>
		</form:label>
		<form:input path="actors" maxlength="100"/> <br />
		<form:label path="director.fullName">
			<spring:message code="label.movies.director"/>
		</form:label>
		<form:input path="director.fullName" maxlength="100"/> 
		<form:errors path="director.fullName" cssStyle="color: red" /><br/>
		<form:label path="rating">
			<spring:message code="label.movies.rating" /> 
		</form:label>
		<form:radiobutton path="rating" value="1"/>1 
		<form:radiobutton path="rating" value="2"/>2 
		<form:radiobutton path="rating" value="3"/>3 
		<form:radiobutton path="rating" value="4"/>4 
		<form:radiobutton path="rating" value="5"/>5
		<form:errors path="rating" cssStyle="color: red" /><br/>
		
		<form:label path="selectedFormat">
			<spring:message code="label.movies.formats" /> 
		</form:label>
		<form:select path="selectedFormat">
			 <form:option value="--" />
		     <form:options items="${formats}"  />
		</form:select> <form:errors path="selectedFormat" cssStyle="color: red" /><br/>
		
		<form:label path="borrowable">
			<spring:message code="label.movies.borrowable" /> 
		</form:label> 
		<form:checkbox path="borrowable" /><br />
		
		<form:label path="alreadyUsed">
			<spring:message code="label.movies.alreadyUsed" /> 
		</form:label> 
		<form:checkbox path="alreadyUsed" /><br />
		
		<form:label path="image">
			<spring:message code="label.movies.image" /> 
		</form:label>
		<form:input type="file" path="image" />
		<form:errors path="image" cssStyle="color: red" /><br/>
		
		<form:button><spring:message code="label.submit"/></form:button>
	</form:form>
	
	<c:if test="${movieDto.success}">
		<h2>La pelicula se ha ingresado exitosamente!</h2>
	</c:if>
	
<%-- 	<script src="<c:url value="/resources/js/authors.js" />"></script> --%>
	<script>
		//author.init();
	</script>
</body>
</html>