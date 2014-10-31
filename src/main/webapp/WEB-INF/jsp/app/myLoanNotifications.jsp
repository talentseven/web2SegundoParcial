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
<title><spring:message code="loan.my.loans"/></title>
</head>
<body>
	<h1><spring:message code="loan.notified.list"/></h1>
	<c:set var="backgroundColor" value="" />
	<c:set var="state" value="" />
	<c:set var="pending" value="false" />
	<c:set var="accepted" value="false" />
	<c:choose>
		<c:when test="${empty loans}">
			<h3><spring:message code="loan.not.in.course"/></h3>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th><spring:message code="loan.requested.cover"/></th>
					<th><spring:message code="loan.requested.title"/></th>
					<th><spring:message code="loan.requested.requester"/></th>
					<th><spring:message code="loan.requested.date"/></th>
					<th><spring:message code="loan.requested.state"/></th>
					<th><spring:message code="loan.requested.message"/></th>			
					<th><spring:message code="loan.response.date"/></th>
					<th><spring:message code="loan.delivery.date"/></th>
					<th><spring:message code="loan.requested.action"/></th>
				</tr>
				<c:forEach var="loan" items="${loans}">
					<c:choose>	
						<c:when test="${loan.state eq 'ACCEPTED'}">
							<c:set var="state">
								<spring:message code='loan.state.accepted' />
							</c:set>
							<c:set var="backgroundColor" value="green" />
							<c:set var="pending" value="false" />
							<c:set var="accepted" value="true" />
						</c:when>
						<c:when test="${loan.state eq 'REJECTED'}">
							<c:set var="state">
								<spring:message code="loan.state.rejected" />
							</c:set>
							<c:set var="backgroundColor" value="red" />
							<c:set var="accepted" value="false" />
							<c:set var="delivered" value="false" />
						</c:when>
						<c:when test="${loan.state eq 'DELIVERED'}">
							<c:set var="state">
								<spring:message code="loan.state.delivered" />
							</c:set>
							<c:set var="backgroundColor" value="gray" />
							<c:set var="pending" value="false" />
							<c:set var="accepted" value="false" />
						</c:when>
						<c:otherwise>
							<c:set var="state">
								<spring:message code="loan.state.pending" />
							</c:set>
							<c:set var="backgroundColor" value="yellow" />
							<c:set var="pending" value="true" />
							<c:set var="accepted" value="false" />
						</c:otherwise>
					</c:choose>
					<tr style="background-color:${backgroundColor}">
						<td><img height="130" width="100" src='<c:url value="/app/image/${loan.product.id}" />' /></td>
						<td>${loan.product.title}</td>
						<td>${loan.requester.name}</td>
						<td>${loan.requestDate}</td>
						<td>${state}</td>
						<td>${loan.requestDescription}</td>
						<td>
							<c:choose>
								<c:when test="${not empty loan.responseDate}">
									${loan.responseDate}
								</c:when>
								<c:otherwise>
									<spring:message code="loan.response.date.missing"/>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${loan.state eq 'DELIVERED'}">
									${loan.deliveryDate}
								</c:when>
								<c:otherwise>
									<spring:message code="loan.no.apply"/>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:if test="${pending}">
								<a href='<c:url value="/app/loan/accept/${loan.id}" />' >
								   <button><spring:message code="loan.response.accept"/></button>
								</a>
								<a href="<c:url value="/app/loan/reject/${loan.id}" />" >
								   <button><spring:message code="loan.response.reject"/></button>
								</a>
							</c:if>
							<c:if test="${accepted}">
								<a href='<c:url value="/app/loan/deliver/${loan.id}" />' >
								   <button><spring:message code="loan.response.deliver"/></button>
								</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>