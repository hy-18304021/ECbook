<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <title>My Cart</title>
<link rel="stylesheet" type="text/css" href="css/cart.css">
<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/cart.js"></script>
<script>
    $(document).ready(function(){
        var flag=document.getElementById("flag").innerText;
        if(flag=="OK"){
            document.getElementById("loginli").style.display='none';
        }else{
            document.getElementById("logoutli").style.display='none';
            document.getElementById("mypage").style.display='none';
            document.getElementById("mycart").style.display='none';
        }
    })
    
</script>
</head>
<body>
  <h1 style="display:none;" id="flag">${sessionScope.flag}</h1> 
<header>
  <div>
      <h1 class="logo"><a href="#">ECBook</a></h1>
      <ul class="gnd">
          <li id="mypage"><a href="mypage.do">マイページ</a></li>
          <li id="loginli"><a href="logincall.do">ログイン</a></li>
          <li id="logoutli"><a href="logout.do">ログアウト</a></li>
          <li id="mycart"><a href="mycart.do">カート</a></li>
      </ul>
  </div>
</header>
<header1 id="site-header">
  <div class="container">
    <h1>${sessionScope.user.id}様のカート</h1>
  </div>
</header1>

<div class="container">

  <c:forEach var="cart" items="${sessionScope.mycart}">
  <section id="cart"> 
    <article class="product">
      <header>
        <a class="remove">
          <img src="bookimage/${cart.book_isbn}" alt="">

          <h3>
            <form action="deletebookfromusercart.do" method="post" accept-charset="utf-8">
              <input type="hidden" name="user_id" value="${sessionScope.user.id}">
              <input type="hidden" name="book_isbn" value="${cart.book_isbn}">
              <input type="submit" value="Remove">
          </form>
          </h3>
        </a>
      </header>

      <div class="content">

        <h1>${cart.book_name}</h1>
        ${cart.book_name}
      </div>

      <form action="updateusercart.do" method="post" accept-charset="utf-8">
        <footer class="content">
          <span class="qt-minus">-</span>
          <span class="qt">${cart.cart_amount}</span>
          <span class="qt-plus">+</span>
          <input type="hidden" name="user_id" value="${sessionScope.user.id}">
          <input type="hidden" name="book_isbn" value="${cart.book_isbn}">
          <input type="hidden" name="cart_amount" class="cart_amount" value="${cart.cart_amount}">
          <input type="submit" value="修正" style="position: absolute; margin-top: 15px; background-color: #c66; color:#fff; font-size: 12px; border:none; border-radius: 3px;">
        

          <h2 class="full-price">
            <!-- 合計金額 -->
            ${cart.book_price*cart.cart_amount}円
          </h2>
          <!-- 1個の金額 -->
          <h2 class="price">
            ${cart.book_price}
          </h2>
        </footer>
      </form>
    </article>

   
  </section>
</c:forEach>
</div>

<footer id="site-footer">
  <div class="container clearfix">
    <div class="right">
      <h1 class="total">Total: <span></span>円</h1>
      <a class="btn">Checkout</a>
    </div>

  </div>
</footer>
</body>
</html>
