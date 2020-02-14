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
     <script type="text/javascript" src="js/checkout.js"></script>
     <script>
        $(document).ready(function(){
            //var flag=document.getElementById("flag").innerText;
            //if(flag=="OK"){
                //document.getElementById("loginli").style.display='none';
            //}else{
            //     document.getElementById("logoutli").style.display='none';
            //     document.getElementById("mypage").style.display='none';
            //     document.getElementById("mycart").style.display='none';
            //     document.getElementById("writereviewwithajax").style.display='none';
            // }

            var address=document.getElementById("selectaddress").innerText;
            console.log(address);
            if(address=="adr"){
              document.getElementById("city").style.display='none';
              document.getElementById("adr").style.display='none';
              document.getElementById("cityla").style.display='none';
              document.getElementById("adrla").style.display='none';
              document.getElementById("select").style.display='none';
            }else{
              document.getElementById("address").style.display='none';
              document.getElementById("reselect").style.display='none';
            }
        });
    </script>
    <title>checkout</title>
</head>
<body>
    <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
    <h1 style="display:none;" id="selectaddress">${sessionScope.address}</h1>
    <div id="app">
    
   
<h2>Responsive Checkout Form</h2>

<div class="row">

  <div class="col-75">

    <div class="container">


        <div class="row">

          <div class="col-50">
            <h3>Billing Address</h3>
            <label for="fname"><i class="fa fa-user"></i> Full Name</label>
            <input type="text" id="fname" name="firstname"
                   placeholder="name">
            <label for="email"><i class="fa fa-envelope"></i> Email</label>
            <input type="text" id="email" name="email" placeholder="
​                   ​​email">
             <label for="adr" id="adrla"><i class="fa fa-address-card-o"></i> Address</label>
            <input type="text" id="adr" name="address" placeholder="
                   address">
            <label for="city" id="cityla"><i class="fa fa-institution"></i> City</label>
            <input type="text" id="city" name="city" placeholder="city">
            <a id="address">aaa</a><br>
            <c:forEach var="aaddress" items="${sessionScope.myaddress}">
              <input type="radio" id="address" name="address" value="${address.postal_code+address.address+address.tel}">
            </c:forEach>
            checkbox Address
              <form action="selectaddress.do" method="post" accept-charset="utf-8">
                <input type="hidden" name="user_id" value="${sessionScope.user.id}">
                <input type="submit" id="select" value="address" class="selectaddress">
              </from>

              <form action="removeselectaddress.do" method="post" accept-charset="utf-8">
                <input type="submit" id="reselect" value="readdress" class="selectaddress">
              </from>

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

    </div>
  </div>
  <div class="col-25">
    <div class="container">
      <h4>Cart <span class="price" style="color:black">
        <i class="fa fa-shopping-cart"></i></span></h4>
        <c:forEach var="cart" items="${sessionScope.mycart}">
          <c:set var="totalPrice" value="${totalPrice + cart.book_price*cart.cart_amount}" />
          <p>${cart.book_name} <br><span class="price">${cart.book_price*cart.cart_amount}円</span></p>
          <hr>
          </c:forEach>
          <p>Total <span class="price" style="color:black"><b>${totalPrice}円</b></span></p>
    </div>
  </div>
</div>

</body>
</html>
