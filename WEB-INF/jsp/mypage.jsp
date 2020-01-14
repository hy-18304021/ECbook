<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <!DOCTYPE html>
   <html lang="en">
   <head>
   	<meta charset="UTF-8">
   	<title>Login result</title>
    <script src="../../js/ajaxtest.js"></script>
   </head>
   <body>
      <ul>
          <input type="submit" value="注文履歴">
          <input type="submit" value="お届け住所変更">
      </ul>
   	<h1>Login result: ${sessionScope.result}</h1>

   	
   	
       <h1>Login as: ${sessionScope.user.id}</h1>
       ${sessionScope.user.pass}
       <br>${sessionScope.user.name}
       <br>${sessionScope.user.mail}
       <br>${sessionScope.user.sex}
       <br>${sessionScope.user.birth}
      <button onclick="appearUpdateForm()">修正</button>


       <div id="update" style="display:none;">
        <ul>
          <li>
            Name:<input type="text" name="name" id="name">
          </li>
          <li>
            Pass:<input type="text" name="pass" id="pass">
          </li>
          <li>
            Mail:<input type="text" name="mail" id="mail">
          </li>
          <li>
            Sex:
            <input type="radio" name="sex" value="1" id="sex"checked>Male
            <input type="radio" name="sex" value="2" id="sex">Female
          </li>
          <li>
            Birth:<input type="date" name="birth" id="birth">
          </li>
        </ul>
         <button onclick="updateUserData()">情報修正</button>
         <button type="button" onclick="disappear()">閉じる</button>
       </div>
       <div id="result">
         
       </div>
       <h1><a href="/ecbook/logoutservlet">ログアウト</a></h1>
       
   </body>
   </html>