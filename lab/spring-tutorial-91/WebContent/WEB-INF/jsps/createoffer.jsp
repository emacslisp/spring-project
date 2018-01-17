<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/main.css">

</head>
<body>

	<!-- 
don't use commandName for new version of spring, use modelAttribute
public void setCommandName(String commandName) {
    this.modelAttribute = commandName;
} -->
	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		modelAttribute="offer">

		<table class="formtable">

			<tbody>
				<tr>
					<td class="label">Name:</td>
					<td><sf:input type="text" name="name" path="name" /><br/><sf:errors path="name" cssClass="error"></sf:errors></td>
				</tr>

				<tr>
					<td class="label">Email:</td>
					<td><sf:input type="text" name="email" path="email" /><br/><sf:errors path="email" cssClass="error"></sf:errors></td>
				</tr>

				<tr>
					<td class="label">Text:</td>
					<td><sf:textarea name="text" path="text" rows="10" cols="10"></sf:textarea><br/><sf:errors path="text" cssClass="error"></sf:errors></td>
				</tr>

			</tbody>

		</table>
		<input type="submit" value="Submit">
	</sf:form>
</body>
</html>