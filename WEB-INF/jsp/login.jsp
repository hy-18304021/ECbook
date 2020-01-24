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
	<div class="loginbox">
		<h1>Login</h1>
		<form class="box" method='Post' action='/ecbook/logincomm.do'>
		<p>Username</p>
		<input type="text" name="id" placeholder="Username" required>
		<p>Password</p>
		<input type="password" name="pass" placeholder="Password" required>
		<input type="submit" value="Login">
		<a id="regist" href="registcall.do">Don't have an account?</a>
	</form> 	
	</div>
</body>
</html> 