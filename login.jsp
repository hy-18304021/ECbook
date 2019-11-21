<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
	<script>
	var status = true;
		$(document).ready(function(){
    		$("#regist").click(function(){
     	   	window.location.href='regist';
    		});
		});
	</script>

</head>
<body>
	<form method='Post' action='loginservlet'>
		ID:<input type="text" name="id" required>
		Password:<input type="text" name="pass" required>
		<!-- <button id="regist">regist</button> -->
		<input type="submit" value="Send....">
	</form>	
</body>
</html> 



