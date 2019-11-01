<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="css/style.css"/>
<script src="js/jquery-1.11.0.min.js"></script>
<script src="member/register.js"></script>

<div id="regForm" class="box">
   <ul>
      <li><label for="id">ID</label>
          <input id="id" name="id" type="email" size="20" 
           maxlength="50" placeholder="example@kings.com" autofocus>
          <button id="checkId">重複確認</button>
      <li><label for="passwd">パスワード</label>
          <input id="passwd" name="passwd" type="password" 
           size="20" placeholder="6~16자 숫자/문자" maxlength="16">
      <li><label for="repass">パスワード再入力</label>
          <input id="repass" name="repass" type="password" 
           size="20" placeholder="パスワード再入力" maxlength="16">
      <li><label for="name">名前</label>
          <input id="name" name="name" type="text" 
           size="20" placeholder="名無し" maxlength="10">
      <li><label for="tel">電話番号</label>
          <input id="tel" name="tel" type="tel" 
           size="20" placeholder="電話番号入力" maxlength="20">
      <li class="label2"><button id="process">会員登録</button>
          <button id="cancle">キャンセル</button>
   </ul>
</div>