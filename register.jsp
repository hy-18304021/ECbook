<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>register</title>
</head>
<body>
	<form action="loginservlet" method="get">
        ID:<input type="text" name="id">
        Name:<input type="text" name="name">
        Password:<input type="text" name="pass">
        Tel:<input type="text" name="tel">
        Mail:<input type="text" name="mail">
       <p>
        Sex:<input type="radio" value="男"name="sex">
        <input type="radio" value="女" name="sex">
    </p>
        birth:<input type="text" name="birth">
        
		<input type="submit" value="Send....">
	</form>	
</body>
</html>