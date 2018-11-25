<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title>
<style type="text/css">@import url("<c:url value='/resources/css/recipepage.css'/>");</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">

function submitvalification(){
	var password=$('#password').val();
	var cpassword=$('#cpassword').val();
	if(password!=cpassword){
		alert("password is different!")
		return false;
	}	
	return true;
}

</script>
</head>
<body>
<div class="topbar">
	<h3>register here</h3>
	<a href="https://www.baidu.com/">Back to homepage</a>
</div>

<form action="/elec5619/user/adduser" method="post" enctype="multipart/form-data" onsubmit="return submitvalification()">
	<div class="row">
		<div class="col-xs-8" id="register">
			<table id="register">
				<tr>
					<th>user name:</th>
					<th>email:</th>
					<th>password:</th>
					<th>cpassword:</th>
				</tr>
				<tr>
					<td><input type="text" name="userName" id="name"></td>
					<td><input type="text" name="email" id="email"></td>
					<td><input type="text" name="password" id="password"></td>
					<td><input type="text" name="comfirm password" id="cpassword"></td>
				</tr>
	        </table>
	     	</div>
	     	</div>
	
	<input type="submit" value="submit"/>
	</form>
</body>
</html>