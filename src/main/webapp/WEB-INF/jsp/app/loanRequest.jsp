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
	<h1>Solicitud de Prestamo</h1>
	
	<form:form action="/booksmov/app/loan/request" method="POST" modelAttribute="loanDto">
		<form:label path="requestDescription">
			<spring:message code="loan.request.description" />
		</form:label>
		<form:textarea path="requestDescription" maxlength="500" />
		<form:hidden path="consigneeId"/>
		<form:hidden path="productId"/>
		<form:button><spring:message code="loan.submit.request"/></form:button>
	</form:form>
</body>
</html>