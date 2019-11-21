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

   	
   	<h1><a href="/ecbook/logoutservlet">ログアウト</a></h1>
       <h1>Login as: ${sessionScope.user.id}</h1>
       ${sessionScope.user.pass}
       <br>${sessionScope.user.name}
       <br>${sessionScope.user.mail}
       <br>${sessionScope.user.sex}
       <br>${sessionScope.user.birth}
       <button>情報修正</button>
   </body>
   </html>