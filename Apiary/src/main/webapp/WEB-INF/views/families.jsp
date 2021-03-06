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
<script src="<c:url value="/resources/js/ddmenu.js" />"></script>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title><spring:message code="family.title" /></title>

</head>
<body>
	<a id="ddmenuLink" href="resources/ddmenu-source.html">Menu</a>
	<div class="container" style="margin-top: 20px;">
		<jsp:useBean id="listFamilies" scope="request"
			type="org.springframework.beans.support.PagedListHolder<pl.manager.apiary.model.Family>" />
		<c:url value="/families" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<h3>
			<spring:message code="family.list" />
		</h3>

		<tg:paging pagedListHolder="${listFamilies}" pagedLink="${pagedLink}" />
		<table class="tg">
			<tr>
				<th width="80"><spring:message code="family.race" /></th>
				<th width="120"><spring:message code="family.queenOrigin" /></th>
				<th width="120"><spring:message code="family.queenBirthYear" /></th>
				<th width="30"><spring:message code="family.hive" /></th>
				<th width="60"><spring:message code="global.edit" /></th>
				<th width="60"><spring:message code="global.delete" /></th>
			</tr>
			<c:forEach items="${listFamilies.pageList}" var="family">
				<tr>
					<td>${family.race}</td>
					<td>${family.queenOrigin}</td>
					<td>${family.queenBirthYear}</td>
					<td align="center"><c:if test="${family.hive.id gt 0}">
							<a href="<c:url value='hives/edit/${family.hive.id}' />"> <img
								src="resources/icons/hive.png"
								alt=<spring:message
									code="global.show" />></a>
						</c:if></td>
					<td align="center"><a
						href="<c:url value='families/edit/${family.id}' />"><img
							src="resources/icons/edit.png"
							alt=<spring:message
								code="global.edit" />></a></td>
					<td align="center"><a
						href="<c:url value='families/remove/${family.id}' />"><img
							src="resources/icons/delete.png"
							alt=<spring:message
								code="global.delete" />></a></td>
				</tr>
			</c:forEach>
		</table>
		<tg:paging pagedListHolder="${listFamilies}" pagedLink="${pagedLink}" />
		<br />
		<form:form action="families/add" modelAttribute="family">
			<input type="submit" name="addFamily"
				value="<spring:message code="global.add"/>" />
		</form:form>
	</div>
</body>
</html>
