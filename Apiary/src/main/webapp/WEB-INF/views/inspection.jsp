<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/ddmenu.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/jquery/jquery-ui.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/jquery/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/resources/jquery/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/js/ddmenu.js" />"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd",
			changeMonth : true,
			changeYear : true
		}).val()
	});
</script>
<title><spring:message code="inspection.edit.title" /></title>
</head>
<body>
	<a id="ddmenuLink"
		href="${pageContext.request.contextPath}/resources/ddmenu-source.html">Menu</a>
	<div class="container" style="margin: 20px;">
		<h3>
			<c:choose>
				<c:when test="${operation == 'add'}">
					<spring:message code="inspection.add" />
				</c:when>
				<c:otherwise>
					<spring:message code="inspection.edit" />
				</c:otherwise>
			</c:choose>
		</h3>
		<form:form action="save" modelAttribute="inspection">
			<table>
				<c:if test="${inspection.id gt 0}">
					<form:hidden path="id" />
				</c:if>
				<tr>
					<td><form:label path="inspectionDate">
							<spring:message code="inspection.date" />
						</form:label></td>
					<td><form:input path="inspectionDate" id="datepicker" /></td>
				</tr>
				<tr>
					<td><form:label path="openedBrood">
							<spring:message code="inspection.opened.brood" />
						</form:label></td>
					<td><form:select path="openedBrood">
							<form:options items="${openBroodList}" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="closedBrood">
							<spring:message code="inspection.closed.brood" />
						</form:label></td>
					<td><form:select path="closedBrood">
							<form:options items="${closedBroodList}" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="queenPresent">
							<spring:message code="inspection.queen" />
						</form:label></td>
					<td><form:select path="queenPresent">
							<form:options items="${queenPresentList}" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="numberOfFrames">
							<spring:message code="inspection.frames.count" />
						</form:label></td>
					<td><form:input path="numberOfFrames" /></td>
				</tr>
				<tr>
					<td><form:label path="numberOfBroodFrames">
							<spring:message code="inspection.frames.brood.count" />
						</form:label></td>
					<td><form:input path="numberOfBroodFrames" /></td>
				</tr>
				<tr>
					<td><form:label path="swarmMood">
							<spring:message code="inspection.swarmMood" />
						</form:label></td>
					<td><form:select path="queenPresent">
							<form:options items="${swarmMoodList}" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="temperature">
							<spring:message code="inspection.temperature" />
						</form:label></td>
					<td><form:input path="temperature" /></td>
				</tr>
				<tr>
					<td><form:label path="status">
							<spring:message code="inspection.status" />
						</form:label></td>
					<td><form:input path="status" /></td>
				</tr>
				<tr>
					<td colspan="2"><c:choose>
							<c:when test="${inspection.id gt 0}">
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