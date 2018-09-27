<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Cost Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a cost
</h1>

<c:url var="addAction" value="/cost/add" ></c:url>

<form:form action="${addAction}" modelAttribute="cost">
<table>
	<c:if test="${!empty cost.description}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="description">
				<spring:message text="Description"/>
			</form:label>
		</td>
		<td>
			<form:input path="description" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="amount">
				<spring:message text="Amount"/>
			</form:label>
		</td>
		<td>
			<form:input path="amount" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="price">
				<spring:message text="Price"/>
			</form:label>
		</td>
		<td>
			<form:input path="price" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty cost.description}">
				<input type="submit"
					value="<spring:message text="Edit cost"/>" />
			</c:if>
			<c:if test="${empty cost.description}">
				<input type="submit"
					value="<spring:message text="Add cost"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Cost List</h3>
<c:if test="${!empty listCosts}">
	<table class="tg">
	<tr>
		<th width="80">Cost ID</th>
		<th width="120"><spring:message code="costs.description" /></th>
		<th width="120">Ilosc</th>
		<th width="120">Cena</th>
		<th width="60">Edytuj</th>
		<th width="60">Usun</th>
	</tr>
	<c:forEach items="${listCosts}" var="cost">
		<tr>
			<td>${cost.id}</td>
			<td>${cost.description}</td>
			<td>${cost.amount}</td>
			<td>${cost.price}</td>
			<td><a href="<c:url value='/edit/${cost.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${cost.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
