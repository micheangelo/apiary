<%@page import="pl.manager.apiary.model.Item"%>
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
<title><spring:message code="item.title" /></title>

</head>
<body>
	<a id="ddmenuLink" href="resources/ddmenu-source.html">Menu</a>
	<div class="container" style="margin-top: 20px;">
		<jsp:useBean id="listItems" scope="request"
			type="org.springframework.beans.support.PagedListHolder<pl.manager.apiary.model.Item>" />
		<c:url value="/items" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<h3>
			<spring:message code="item.list" />
		</h3>
		<tg:paging pagedListHolder="${listItems}"
			pagedLink="${pagedLink}" />
		<table class="tg">
			<tr>
				<th width="120"><spring:message code="item.name" /></th>
				<th width="120"><spring:message code="item.quantity" /></th>
				<th width="120"><spring:message code="item.description" /></th>
				<th width="120"><spring:message code="item.category" /></th>
				<th width="60"><spring:message code="global.edit" /></th>
				<th width="60"><spring:message code="global.delete" /></th>
			</tr>
			<c:forEach items="${listItems.pageList}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.quantity}</td>
					<td>${item.description}</td>
					<td>${item.category}</td>					
					<td align="center"><a
						href="<c:url value='items/edit/${item.id}' />"><img
							src="resources/icons/edit.png"
							alt=<spring:message
								code="global.edit" />></a></td>
					<td align="center"><a
						href="<c:url value='items/remove/${item.id}' />"><img
							src="resources/icons/delete.png"
							alt=<spring:message
								code="global.delete" />></a></td>
				</tr>
			</c:forEach>
		</table>
		<tg:paging pagedListHolder="${listItems}"
			pagedLink="${pagedLink}" />
		<br />
		<form:form action="items/add" modelAttribute="item">
			<input type="submit" name="addItem"
				value="<spring:message code="global.add"/>" />
		</form:form>
	</div>
</body>
</html>
