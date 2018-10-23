<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<h3>
		<spring:message code="hive.list" />
	</h3>
	<c:if test="${!empty listHives}">
		<table class="tg">
			<tr>
				<th width="80"><spring:message code="hive.id" /></th>
				<th width="80"><spring:message code="hive.identifier" /></th>
				<th width="120"><spring:message code="hive.material" /></th>
				<th width="120"><spring:message code="hive.purchaseYear" /></th>
				<th width="120"><spring:message code="hive.hiveType" /></th>
				<th width="120"><spring:message code="hive.description" /></th>
				<th width="60"><spring:message code="hive.family" /></th>
				<th width="60"><spring:message code="global.edit" /></th>
				<th width="60"><spring:message code="global.delete" /></th>
			</tr>
			<c:forEach items="${listHives}" var="hive">
				<tr>
					<td>${hive.id}</td>
					<td>${hive.identifier}</td>
					<td>${hive.material}</td>
					<td>${hive.purchaseYear}</td>
					<td>${hive.hiveType}</td>
					<td>${hive.description}</td>
					<c:choose>
						<c:when test="${!empty hive.family}">
							<td><a href="<c:url value='hive/family/${hive.family.id} }' />"><spring:message
										code="global.show" /></a></td>
						</c:when>
						<c:otherwise>
							<td />
						</c:otherwise>
					</c:choose>
					<td><a href="<c:url value='hive/edit/${hive.id}' />"><spring:message
								code="global.edit" /></a></td>
					<td><a href="<c:url value='hive/remove/${hive.id}' />"><spring:message
								code="global.delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />
	<form:form action="${addAction}" modelAttribute="hive">
		<input type="submit" name="addHive"
			value="<spring:message code="global.add"/>" />
	</form:form>
</body>
</html>
