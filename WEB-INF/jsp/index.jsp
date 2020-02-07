<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>main</title>
    <link rel="stylesheet" type="text/css" href="css/styletest.css">
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
<body>
    <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
    <div id="app">
        <header class="page-element"><div>
           <h1>
              <img class="big-logo" src="http://ws2019.taipaweb.com/css-final-project/logo.png" alt="Logo">
              <span class="big-logo-text">EbBook</span>
           </h1>
           <div class="book-finder">
              <ul class="book-type-list">
                <li id="mypage"><a href="mypage.do">MyPage</a></li>
                <li id="loginli"><a href="logincall.do">Login</a></li>
                <li id="logoutli"><a href="logout.do">Logout</a></li>
                <li id="mycart"><a href="mycart.do">Cart</a></li>
              </ul>
              <form class="book-search" action="" method="">
                 <input type="text" name="search-query">
                 <input type="submit" value="Search">
              </form>
           </div>
          
        </div>
    </header>
        <main>
            <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
           <div id="slider" class="page-element">
            <div>
              <h2>Welcome to EbBook</h2>
           </div>
        </div>
           <div id="content" class="page-element"><div>
              <div id="popular-books">
                 <h3>Popular Books</h3>
                 <div class="container">
                    <c:forEach var="book" items="${result}">
                        <div class="bookContainer" id="book02">
                            <a href="bookinfo.do?book_isbn=${book.book_isbn}">
                            <div class="bookImage" id="img02"><img src="bookimage/${book.book_isbn}" height="240px" width="150px" alt="${book.book_name}">&nbsp;</div>
                         </a>
                        ${book.book_name}<br>
                        <a href="#">
                        ${book.book_price}</a>
                      </div>
           </div>
            </c:forEach>
        </div>
         
        </main>
            
</body>
</html>