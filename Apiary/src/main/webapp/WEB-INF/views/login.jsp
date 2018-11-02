<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
%>
<html xmlns:th="http://www.thymeleaf.org">
<head th:include="layout :: head(title=~{::title},links=~{})">
<title>Please Login</title>
<style>
.outer-div
{
     padding: 30px;
}
.inner-div
{
     margin: auto;
     width: 100px;
     height: 100px;  
}
</style>
</head>
<body th:include="layout :: body" th:with="content=~{::content}">
	<div class="outer-div">
	<div class="inner-div" th:fragment="content" th:align="center">
		<form name="f" th:action="@{/login}" method="post">
			<fieldset>
				<legend>Zaloguj się</legend>
				<label for="username">Użytkownik:</label> <input type="text"
					id="username" name="username" /> <label for="password">Hasło:</label>
				<input type="password" id="password" name="password" />
				<div class="form-actions">
					<button type="submit" class="btn">Zaloguj</button>
				</div>
				<br />

				<c:if test="${param.error != null}">
					<div>
						<p>Nieprawidłowe dane logowania.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div>
						<p>Wylogowano z systemu</p>
					</div>
				</c:if>
			</fieldset>
		</form>
	</div>
	</div>
</body>
</html>