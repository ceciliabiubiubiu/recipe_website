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
<form action="/elec5619/user/personalinformation" method="post" enctype="multipart/form-data">
	<div class="row">
			<div class="col-xs-4">tips:<input type="text" name="tips"/>
		dish image: <input type="file" name="dish_img" id="dishimg"/>
		</div>
	     	</div>
	     
	
	<input type="submit" value="submit"/>
	</form>
</body>
</html>