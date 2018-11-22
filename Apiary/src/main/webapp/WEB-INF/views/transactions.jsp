<%@page import="pl.manager.apiary.model.Transaction"%>
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
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
<script src="<c:url value="/resources/js/ddmenu.js" />"></script>
<title><spring:message code="transaction.title" /></title>

</head>
<body>
	<a id="ddmenuLink" href="resources/ddmenu-source.html">Menu</a>
	<div class="container" style="margin-top: 20px;">
		<jsp:useBean id="listTransactions" scope="request"
			type="org.springframework.beans.support.PagedListHolder<pl.manager.apiary.model.Transaction>" />
		<c:url value="/transactions" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<h3>
			<spring:message code="transaction.list" />
		</h3>
		<tg:paging pagedListHolder="${listTransactions}"
			pagedLink="${pagedLink}" />
		<table class="tg">
			<tr>
				<th width="120"><spring:message code="transaction.date" /></th>
				<th width="120"><spring:message code="transaction.description" /></th>
				<th width="120"><spring:message code="transaction.quantity" /></th>
				<th width="120"><spring:message code="transaction.price" /></th>
				<th width="120"><spring:message code="transaction.type" /></th>
				<th width="60"><spring:message code="global.edit" /></th>
				<th width="60"><spring:message code="global.delete" /></th>
			</tr>
			<c:forEach items="${listTransactions.pageList}" var="transaction">
				<tr>
					<td>${transaction.transactionDate}</td>
					<td>${transaction.description}</td>
					<td>${transaction.quantity}</td>
					<td>${transaction.price}</td>
					<td>${transaction.typeName}</td>
					<td align="center"><a
						href="<c:url value='transactions/edit/${transaction.id}' />"><img
							src="resources/icons/edit.png"
							alt=<spring:message
								code="global.edit" />></a></td>
					<td align="center"><a
						href="<c:url value='transactions/remove/${transaction.id}' />"><img
							src="resources/icons/delete.png"
							alt=<spring:message
								code="global.delete" />></a></td>
				</tr>
			</c:forEach>
		</table>
		<tg:paging pagedListHolder="${listTransactions}"
			pagedLink="${pagedLink}" />
		<br />
		<form:form action="transactions/add" modelAttribute="transaction">
			<input type="submit" name="addTransaction"
				value="<spring:message code="global.add"/>" />
		</form:form>
	</div>
</body>
</html>
