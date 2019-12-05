<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Registation Result</title>
</head>
<body>
	<ul>
		<input type="submit" type="注文履歴">
		<input type="submit" type="お届け住所変更">
	</ul>
	${result}
	<br>登録した情報
	<ul>
		<li>${sessionScope.user.id}</li>
		<li>${sessionScope.user.name}</li>
		<li>${sessionScope.user.pass}</li>
		<li>${sessionScope.user.tel}</li>
		<li>${sessionScope.user.mail}</li>
		<li>${sessionScope.user.birth}</li>
	</ul>
</body>
</html>