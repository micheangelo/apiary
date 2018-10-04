<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<html xmlns:th="http://www.thymeleaf.org">
  <head th:include="layout :: head(title=~{::title},links=~{})">
    <title>Please Login</title>
  </head>
  <body th:include="layout :: body" th:with="content=~{::content}">
    <div th:fragment="content">
        <form name="f" th:action="@{/login}" method="post">               
            <fieldset>
                <legend>Zaloguj się</legend>
                <div th:if="${param.error}" class="alert alert-error">    
                   Nieprawidłowy użytkownik i hasło
                </div>
                <div th:if="${param.logout}" class="alert alert-success"> 
                    Wylogowano
                </div>
                <label for="username">Użytkownik:</label>
                <input type="text" id="username" name="username"/>        
                <label for="password">Hasło:</label>
                <input type="password" id="password" name="password"/>    
                <div class="form-actions">
                    <button type="submit" class="btn">Zaloguj</button>
                </div>
            </fieldset>
        </form>
    </div>
  </body>
</html>