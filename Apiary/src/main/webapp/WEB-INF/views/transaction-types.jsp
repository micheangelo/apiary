<%@page import="pl.manager.apiary.model.TransactionType"%>
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
<title><spring:message code="transaction.type.title" /></title>
<style type="text/css">
.div{
	margin: 20px;
}

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
		<jsp:useBean id="listTransactionTypes" scope="request"
			type="org.springframework.beans.support.PagedListHolder<pl.manager.apiary.model.TransactionType>" />
		<c:url value="/transaction-types" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<h3>
			<spring:message code="transaction.type.list" />
		</h3>
		<tg:paging pagedListHolder="${listTransactionTypes}"
			pagedLink="${pagedLink}" />
		<table class="tg">
			<tr>
				<th width="120"><spring:message code="transaction.type.name" /></th>
				<th width="120"><spring:message code="transaction.type.symbol" /></th>
				<th width="60"><spring:message code="global.edit" /></th>
				<th width="60"><spring:message code="global.delete" /></th>
			</tr>
			<c:forEach items="${listTransactionTypes.pageList}" var="transactionType">
				<tr>
					<td>${transactionType.name}</td>
					<td>${transactionType.symbol}</td>
					<td align="center"><a
						href="<c:url value='transaction-type/edit/${transactionType.id}' />"><img
							src="resources/icons/edit.png"
							alt=<spring:message
								code="global.edit" />></a></td>
					<td align="center"><a
						href="<c:url value='transaction-type/remove/${transactionType.id}' />"><img
							src="resources/icons/delete.png"
							alt=<spring:message
								code="global.delete" />></a></td>
				</tr>
			</c:forEach>
		</table>
		<tg:paging pagedListHolder="${listTransactionTypes}"
			pagedLink="${pagedLink}" />
		<br />
		<form:form action="transaction-type/add" modelAttribute="transactionType">
			<input type="submit" name="addTransactionType"
				value="<spring:message code="global.add"/>" />
		</form:form>
	</div>
</body>
</html>
