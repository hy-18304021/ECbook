<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
</head>
<body>
	<form method='Post' action='/ecbook${requestScope.target}'>
		ID:<input type="text" name="id">
		Password:<input type="text" name="password">
		<input type="submit" value="Send....">
	</form>	
</body>
</html>