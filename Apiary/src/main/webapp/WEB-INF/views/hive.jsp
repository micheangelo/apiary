<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>
<link href="<c:url value="/resources/css/ddmenu.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/jquery/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/resources/js/ddmenu.js" />"></script>
<title><spring:message code="hive.edit.title" /></title>
</head>
<body>
	<a id="ddmenuLink"
		href="${pageContext.request.contextPath}/resources/ddmenu-source.html">Menu</a>
	<div class="container" style="margin: 20px;">
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
					<td><select name="purchaseYear" id="purchaseYear">
					</select> <script type="text/javascript">
						for (i = new Date().getFullYear(); i > 2000; i--) {
							$('#purchaseYear').append(
									$('<option />').val(i).html(i));
						}
						$("#purchaseYear")
								.prop('value', "${hive.purchaseYear}");
					</script></td>
				</tr>
				<tr>
					<td><form:label path="hiveType">
							<spring:message code="hive.hiveType" />
						</form:label></td>
					<td><form:input path="hiveType" /></td>
				</tr>
				<tr>
					<td><form:label path="description">
							<spring:message code="hive.description" />
						</form:label></td>
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td><c:choose>
							<c:when test="${hive.id gt 0}">
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