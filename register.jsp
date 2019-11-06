<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>register</title>
</head>
<body>
    <h1>会員登録</h1>
    <ul>
	<form action="loginservlet" method="get">
    <li>ID:<input type="text" name="id">
    <li>Name:<input type="text" name="name">
    <li>  Password:<input type="text" name="pass">
    <li>    Tel:<input type="text" name="tel">
    <li>Mail:<input type="text" name="mail">
    <li>
        Sex:
        男<input type="radio" value="男"name="sex">
        女<input type="radio" value="女" name="sex">
    
    <li>birth:<input type="text" name="birth">
        
        <input type="submit" value="Send....">
        
    </form>	
</ul>
</body>
</html>