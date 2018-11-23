<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css">
<link href="<c:url value="/resources/css/ddmenu.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/jquery/jquery-ui.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/jquery/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/resources/jquery/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/js/ddmenu.js" />"></script>
<title><spring:message code="item.edit.title" /></title>
</head>
<body>
	<a id="ddmenuLink"
		href="${pageContext.request.contextPath}/resources/ddmenu-source.html">Menu</a>
	<div class="container" style="margin: 20px;">
		<h3>
			<c:choose>
				<c:when test="${operation == 'add'}">
					<spring:message code="item.add" />
				</c:when>
				<c:otherwise>
					<spring:message code="item.edit" />
				</c:otherwise>
			</c:choose>
		</h3>
		<form:form action="save" modelAttribute="item">
			<table>
				<c:if test="${item.id gt 0}">
					<form:hidden path="id" />
				</c:if>
				<tr>
					<td><form:label path="name">
							<spring:message code="item.name" />
						</form:label></td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><form:label path="quantity">
							<spring:message code="item.quantity" />
						</form:label></td>
					<td><form:input path="quantity" /></td>
				</tr>
				<tr>
					<td><form:label path="description">
							<spring:message code="item.description" />
						</form:label></td>
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td><form:label path="itemCategoryId">
							<spring:message code="item.category" />
						</form:label></td>
					<td><form:select path="itemCategoryId">
							<form:option value="-1" label="...." />
							<form:options items="${listItemCategories}" itemValue="id"
								itemLabel="name" />
						</form:select></td>
				</tr>
				<tr>
					<td colspan="2"><c:choose>
							<c:when test="${item.id gt 0}">
								<input type="submit"
									value="<spring:message code="global.save"/>" />
							</c:when>
							<c:otherwise>
								<input type="submit" value="<spring:message code="global.add"/>" />
							</c:otherwise>
						</c:choose> <input type="button"
						value="<spring:message code="global.cancel"/>"
						onclick="history.back()" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>