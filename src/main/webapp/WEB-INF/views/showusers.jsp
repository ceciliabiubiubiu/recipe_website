<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title></head>
<body>
<h1>
<c:forEach items="${model.users }" var="auser">
	${auser.userName}
</c:forEach>
</h1>
<form action="/elec5619Springapp/addrecipe" method="post">
	
	<table>
		<tr>
			<td>recipeName:</td>
			<td><input type="text" name="recipeName"/></td>
		</tr>
		<tr>
			<td>cookTime:</td>
			<td><input type="text" name="cookTime"/></td>
		</tr>
		<tr>
			<td>servepeopleno:</td>
			<td><input type="text" name="servepeopleno"/></td>
		</tr>
		<tr>
			<td>tips:</td>
			<td><input type="text" name="tips"/></td>
		</tr>
		<tr>
			<td>userID:</td>
			<td><input type="text" name="userID"/></td>
		</tr>
		<tr>
			<td>dishImg:</td>
			<td><input type="text" name="dishImg"/></td>
		</tr>
	</table>
	<input type="submit" value="submit"/>
	</form>
</body>
</html>