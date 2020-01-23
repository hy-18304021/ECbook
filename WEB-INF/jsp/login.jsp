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
	<header>
        <div>
            <h1 class="logo"><a href="#">ECBook</a></h1>
        </div>
    </header>
	<form class="box" method='Post' action='/ecbook/logincomm.do'>
		<h1>Login</h1>
		<input type="text" name="id" required>
		<input type="password" name="pass" required>
		<input type="submit" value="Send....">
		<a id="regist" href="registcall.do"><button>ユーザー登録</button></a>
	</form>
</body>
</html> 