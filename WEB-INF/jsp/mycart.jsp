<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <title>My Cart</title>
<link rel="stylesheet" type="text/css" href="css/cart.css">
<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- <script type="text/javascript" src="js/ajax.js"></script> -->
<script type="text/javascript" src="js/cart.js"></script>
<script src="js/pageload.js" type="text/javascript" charset="utf-8" async defer></script>
</head>
<body>
<div class="wrapper">
  <h1 style="display:none;" id="flag">${sessionScope.flag}</h1> 
  <div id="app" style="background: #eee;">
    <header class="page-element" style="background: #fff;">
        <div>
          <a href="indexcall.do">
            <img src="img/logo.png" style="margin-top:8px; width:182px; height: 66px;">
        </a>
              
           <div class="book-finder">
              <ul class="book-type-list">
                <li id="mypage"><a href="mypage.do">MyPage</a></li>
                <li id="loginli"><a href="logincall.do">Login</a></li>
                <li id="logoutli"><a href="logout.do">Logout</a></li>
                <li id="mycart"><a href="mycart.do">Cart<div class='cartnumber'><center>${fn:length(sessionScope.mycart)}</center></div></a></li>
              </ul>
              <form class="book-search" action="searchbook.do" method="post">
                <input type="hidden" name="genre_id" value="0">
                 <input type="text" name="book_name">
                 <input type="submit" value="Search">
              </form>
           </div>

        </div>
    </header>
    <header1 id="site-header">
  <div class="container">
    <h1>${sessionScope.user.id}様のカート</h1>
    <div id="cart">
      
    </div>
  </div>
</header1>

<div class="container">
  <c:set var="totalPrice" value="${0}" />
  <c:forEach var="cart" items="${sessionScope.mycart}">
  <c:set var="totalPrice" value="${totalPrice + cart.book_price*cart.cart_amount}" />
  <section class="cart">
    <article class="product">
      <header>
        <a class="remove">
          <img src="https://cover.openbd.jp//${cart.book_isbn}.jpg" alt="">

          <h3 style="text-align: center;">
              <input type="hidden" class="user-id" value="${sessionScope.user.id}">
              <input type="hidden" class="book-isbn" value="${cart.book_isbn}">
              <input type="submit" value="Remove">
          </h3>
        </a>
      </header>

      <div class="content">

        <h1>${cart.book_name}</h1>
        ${cart.book_name}
      </div>

        <footer class="content">
          <span class="qt-minus">-</span>
          <span class="qt">${cart.cart_amount}</span>
          <span class="qt-plus">+</span>
          <input type="hidden" class="user-id" name="user_id" value="${sessionScope.user.id}">
          <input type="hidden" class="book-isbn" name="book_isbn" value="${cart.book_isbn}">
          <input type="hidden" name="cart_amount" class="cart_amount" value="${cart.cart_amount}">
          
          <!-- 合計金額 -->
          <h2 class="full-price">
            
            ${cart.book_price*cart.cart_amount}円
          </h2>
          <!-- 1個の金額 -->
          <h2 class="price">
            ${cart.book_price}円
          </h2>
        </footer>
    </article>
  </section>
</c:forEach>
</div>

<footer id="site-footer">
  <div class="container clearfix">
    <div class="right">
      <h1 class="total">Total: <span>${totalPrice}</span>円</h1>
      <form class="totalform" action="purchaseconfirmation.do" method="post" accept-charset="utf-8">
        <input type="hidden" name="user_id" value="${sessionScope.user.id}">
        <c:forEach var="cart" items="${sessionScope.mycart}">
            <input type="hidden" name="book_isbn" value="${cart.book_isbn}">
            <input type="hidden" class="totalamount" name="cart_amount" value="${cart.cart_amount}">
        </c:forEach>
        <input type="hidden" class="totalprice" name="fullprice" value="${totalPrice}">
        <input type="submit" value="購入確認" class="btn" id="checkout-button"></input>
        <br>
      </form>
      <button class="btn" onclick="location.href='getbooktable.do'">買物を続ける</button>
    </div>
  </div>
</footer>
</div><%-- wrapper --%>
</body>
</html>
