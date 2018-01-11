<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
.formtable {
	padding:10px;
	border: 1px solid blue;
}

input[type=text] {
	width: 200px;
}

textarea {
	width: 200px;
	height: 150px;
}

.label {
	text-align: right;
	vertical-align: top;
}

</style>

</head>
<body>
	<form name="input"
		action="${pageContext.request.contextPath}/docreate" method="post">

		<table  class="formtable">

			<tbody>
				<tr>
					<td class="label">Name:</td>
					<td><input type="text" name="name" /></td>
				</tr>

				<tr>
					<td class="label">Email:</td>
					<td><input type="text" name="email" /></td>
				</tr>

				<tr>
					<td class="label">Text:</td>
					<td><textarea name="text" rows="10" cols="10"></textarea></td>
				</tr>

			</tbody>

		</table>
		<input type="submit" value="Submit">
	</form>
</body>
</html>