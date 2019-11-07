<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
</head>
<body>
	<form method='Post' action='loginservlet'>
		ID:<input type="text" name="id" required>
		Password:<input type="text" name="pass" required>
		<input type="submit" value="Send....">
	</form>	
</body>
</html>