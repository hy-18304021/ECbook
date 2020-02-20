<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>main</title>
    <link rel="stylesheet" type="text/css" href="css/styletest.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="js/booklist.js"></script>
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
    <style>
        
    </style>

</head>
<body>
    <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
    <div id="app">
        <header class="page-element">
            <div>
                <h1>
                    Logo
                 </h1>
              
           <div class="book-finder">
              <ul class="book-type-list">
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
        <main>
            <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
            <div class="leftcolumn">
                <p style="font-weight: bold;">ジャンル</p>
                <p>ライトノベル</p>
                <p>少年コミック</p>
                <p>少女コミック</p>
            </div>
            <div class="container">
                <div class="row">
                    <c:forEach var="book" items="${result}">
                        <div class="col-md-3">

                            <div class="product-grid" style="margin-top: 10px;">
                                <div class="product-image">
                                    <a href="bookinfo.do?book_isbn=${book.book_isbn}">
                                        <img src="https://cover.openbd.jp//${book.book_isbn}.jpg" width="142" height="203" class="pic-1" alt="${book.book_name}">
                                    </a>
                                    <span class="product-discount-label">${book.genre_name}</span>
                                </div>
                                <div class="product-content">
                                    <h3 class="title">
                                        <a href="bookinfo.do?book_isbn=${book.book_isbn}">${book.book_name}</a>
                                    </h3>
                                    <div class="price">${book.book_price}￥</div>
                                </div>
                                <ul class="social">
                                    <li>
                                        <a href="bookinfo.do?book_isbn=${book.book_isbn}" data-trip="quick view">
                                            <i class="fa fa-eye"></i>
                                        </a>
                                    </li>
                                    <li>
                                    <form action="addtocart.do" method="post" accept-charset="utf-8">
                                       <a href="mycart.do" data-trip="add to cart">
                                           <i class="fa fa-shopping-cart">
                                                <input type="hidden" name="user_id" value="${sessionScope.user.id}">
                                                <input type="hidden" name="book_isbn" value="${book.book_isbn}">
                                                <input type="hidden" name="cart_amount" value="1">
                                           </i>
                                       </a>
                                    </form>
                                   </li>

                                </ul>
                            </div>
                    </div>
                </c:forEach>
                </div>
            </div>
        </main>
    </div>
</body>
</html>