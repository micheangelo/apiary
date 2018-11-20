<%@page import="pl.manager.apiary.model.Inspection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ page session="false"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<link href="<c:url value="/resources/css/ddmenu.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/ddmenu.js" />"></script>
<title><spring:message code="inspection.title" /></title>

</head>
<body>
	<a id="ddmenuLink" href="resources/ddmenu-source.html">Menu</a>
	<div class="container" style="margin-top: 20px;">
		<jsp:useBean id="listInspections" scope="request"
			type="org.springframework.beans.support.PagedListHolder<pl.manager.apiary.model.Inspection>" />
		<c:url value="/inspections" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<h3>
			<spring:message code="inspection.list" />
		</h3>
		<tg:paging pagedListHolder="${listInspections}"
			pagedLink="${pagedLink}" />
		<table class="tg">
			<tr>
				<th width="120"><spring:message code="inspection.date" /></th>
				<th width="120"><spring:message code="inspection.opened.brood" /></th>
				<th width="120"><spring:message code="inspection.closed.brood" /></th>
				<th width="120"><spring:message code="inspection.queen" /></th>
				<th width="120"><spring:message code="inspection.frames.count" /></th>
				<th width="120"><spring:message code="inspection.frames.brood.count" /></th>
				<th width="120"><spring:message code="inspection.swarmMood" /></th>
				<th width="120"><spring:message code="inspection.temperature" /></th>
				<th width="120"><spring:message code="inspection.status" /></th>
				<th width="60"><spring:message code="global.edit" /></th>
				<th width="60"><spring:message code="global.delete" /></th>
			</tr>
			<c:forEach items="${listInspections.pageList}" var="inspection">
				<tr>
					<td>${inspection.inspectionDate}</td>
					<td>${inspection.openedBrood}</td>
					<td>${inspection.closedBrood}</td>
					<td>${inspection.queenPresent}</td>
					<td>${inspection.numberOfFrames}</td>
					<td>${inspection.numberOfBroodFrames}</td>
					<td>${inspection.swarmMood}</td>
					<td>${inspection.temperature}</td>
					<td>${inspection.status}</td>
					<td align="center"><a
						href="<c:url value='inspections/edit/${inspection.id}' />"><img
							src="resources/icons/edit.png"
							alt=<spring:message
								code="global.edit" />></a></td>
					<td align="center"><a
						href="<c:url value='inspections/remove/${inspection.id}' />"><img
							src="resources/icons/delete.png"
							alt=<spring:message
								code="global.delete" />></a></td>
				</tr>
			</c:forEach>
		</table>
		<tg:paging pagedListHolder="${listInspections}"
			pagedLink="${pagedLink}" />
		<br />
		<form:form action="inspections/add" modelAttribute="inspection">
			<input type="submit" name="addInspection"
				value="<spring:message code="global.add"/>" />
		</form:form>
	</div>
</body>
</html>
