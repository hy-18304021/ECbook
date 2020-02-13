<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
     <link rel="stylesheet" type="text/css" href="css/checkout.css">
     <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
     <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
     <script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
     <script type="text/javascript" src="js/ajax.js"></script>
     <script>
        $(document).ready(function(){
            var flag=document.getElementById("flag").innerText;
            if(flag=="OK"){
                document.getElementById("loginli").style.display='none';
            }else{
                document.getElementById("logoutli").style.display='none';
                document.getElementById("mypage").style.display='none';
                document.getElementById("mycart").style.display='none';
                document.getElementById("writereviewwithajax").style.display='none';
            }
        })
    </script>
    <title>checkout</title>
</head>
<body>
    <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
    <div id="app">
        <header class="page-element">
            <div>
           <h1>
              <img class="big-logo" src="http://ws2019.taipaweb.com/css-final-project/logo.png" alt="Logo">
              <span class="big-logo-text">EbBook</span>
           </h1>
           <div class="book-finder">
              <ul class="book-type-list">
                <li id="booklistli"><a href="getbooktable.do">BookList</a></li>
                <li id="mypage"><a href="mypage.do">MyPage</a></li>
                <li id="loginli"><a href="logincall.do">Login</a></li>
                <li id="logoutli"><a href="logout.do">Logout</a></li>
                <li id="mycart"><a href="mycart.do">Cart</a></li>
              </ul>
              <form class="book-search" action="searchbook.do" method="post">
                <input type="text" name="book_name">
                <input type="submit" value="Search">
             </form>
           </div>
          
        </div>
    </header>
    
   
<h2>Responsive Checkout Form</h2>

<div class="row">

  <div class="col-75">

    <div class="container">

      <form action="/action_page.php">

      

        <div class="row">

          <div class="col-50">
            <h3>Billing Address</h3>
            <label for="fname"><i class="fa fa-user"></i> Full Name</label>
            <input type="text" id="fname" name="firstname"
                   placeholder="name">
            <label for="email"><i class="fa fa-envelope"></i> Email</label>
            <input type="text" id="email" name="email" placeholder="
​                   ​​email">
             <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
            <!--<input type="text" id="adr" name="address" placeholder="
                   address">
            <label for="city"><i class="fa fa-institution"></i> City</label>
            <input type="text" id="city" name="city" placeholder="city"> -->
            <!-- checkbox Address -->
            <input type="submit" value="address" class="">

           
          </div>

          <div class="col-50">
            <h3>Payment</h3>
           
            <label for="cname">Name on Card</label>
            <input type="text" id="cname" name="cardname" 
                    placeholder="name">
            <label for="ccnum">Credit card number</label>
            <input type="text" id="ccnum" name="cardnumber" 
                  placeholder="1111-2222-3333-4444">
            <label for="expmonth">Exp Month</label>
            <input type="text" id="expmonth" name="expmonth" 
               placeholder="12">
            <div class="row">
              <div class="col-50">
                <label for="expyear">Exp Year</label>
                <input type="text" id="expyear" name="expyear" placeholder="2020">
              </div>
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="123">
              </div>
            </div>
          </div>
          
        </div>

        <input type="submit" value="Continue to checkout" class="btn">
      </form>
    </div>
  </div>
  <div class="col-25">
    <div class="container">
      <h4>Cart <span class="price" style="color:black">
      <i class="fa fa-shopping-cart"></i> <b>4</b></span></h4>
      <p><a href="#">1</a> <span class="price">1500</span></p>
      <p><a href="#">2</a> <span class="price">500</span></p>
      <p><a href="#">3</a> <span class="price">400</span></p>
      <p><a href="#">4</a> <span class="price">200</span></p>
      <hr>
      <p>Total <span class="price" style="color:black"><b>2600</b></span></p>
    </div>
  </div>
</div>

</body>
</html>
