<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>	
	<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
	<style>
		<%@ include file = "login.css" %>
	</style>
</head>
<body>
<<<<<<< HEAD
	<form method='Post' action='logincomm.do'>
		ID:<input type="text" name="id" required>
		Password:<input type="text" name="pass" required>
=======
	<header>
        <div>
            <h1 class="logo"><a href="#">ECBook</a></h1>
        </div>
    </header>
	<form class="box" method='Post' action='/ecbook/logincomm'>
		<h1>Login</h1>
		<input type="text" name="id" required>
		<input type="password" name="pass" required>
>>>>>>> 2888e4abe9250cace41963a23b8f7e12c1b066e3
		<input type="submit" value="Send....">
		<a id="regist" href="registcall">ユーザー登録</a>
	</form>
</body>
</html> 