<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>
<link href="<c:url value="/resources/css/ddmenu.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/jquery/jquery-ui.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/ddmenu.js" />"></script>
<script src="<c:url value="/resources/jquery/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/resources/jquery/jquery-ui.js" />"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd",
			changeMonth : true,
			changeYear : true
		}).val()
	});
</script>
<title><spring:message code="transaction.edit.title" /></title>
</head>
<body>
	<a id="ddmenuLink"
		href="${pageContext.request.contextPath}/resources/ddmenu-source.html">Menu</a>
	<div class="container" style="margin: 20px;">
		<h3>
			<c:choose>
				<c:when test="${operation == 'add'}">
					<spring:message code="transaction.add" />
				</c:when>
				<c:otherwise>
					<spring:message code="transaction.edit" />
				</c:otherwise>
			</c:choose>
		</h3>
		<form:form action="save" modelAttribute="transaction">
			<table>
				<c:if test="${transaction.id gt 0}">
					<form:hidden path="id" />
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
							<form:option value="-1" label="...." />
							<form:options items="${listTransactionTypes}" itemValue="id"
								itemLabel="name" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="transactionDate">
							<spring:message code="transaction.date" />
						</form:label></td>
					<td><form:input path="transactionDate" id="datepicker" /></td>
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
	</div>
</body>
</html>