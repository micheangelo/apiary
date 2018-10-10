<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<title><spring:message code="transaction.edit.title" /></title>
</head>
<body>
	<h3>
		<spring:message code="transaction.add" />
	</h3>
	<form:form action="save" modelAttribute="transaction">
		<table>
			<c:if test="${!empty transaction.description}">
				<tr>
					<td><form:label path="id">
							<spring:message code="transaction.id" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="description">
						<spring:message code="transaction.description" />
					</form:label></td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td><form:label path="quantity">
						<spring:message code="transaction.quantity" />
					</form:label></td>
				<td><form:input path="quantity" /></td>
			</tr>
			<tr>
				<td><form:label path="price">
						<spring:message code="transaction.price" />
					</form:label></td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td><form:label path="transactionType">
						<spring:message code="transaction.type" />
					</form:label></td>
				<td><form:select path="transactionType">
						<form:option value="" label="...." />
						<form:options items="${listTransactionTypes}" itemValue="symbol"
							itemLabel="name" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="transactionDate">
						<spring:message code="transaction.date" />
					</form:label></td>
				<td><form:input path="transactionDate" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty transaction.description}">
						<input type="submit" value="<spring:message code="global.save"/>" />
					</c:if> <c:if test="${empty transaction.description}">
						<input type="submit" value="<spring:message code="global.add"/>" />
					</c:if> <input type="button"
					value="<spring:message code="global.cancel"/>"
					onclick="history.back()" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>