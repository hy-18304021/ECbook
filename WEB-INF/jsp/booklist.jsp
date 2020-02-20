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
        .product-grid{
            font-family: tahoma;
            text-align: center;
            overflow: hidden;
            position: relative;
            border: 4px solid white;
        }

        .product-grid:before{
            content: '';
            height: 100%;
            width:100%;
            position: absolute;
            left: 0;
            top: 0;
            z-index: 1;
            transition: all 0.3 ease 0s;
        }

        .product-grid:hover:before{
            background-color: rgba(0, 0, 0, 0.75);
        }

        .product-grid .product-image{
            overflow: hidden;
            position: relative;
            height: 300px;
        }

        .product-grid .product-image a{
            display: block;
        }

        .product-grid .product-image img{
            width: 100%;
            height: auto;
        }

        .product-discount-label{
            color: white;
            background-color: #000;
            font-size: 13px;
            letter-spacing: 1px;
            padding: 8px 12px;
            border-radius: 5px;
            position: absolute;
            left: 15px;
            top: 15px;
        }

        .product-grid .social{
            width: 100%;
            padding: 30px 0;
            margin: 0;
            list-style: none;
            transform: translateX(-50%) translateY(-50%);
            position: absolute;
            left: 50%;
            top: 50%;
            z-index: 2;
        }

        .product-grid .social li{
            display: inline-block;
            opacity: 0;
            transform: translateY(300%);
            transition: all 0.5s ease 0s;
        }

        .product-grid .social li:nth-child(3){
            transition-delay: 0.13;
        }

        .product-grid .social li:nth-child(4){
            transition-delay: 0.17;
        }

        .product-grid:hover .social li{
            opacity: 1;
            transform: translateY(0);
        }

        .product-grid .social li a{
            color: #000;
            background-color: #fff;
            line-height: 50px;
            width: 50px;
            height: 50px;
            margin: 0 2px 10px;
            border-radius: 50%;
            display: block;
            position: relative;
            z-index: 2;
            transition: all 0.3;
        }

        .product-grid .social li a:hover{
            color: white;
            background-color: orange;
        }

        .product-grid .product-content{
            padding: 18px;
            position: relative;
            z-index: 2;
            background-color: white;
        }

        .product-grid .title{
            font-size: 17px;
            font-weight: 500;
            margin: 0 0 10px 0;
        }

        .product-grid .title a{
            color:#000;
        }

        .product-grid .title a:hover{
            color: #fa8231;
        }

        .product-grid .price{
            color: #fa8231;
        }

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
                 <input type="hidden" name="genre_id" value="0">
                 <input type="text" name="book_name">
                 <input type="submit" value="Search">
              </form>
           </div>

        </div>
    </header>
        <main>
            <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>

            <div class="container">
                <div class="row">
                    <c:forEach var="book" items="${result}">
                        <div class="col-md-3">

                            <div class="product-grid">
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