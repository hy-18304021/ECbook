<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<script src="http://code.jquery.com/jquery-1.11.0.js"></script>

</head>
<body>
	<form method='Post' action='logincomm.do'>
		ID:<input type="text" name="id" required>
		Password:<input type="text" name="pass" required>
		<input type="submit" value="Send....">
	</form>
	<a id="regist" href="registcall">ユーザー登録</a>
</body>
</html> 



