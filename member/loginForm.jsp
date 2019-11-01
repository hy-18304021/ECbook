<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="/css/style.css"/>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/member/login.js"></script>

<c:if test="${empty sessionScope.id}">
  <div id="lStatus">
     <ul>
        <li><label for="cid">ID</label>
            <input id="cid" name="cid" type="email" size="20" 
              maxlength="50" placeholder="example@kings.com">
            <label for="cpasswd">パスワード</label>
            <input id="cpasswd" name="cpasswd" type="password" 
              size="20" placeholder="6~16数字と文字" maxlength="16">
            <button id="uLogin">ログイン</button>
            <button id="uRes">会員登録</button>
     </ul>
  </div>
</c:if>
<c:if test="${!empty sessionScope.id}">
  <div id="lStatus">
     <ul>
        <li>${sessionScope.id}様がログインしました。
           <div id="info">
             <table>
               <tr height="10">
                 <td><button id="uLogout">ログアウト</button></td>
                 <td><button id="uUpdate">会員情報変更</button></td>
                 <td><form id="cartForm" method="post" action="/cartList.do">
                   <input type="hidden" name="buyer" value="${sessionScope.id}">
                   <input type="submit" name="cart" value="カート"></form></td>
                 <td><form id="buyForm" method="post" action="l/buyList.do">
                   <input type="hidden" name="buyer" value="${sessionScope.id}">
                   <input type="submit" name="buy" value="購入目録"></form></td>
                 </tr>
             </table>
        </div>     
            
     </ul>
  </div>
</c:if> 