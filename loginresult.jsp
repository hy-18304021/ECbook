<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <!DOCTYPE html>
   <html lang="en">
   <head>
   	<meta charset="UTF-8">
   	<title>Login result</title>
   </head>
   <body>
   	<h1>Login result: ${sessionScope.result}</h1>
   	<h1>Login as: ${sessionScope.user.id}</h1>
   	
   		<h1><a href="/ecbook/logoutservlet">ログアウト</a></h1>
   </body>
   </html>