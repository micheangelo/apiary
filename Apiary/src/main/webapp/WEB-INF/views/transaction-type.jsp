<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>
<link href="<c:url value="/resources/css/ddmenu.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/ddmenu.js" />"></script>
<title><spring:message code="transaction.type.edit" /></title>
</head>
<body>
	<a id="ddmenuLink"
		href="${pageContext.request.contextPath}/resources/ddmenu-source.html">Menu</a>
	<div class="container" style="margin: 20px;">
		<h3>
			<c:choose>
				<c:when test="${operation == 'add'}">
					<spring:message code="transaction.type.add" />
				</c:when>
				<c:otherwise>
					<spring:message code="transaction.type.edit" />
				</c:otherwise>
			</c:choose>
		</h3>
		<form:form action="save" modelAttribute="transactionType">
			<table>
				<c:if test="${transactionType.id gt 0}">
					<form:hidden path="id" />
				</c:if>
				<c:if test="${!empty transactionType.name}">
				<tr>
					<td><form:label path="name">
							<spring:message code="transaction.type.name" />
						</form:label></td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><form:label path="symbol">
							<spring:message code="transaction.type.symbol" />
						</form:label></td>
					<td><form:input path="symbol" /></td>
				</tr>
				</c:if>

				<tr>
					<td colspan="2"><c:if test="${!empty transactionType.id}">
							<input type="submit" value="<spring:message code="global.save"/>" />
						</c:if> <c:if test="${empty transactionType.id}">
							<input type="submit" value="<spring:message code="global.add"/>" />
						</c:if> <input type="button"
						value="<spring:message code="global.cancel"/>"
						onclick="history.back()" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>