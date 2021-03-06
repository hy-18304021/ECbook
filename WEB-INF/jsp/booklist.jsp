<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>BookList</title>
    <link rel="stylesheet" type="text/css" href="css/styletest.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="js/booklist.js"></script>
	<script src="js/pageload.js" type="text/javascript" charset="utf-8" async defer></script>
</head>
<body>
<div class="wrapper">
    <header class="page-element">
       <div>
        <a href="indexcall.do">
            <img src="img/logo.png" style="margin-top:8px; width:182px; height: 66px;">
        </a>
            <div class="book-finder">
                <ul class="book-type-list">
                    <li id="booklistli"><a href="getbooktable.do">BookList</a></li>
                    <li id="mypage"><a href="mypage.do">MyPage</a></li>
                    <li id="loginli"><a href="logincall.do">Login</a></li>
                    <li id="logoutli"><a href="logout.do">Logout</a></li>
                    <li id="mycart"><a href="mycart.do">Cart<div class='cartnumber'><center>${fn:length(sessionScope.mycart)}</center></div></a></li>
                </ul>
                <form class="book-search" action="searchbook.do" method="post">
                    <input type="text" name="book_name">
                    <input type="hidden" name="genre_id" value="0">
                    <input type="submit" value="Search">
                </form>
           </div>
        </div>
    </header>
    <main>
        <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
        <div class="leftcolumn">
            <p style="font-weight: bold;">ジャンル</p>
            <a href="searchbook.do?genre_id=1&book_name="><p>少年コミック</p></a>
            <a href="searchbook.do?genre_id=2&book_name="><p>少女コミック</p></a>
            <a href="searchbook.do?genre_id=3&book_name="><p>ライトノベル</p></a>
        </div>
        <div class="container">

            <div class="row" id="booklist">
                <c:forEach var="book" items="${result}">
                    <div class="col3" style="display:none;">
                        <a href="bookinfo.do?book_isbn=${book.book_isbn}">
                            <div class="product-grid" style="margin-top: 10px;">
                                <div class="product-image">
                                        <img src="https://cover.openbd.jp//${book.book_isbn}.jpg" width="142" height="203" class="pic-1" alt="${book.book_name}">
                                    <span class="product-discount-label">${book.genre_name}</span>
                                </div>
                                <center>
                                <div class="product-content">
                                    <div class="price" style="margin: 0px 0px 10px -10px;">
                                    ${book.book_price}円
                                </div>
                                    <h3 class="title">
                                        <a href="bookinfo.do?book_isbn=${book.book_isbn}">${book.book_name}</a>
                                    </h3>
                                
                                </div></center>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </main>
    <footer>
        <div class="footer">
            <p>東京テクニカルカレッジ情報処理科２年</p>
            </div>
    </footer>
</div><%-- wrapper --%>
</body>
</html>