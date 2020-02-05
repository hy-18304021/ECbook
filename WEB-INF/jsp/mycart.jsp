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
    <div style="padding: 0px 30px 30px 20px;">
    <h1>${sessionScope.user.id}様のカート</h1>
    <table>
        <tr>
          <th width="200px">ブックISBN</th>
          <th width="200px">title</th>
          <th width="200px">price</th>
          <th name="cart_amount">数</th>
        </tr>
        <c:forEach var="cart" items="${sessionScope.mycart}">
          <tr>
            <th>${cart.book_isbn}
                <br><img src="bookimage/${cart.book_isbn}" alt="">
            </th>
            <td>
                <!-- book_name -->
                
            </td>
            <td>
                <!-- price -->
            </td>

            <th width="250px">
                <form action="updateusercart.do" method="post" accept-charset="utf-8">
                    <input type="number" name="cart_amount" value="${cart.cart_amount}" min='1'>
                    <input type="hidden" name="user_id" value="${sessionScope.user.id}">
                    <input type="hidden" name="book_isbn" value="${cart.book_isbn}">
                    <input type="submit" value="修正">
                </form>
            </th>
            <td>
                <form action="deletebookfromusercart.do" method="post" accept-charset="utf-8">
                    <input type="hidden" name="user_id" value="${sessionScope.user.id}">
                    <input type="hidden" name="book_isbn" value="${cart.book_isbn}">
                    <input type="submit" value="削除">
                </form>
            </td>
          </tr>
        </c:forEach>
      </table b>
      <div id="result">
        
      </div> 


      <div class="totals">
        <div class="totals-item totals-item-total">
          <label>Total</label>
          <div class="totals-value" id="cart-total"></div>
        </div>
      </div>
          
    <button class="checkout">Checkout</button>
</div>
</body>
</html>