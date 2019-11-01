<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="/css/style.css"/>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/member/modify.js"></script>

<c:if test="${empty sessionScope.id}">
  <meta http-equiv="Refresh" content="0;url=/index.do">
</c:if>

<div id="regForm" class="box">
   <ul>
      <li><p class="center">会員情報修正
      <li><label for="id">ID</label>
          <input id="id" name="id" type="email" size="20" 
           maxlength="50" value="${id}" readonly disabled>
      <li><label for="passwd">パスワード</label>
          <input id="passwd" name="passwd" type="password" 
           size="20" placeholder="6~16数字と文字" maxlength="16">
           <small class="cau">必ず入力してください。</small>
      <li><label for="name">名前</label>
          <input id="name" name="name" type="text" 
           size="20" maxlength="10" value="${m.getName()}">
      <li><label for="tel">電話番号</label>
          <input id="tel" name="tel" type="tel" 
           size="20" maxlength="20" value="${m.getTel()}">
      <li class="label2"><button id="modifyProcess">修正</button>
          <button id="cancle">キャンセル</button>
   </ul>
</div>