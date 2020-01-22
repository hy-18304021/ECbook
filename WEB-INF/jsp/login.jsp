<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="login.css">
	<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
</head>
<body>
	<form method='Post' action='logincomm'>
		<h1>Login</h1>
		<input type="text" name="id" required>
		<input type="password" name="pass" required>
		<input type="submit" value="Send....">
		<a id="regist" href="registcall">ユーザー登録</a>
	</form>
</body>
</html> 