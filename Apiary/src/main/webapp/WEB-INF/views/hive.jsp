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
<link href="<c:url value="../resources/css/ddmenu.css" />"
	rel="stylesheet">
<script src="<c:url value="../resources/js/ddmenu.js" />"></script>
<title><spring:message code="hive.edit.title" /></title>
</head>
<body>
	<a id="ddmenuLink" href="../resources/ddmenu-source.html">Menu</a>
	<h3>
		<c:choose>
			<c:when test="${operation == 'add'}">
				<spring:message code="hive.add" />
			</c:when>
			<c:otherwise>
				<spring:message code="hive.edit" />
			</c:otherwise>
		</c:choose>
	</h3>
	<form:form action="save" modelAttribute="hive">
		<table>
			<c:if test="${hive.id gt 0}">
				<form:hidden path="id" />
			</c:if>
			<tr>
				<td><form:label path="identifier">
						<spring:message code="hive.identifier" />
					</form:label></td>
				<td><form:input path="identifier" /></td>
			</tr>
			<tr>
				<td><form:label path="material">
						<spring:message code="hive.material" />
					</form:label></td>
				<td><form:input path="material" /></td>
			</tr>
			<tr>
				<td><form:label path="purchaseYear">
						<spring:message code="hive.purchaseYear" />
					</form:label></td>
				<td><form:input path="purchaseYear" /></td>
			</tr>

			<tr>
				<td><form:label path="hiveType">
						<spring:message code="hive.hiveType" />
					</form:label></td>
				<td><form:input path="hiveType" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty hive.description}">
						<input type="submit" value="<spring:message code="global.save"/>" />
					</c:if> <c:if test="${empty hive.description}">
						<input type="submit" value="<spring:message code="global.add"/>" />
					</c:if> <input type="button"
					value="<spring:message code="global.cancel"/>"
					onclick="history.back()" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>