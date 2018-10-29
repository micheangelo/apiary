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
<title><spring:message code="family.edit.title" /></title>
</head>
<body>
	<a id="ddmenuLink" href="../resources/ddmenu-source.html">Menu</a>
	<h3>
		<spring:message code="family.add" />
	</h3>
	<form:form action="save" modelAttribute="family">
		<table>
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
				<td><form:label path="hive">
						<spring:message code="hive.id" />
					</form:label></td>
				<td><form:select path="hive.id">
						<form:option value="-1" label="...." />
						<form:options items="${listHives}" itemValue="hive.id"
							itemLabel="hive.identifier" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty family.id}">
						<input type="submit" value="<spring:message code="global.save"/>" />
					</c:if> <c:if test="${empty family.id}">
						<input type="submit" value="<spring:message code="global.add"/>" />
					</c:if> <input type="button"
					value="<spring:message code="global.cancel"/>"
					onclick="history.back()" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>