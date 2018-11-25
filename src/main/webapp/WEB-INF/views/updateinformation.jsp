<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
<style type="text/css">@import url("<c:url value='/resources/css/recipepage.css'/>");</style>
<style>
#dishimgbox{
text-align:center;
}
</style> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">



</script>
</head>
<body>
<div class="topbar">111</div>
<form action="/elec5619/user/updateinformation" method="post" enctype="multipart/form-data">
	<div class="row">
		<div class="col-xs-8" id="ingredientsdiv">
			<table id="ingredientsbox">
				<tr>
					<th>user name:</th>
					<th>email:</th>
					<th>password:</th>
				</tr>
				<tr>
					<td><input type="hidden" name="userid" value="${model.user.id }"/><input type="text" name="userName" value="${model.user.name}"></td>
					<td><input type="text" name="email" value="${model.user.email}"></td>
					<td><input type="text" name="password" value="${model.user.password}"></td>
				</tr>
	        </table>
	     	</div>
	     	</div>
	
	<input type="submit" value="submit"/>
	</form>
</body>
</html>