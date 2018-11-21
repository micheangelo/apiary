<%@page import="pl.manager.apiary.model.ItemCategory"%>
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
<title><spring:message code="item.category.title" /></title>
<style type="text/css">
.div {
	margin: 20px;
}
</style>
</head>
<body>
	<a id="ddmenuLink" href="resources/ddmenu-source.html">Menu</a>
	<div class="container" style="margin-top: 20px;">
		<jsp:useBean id="listItemCategories" scope="request"
			type="org.springframework.beans.support.PagedListHolder<pl.manager.apiary.model.ItemCategory>" />
		<c:url value="/item-categories" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<h3>
			<spring:message code="item.category.list" />
		</h3>
		<tg:paging pagedListHolder="${listItemCategories}"
			pagedLink="${pagedLink}" />
		<table class="tg">
			<tr>
				<th width="120"><spring:message code="item.category.name" /></th>
				<th width="60"><spring:message code="global.edit" /></th>
				<th width="60"><spring:message code="global.delete" /></th>
			</tr>
			<c:forEach items="${listItemCategories.pageList}"
				var="itemCategory">
				<tr>
					<td>${itemCategory.name}</td>
					<td align="center"><a
						href="<c:url value='item-categories/edit/${itemCategory.id}' />"><img
							src="resources/icons/edit.png"
							alt=<spring:message
								code="global.edit" />></a></td>
					<td align="center"><a
						href="<c:url value='item-categoris/remove/${itemCategory.id}' />"><img
							src="resources/icons/delete.png"
							alt=<spring:message
								code="global.delete" />></a></td>
				</tr>
			</c:forEach>
		</table>
		<tg:paging pagedListHolder="${listItemCategories}"
			pagedLink="${pagedLink}" />
		<br />
		<form:form action="item-categories/add"
			modelAttribute="itemCategory">
			<input type="submit" name="addItemCategory"
				value="<spring:message code="global.add"/>" />
		</form:form>
	</div>
</body>
</html>
