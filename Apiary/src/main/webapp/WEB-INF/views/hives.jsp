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
<title><spring:message code="hive.title" /></title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
	width: 100%;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<a id="ddmenuLink" href="resources/ddmenu-source.html">Menu</a>
	<div class="container" style="margin-top: 20px;">
		<jsp:useBean id="listHives" scope="request"
			type="org.springframework.beans.support.PagedListHolder<pl.manager.apiary.model.Hive>" />
		<c:url value="/hives" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<h3>
			<spring:message code="hive.list" />
		</h3>
		<tg:paging pagedListHolder="${listHives}" pagedLink="${pagedLink}" />
		<table class="tg">
			<tr>
				<th width="80"><spring:message code="hive.identifier" /></th>
				<th width="120"><spring:message code="hive.material" /></th>
				<th width="120"><spring:message code="hive.purchaseYear" /></th>
				<th width="120"><spring:message code="hive.hiveType" /></th>
				<th width="120"><spring:message code="hive.description" /></th>
				<th width="60"><spring:message code="hive.family" /></th>
				<th width="60"><spring:message code="global.edit" /></th>
				<th width="60"><spring:message code="global.delete" /></th>
			</tr>
			<c:forEach items="${listHives.pageList}" var="hive">
				<tr>
					<td>${hive.identifier}</td>
					<td>${hive.material}</td>
					<td>${hive.purchaseYear}</td>
					<td>${hive.hiveType}</td>
					<td>${hive.description}</td>
					<c:choose>
						<c:when test="${!empty hive.family}">
							<td align="center"><a
								href="<c:url value='families/edit/${hive.family.id}' />"><img
									src="resources/icons/bee.png"
									alt=<spring:message
										code="global.show" />></a></td>
						</c:when>
						<c:otherwise>
							<td />
						</c:otherwise>
					</c:choose>
					<td align="center"><a
						href="<c:url value='hives/edit/${hive.id}' />"><img
							src="resources/icons/edit.png"
							alt=<spring:message
								code="global.edit" />></a></td>
					<td align="center"><a
						href="<c:url value='hives/remove/${hive.id}' />"><img
							src="resources/icons/delete.png"
							alt=<spring:message
								code="global.delete" />></a></td>
				</tr>
			</c:forEach>
		</table>
		<tg:paging pagedListHolder="${listHives}" pagedLink="${pagedLink}" />
		<br />
		<form:form action="hives/add" modelAttribute="hive">
			<input type="submit" name="addHive"
				value="<spring:message code="global.add"/>" />
		</form:form>
	</div>
</body>
</html>
