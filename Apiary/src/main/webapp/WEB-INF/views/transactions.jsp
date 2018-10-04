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
<title><spring:message code="transaction.title" /></title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h1>
		<spring:message code="transaction.add" />
	</h1>

	<c:url var="addAction" value="/transaction/add"></c:url>

	<form:form action="${addAction}" modelAttribute="transaction">
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
				<!-- <td><select name="transactionType" >
						<c:forEach items="${listTransactionTypes}" var="transactionType">
							<option value="${transactionType.symbol}">${transactionType.name}</option>
						</c:forEach>
				</select></td> -->
				<td><form:select path="transactionType">
					 <form:option value="" label="...." />
                     <form:options items="${listTransactionTypes}" itemValue="symbol" itemLabel="name" />						
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
						<input type="submit" value="<spring:message code="global.edit"/>" />
					</c:if> <c:if test="${empty transaction.description}">
						<input type="submit" value="<spring:message code="global.add"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>
		<spring:message code="transaction.list" />
	</h3>
	<c:if test="${!empty listTransactions}">
		<table class="tg">
			<tr>
				<th width="80"><spring:message code="transaction.id" /></th>
				<th width="120"><spring:message code="transaction.description" /></th>
				<th width="120"><spring:message code="transaction.quantity" /></th>
				<th width="120"><spring:message code="transaction.price" /></th>
				<th width="120"><spring:message code="transaction.type" /></th>
				<th width="120"><spring:message code="transaction.date" /></th>
				<th width="60"><spring:message code="global.edit" /></th>
				<th width="60"><spring:message code="global.delete" /></th>
			</tr>
			<c:forEach items="${listTransactions}" var="transaction">
				<tr>
					<td>${transaction.id}</td>
					<td>${transaction.description}</td>
					<td>${transaction.quantity}</td>
					<td>${transaction.price}</td>
					<td>${transaction.transactionType}</td>
					<td>${transaction.transactionDate}</td>
					<td><a href="<c:url value='/edit/${transaction.id}' />"><spring:message
								code="global.edit" /></a></td>
					<td><a href="<c:url value='/remove/${transaction.id}' />"><spring:message
								code="global.delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
