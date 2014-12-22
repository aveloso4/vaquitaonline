<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

<h1>Login Personalizado :D</h1>
<div id="login-error">${msg}</div>
<form th:action="@{/j_spring_security_check}" method="post" >
<input type="hidden" name="_csrf" th:value="${_csrf.token}"></input>
<p><label for="username">Username:</label><input id="username" name="username" type="text" /></p>
<p><label for="password">Password:</label><input id="password" name="password" type="password" /></p>
<input  type="submit" value="Login"/>
</form>

<h2>Buscar Viaje</h2>
<form th:action="@{j_spring_security_check}" method="post" >
<p><label for="Desde">Desde:</label><input id="desde" name="desde" type="text" /></p>
<p><label for="Hasta">Hasta:</label><input id="Hasta" name="Hasta" type="Text" /></p>
<input  type="submit" value="search"/>
</form>
</body>
</html>