<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	response.setCharacterEncoding("iso-8859-2");
	request.setCharacterEncoding("iso-8859-2");
%>
<html>
<head>
<title><spring:message code="family.edit.title" /></title>
</head>
<body>
	<a id="ddmenuLink" href="resources/ddmenu-source.html">Menu</a>
	<h3>
		<spring:message code="family.add" />
	</h3>
	<form:form action="save" modelAttribute="family">
		<table>
			<c:if test="${!empty family.description}">
				<tr>
					<td><form:label path="id">
							<spring:message code="family.id" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="race">
						<spring:message code="family.race" />
					</form:label></td>
				<td><form:input path="race" /></td>
			</tr>
			<tr>
				<td><form:label path="queenOrigin">
						<spring:message code="family.queenOrigin" />
					</form:label></td>
				<td><form:input path="queenOrigin" /></td>
			</tr>
			<tr>
				<td><form:label path="queenBirthYear">
						<spring:message code="family.queenBirthYear" />
					</form:label></td>
				<td><form:input path="queenBirthYear" /></td>
			</tr>

			<tr>
				<td><form:label path="familyId">
						<spring:message code="family.Id" />
					</form:label></td>
				<td><form:select path="transactionType">
						<form:option value="" label="...." />
						<form:options items="${listTransactionTypes}" itemValue="symbol"
							itemLabel="name" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty family.description}">
						<input type="submit" value="<spring:message code="global.save"/>" />
					</c:if> <c:if test="${empty family.description}">
						<input type="submit" value="<spring:message code="global.add"/>" />
					</c:if> <input type="button"
					value="<spring:message code="global.cancel"/>"
					onclick="history.back()" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>