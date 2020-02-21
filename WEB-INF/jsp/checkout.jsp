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
              document.getElementById("fname").style.display='none';
              document.getElementById("tel").style.display='none';
              document.getElementById("postalcode").style.display='none';
              document.getElementById("adr").style.display='none';
              document.getElementById("tella").style.display='none';
              document.getElementById("fnamela").style.display='none';
              document.getElementById("adrla").style.display='none';
              document.getElementById("postalcodela").style.display='none';
              document.getElementById("select").style.display='none';
            }else{
              document.getElementById("reselect").style.display='none';
              document.getElementsByClassName("address").style='display:none;';
            }
        });
    </script>
    <title>checkout</title>
</head>
<body>
    <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
    <h1 style="display:none;" id="selectaddress">${sessionScope.address}</h1>
    <div id="app">
    
   
<h2>注文情報入力</h2>

<div class="row">

  <div class="col-75">

    <div class="container">


        <div class="row">

          <div class="col-50">
            <h3>送り先情報</h3>
            <label for="fname" id="fnamela"><i class="fa fa-user"></i> 名前</label>
            <input type="text" id="fname" name="firstname" placeholder="name" oninput="valueinName(this)">
            <label for="postalcode" id="postalcodela"><i class="fa fa-institution"></i> 郵便番号</label>
            <input type="text" id="postalcode" name="postalcode" placeholder="postal code" oninput="valueinPostalcode(this)">
             <label for="adr" id="adrla"><i class="fa fa-address-card-o"></i> 住所</label>
            <input type="text" id="adr" name="address" placeholder="address" oninput="valueinAddress(this)">
            <label for="tel" id="tella"><i class="fa fa-institution"></i> 電話番号</label>
            <input type="text" id="tel" name="tel" placeholder="tel" oninput="valueinTel(this)">
            <c:forEach var="address" items="${result}" varStatus="starts">
              <div class="addresslist">
                <label onclick="registeddata(${starts.index})">
                  <input type="radio" class="address" name="address">
                  <div>
                    Full Name:${address.receiver_name}<br>
                    Postal code:${address.postal_code}<br>
                    Address:${address.address}<br>
                    tel:${address.tel}</div>
                  </label>
              </div>
              <input type="hidden" class="address_id" value="${address.address_id}">
              <input type="hidden" class="btn" value="1">
              <input type="hidden" class="receiver_name" value="${address.receiver_name}">
              <input type="hidden" class="postalcode" value="${address.postal_code}">
              <input type="hidden" class="adr" value="${address.address}">
              <input type="hidden" class="tel" value="${address.tel}">
            </c:forEach>

              <form action="removeselectaddress.do" method="post" accept-charset="utf-8">
                <input type="submit" id="reselect" value="readdress" class="selectaddress">
              </form>

              <form action="selectaddress.do" method="post" accept-charset="utf-8">
                <input type="hidden" name="user_id" value="${sessionScope.user.id}">
                <input type="submit" id="select" value="address" class="selectaddress">
              </form>
          </div>

          <div class="col-50">
            <h3>カード情報</h3>
           
            <label for="cname">カード名義人（半角ローマ字)</label>
            <input type="text" id="cname" name="cardname" placeholder="name" oninput="valueinCardname(this)">
            <label for="ccnum">カード番号</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444" oninput="valueinCardNumber(this)">
            <label for="expmonth">有効期限(月)</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="12" oninput="valueinExpmonth(this)">
            <div class="row">
              <div class="col-50">
                <label for="expyear">有効期限(年)</label>
                <input type="text" id="expyear" name="expyear" placeholder="2020" oninput="valueinExpyrar(this)">
              </div>
              <div class="col-50">
                <label for="cvv">CVV番号</label>
                <input type="text" id="cvv" name="cvv" placeholder="123" oninput="valueinCvv(this)">
              </div>
            </div>
          </div>
        </div>

        <div>
          <form action="buycartbook.do" method="post" accept-charset="utf-8">
            <input type="hidden" id="bbtn" name="btn" value="0">
            <input type="hidden" id="buser_id" name="user_id" value="${sessionScope.user.id}">
            <input type="hidden" id="bname" name="firstname">
            <input type="hidden" id="baddress_id" name="address_id">
            <input type="hidden" id="bpostalcode" name="postalcode">
            <input type="hidden" id="badr" name="address">
            <input type="hidden" id="btel" name="tel">
            <input type="hidden" id="bcname" name="cardname">
            <input type="hidden" id="bccnum" name="cardnumber">
            <input type="hidden" id="bexpmonth" name="expmonth"> 
            <input type="hidden" id="bexpyear" name="expyear">
            <input type="hidden" id="bcvv" name="cvv">
            <input type="submit" value="注文確定" class="btn">
          </form>
        </div>

    </div>
  </div>

  <div class="col-25">
    <div class="container">
      <h4>Cart <span class="price" style="color:black">
        <i class="fa fa-shopping-cart"></i></span></h4>
        <c:forEach var="cart" items="${sessionScope.mycart}">
          <c:set var="totalPrice" value="${totalPrice + cart.book_price*cart.cart_amount}" />
          <p>${cart.book_name} <br><span class="price">${cart.book_price*cart.cart_amount}円</span></p>
          <br>
          <hr>
          </c:forEach>
          <p>Total <span class="price" style="color:black"><b>${totalPrice}円</b></span></p>
    </div>
  </div>
</div>

</body>
</html>
