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
<title>BooksMov - Login page</title>
</head>
<body>
	<form:form method="POST" modelAttribute="userDto" action="/booksmov/login">
		<form:label path="email">
			<spring:message code="label.email" /> 
		</form:label>
		<form:input path="email"/>  <br />
		<form:label path="password">
			<spring:message code="label.password"/>
		</form:label>
		<form:password path="password"/> <form:errors path="password" cssStyle="color: red" /><br/>
		<form:button><spring:message code="label.submit"/></form:button>
		<form:errors path="email" cssStyle="color: red" /><br/>
	</form:form>
	</body>
</html>