<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>
<link href="<c:url value="/resources/css/ddmenu.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/ddmenu.js" />"></script>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" >
<title><spring:message code="item.category.edit" /></title>
</head>
<body>
	<a id="ddmenuLink"
		href="${pageContext.request.contextPath}/resources/ddmenu-source.html">Menu</a>
	<div class="container">
		<h3>
			<c:choose>
				<c:when test="${operation == 'add'}">
					<spring:message code="item.category.add" />
				</c:when>
				<c:otherwise>
					<spring:message code="item.category.edit" />
				</c:otherwise>
			</c:choose>
		</h3>
		<form:form action="save" modelAttribute="itemCategory">
			<table>
				<c:if test="${itemCategory.id gt 0}">
					<form:hidden path="id" />
				</c:if>

				<tr>
					<td><form:label path="name">
							<spring:message code="item.category.name" />
						</form:label></td>
					<td><form:input path="name" /></td>
				</tr>

				<tr>
					<td colspan="2"><c:if test="${!empty itemCategory.id}">
							<input type="submit" value="<spring:message code="global.save"/>" />
						</c:if> <c:if test="${empty itemCategory.id}">
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