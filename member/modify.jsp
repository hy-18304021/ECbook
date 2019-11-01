<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="/css/style.css"/>
<script src="/js/jquery-1.11.0.min.js"></script>

<c:if test="${empty sessionScope.id}">
  <meta http-equiv="Refresh" content="0;url=/index.do">
</c:if>

<div id="mStatus">
   <form id="uForm" method="post" action="/modifyForm.do">
    <ul>
        <li><label for="passwd">パスワード</label>
            <input id="passwd" name="passwd" type="password" 
              size="20" placeholder="6~16数字と文字" maxlength="16">
            <input id="id" name="id" type="hidden" value="${sessionScope.id}">
            <input type="submit" id="modify" value="情報修正">
     </ul>
   </form>
  
   <form id="dForm" method="post" action="/deletePro.do">
    <ul>
        <li><label for="passwd">비밀번호</label>
            <input id="passwd" name="passwd" type="password" 
              size="20" placeholder="6~16数字と文字" maxlength="16">
            <input id="id" name="id" type="hidden" value="${sessionScope.id}">
            <input type="submit" id="delete" value="削除">
            <small class="cau">[削除]ボタンを押すと削除されます。</small>
     </ul>
  </form>
  
  <button id="shopMain" 
  onclick="window.location.href('/index.do')">メイン</button>
</div>
