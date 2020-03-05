<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <!DOCTYPE html>
   <html lang="en">
   <head>
   	<meta charset="UTF-8">
   	<title>My page</title>
    <link rel="stylesheet" type="text/css" href="css/mypage.css">
    <link rel="stylesheet" type="text/css" href="css/text.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="js/ajax.js"></script>
    <script src="js/pageload.js" type="text/javascript" charset="utf-8" async defer></script>
    <script src="js/mypage.js" type="text/javascript" charset="utf-8" async defer></script>
   </head>
   <body>
    <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
    <h1 style="display:none;" class="sessionId">${sessionScope.user.id}</h1>
    <div id="app">
        <header class="page-element">
            <div>
                <a href="indexcall.do">
                    <img src="img/logo.png" style="margin-top:8px; width:182px; height: 66px;">
                </a>
              
           <div class="book-finder">
            <ul class="book-type-list">
                <li id="booklistli"><a href="getbooktable.do">BookList</a></li>
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
            <div class="leftcolumn">
                <p style="font-weight: bold;" onclick="display('meminfo')">情報</p>
                <p style="font-weight: bold;" onclick="display('favorite')">欲しいリスト</p>
                <p style="font-weight: bold;"></p>
            </div>
    
    <div class="frame">        
    <div class="mypage">
    <div class="meminfo">
        <h2>注文確定しました。</h2>        
       
        

        
                 </div>
      </div>
      <div class="favorite" style="display:none;">
        <h2>欲しいリスト</h2>
        <hr>
        <c:set var="totalFavorBooks" value="${0}" />
        <c:forEach var="favor" items="${myfavorite}">
            <c:set var="totalFavorBooks" value="${totalFavorBooks}+1" />
            <i class="open-overlay">
                 <img src="https://cover.openbd.jp//${favor.book_isbn}.jpg" width="180" height="230" alt="${favor.book_isbn}">
            </i>
        </c:forEach>
        <c:choose>
            <c:when test="${totalFavorBooks=='0'}">
            <br><br>
                <p style="font-weight: 800; color:red; font-size: 20px">欲しい本がありません。</p>
            </c:when>    
            <c:otherwise>
            </c:otherwise>
        </c:choose>
      </div>
      <div class="overlay-result"  aria-hidden="true">
        <center>
          <div class="overlay-result-x">
          <div class="close-button">
            本の情報
            <i class="a-icon a-icon-close close-overlay" ></i>
          </div>
          <div id="overlay_result_image">
          </div>
          <div id="overlay_result">
              
          </div>
        </div>
        </center>
      </div>
    </div>
       
    </div>
    </main>
    </div>
   </body>
   </html>