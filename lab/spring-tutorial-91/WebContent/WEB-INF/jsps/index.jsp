<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Hi this is a test page!!!!

Session: <%= session.getAttribute("name")  %> <br/>

Request: <%= request.getAttribute("name") %> <br/>

Request (using EL): ${name} <br/>

<!--<c:out value="${name}"></c:out> <p/>

<sql:query var="rs" dataSource="jndi/spring">
select name, email, text from offers
</sql:query>-->

<c:forEach var="row" items="${offers}">
	<p><c:out value="${row}"></c:out> </p>
</c:forEach>

<p><a href="${pageContext.request.contextPath}/offers">offers</a></p>
<p><a href="${pageContext.request.contextPath}/createoffer">create offer</a></p>

</body>
</html>