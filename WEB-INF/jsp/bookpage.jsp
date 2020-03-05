<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
     <link rel="stylesheet" type="text/css" href="css/bookpage.css">
     <link rel="stylesheet" type="text/css" href="css/text.css">
     <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
    <!-- <script type="text/javascript" src="js/ajax.js"></script> -->
    <script type="text/javascript" src="js/bookreview.js"></script>
    <script src="js/pageload.js" type="text/javascript" charset="utf-8" async defer></script>
    <script src="js/bookpagefavorite.js" type="text/javascript" charset="utf-8" async defer></script>
    <script>
      $(document).ready(function(){
        var flag=document.getElementById("flag").innerText;
        if(flag=="OK"){
          $("#add-to-favorite-logout").css("display","none");
          $("#add-to-favorite-login").css("display","block");
        }else{
        document.getElementById("writereviewwithajax").style.display='none';
          $("#add-to-cart").css("display","none");
          $("#add-to-favorite-logout").css("display","block");
          $("#add-to-favorite-login").css("display","none");

        }
      });
    </script>
    <title>${result.book_name}</title>
</head>
<body>
    <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
    <h1 style="display:none;" class="sessionId">${sessionScope.user.id}</h1>
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
              <li id="mycart"><a href="mycart.do">Cart</a></li>
            </ul>
            <form class="book-search" action="searchbook.do" method="post">
              <input type="text" name="book_name">
              <input type="hidden" name="genre_id" value="0">
              <input type="submit" value="Search">
           </form>    
           </div>

        </div>
    </header>
    <div class="wishlist-result" aria-hidden="true">
      <center>
        <div class="wishlist-result-x">
          <div class="close-button">
            欲しいリストに追加する
            <i class="a-icon a-icon-close close-overlay" ></i>
          </div>
          <div id="wishlist_result">
          <p style="color:red;">
              <span class="result1" style="display:none;">
                このアイテムを欲しいリストに追加しました。
              </span>
              <span class="result2" style="display:none;">
                このアイテムは既に欲しいリストにありました。
              </span>
            </p>
          </div>
           <img src="https://cover.openbd.jp//${result.book_isbn}.jpg" alt="" width="120"/>
        </div>
      </center>
    </div>
    <div class="container">
      
        <div class="product-container main-product-container">
          <div class="product-left-container">
            <img src="https://cover.openbd.jp//${result.book_isbn}.jpg" alt="" width="540"/>
          </div>
          <div class="product-col-container">
            <h1 class="product-page">${result.book_name}</h1>
            <h1 style="display:none;"  class="book-isbn">${result.book_isbn}</h1>
            <p>
              <b>${result.text_content}</b><br/>
            </p>
            <p class="product-price">
              <b>Price:</b>
              <span class="price">${result.book_price}</span>
            </p>
            <div id="add-to-cart">
                <form action="addtocart.do" method="post" accept-charset="utf-8">
                  <input type="hidden" name="user_id" value="${sessionScope.user.id}">
                  <input type="hidden" name="book_isbn" value="${result.book_isbn}">
                  <input type="hidden" name="cart_amount" value="1">
                    <button>カートに入れる</button>
                </form>
            </div>
            <div id="add-to-favorite-logout">
              <form action="addtofavorite.do?user_id=${sessionScope.user.id}&book_isbn=${result.book_isbn}" method="post" accept-charset="utf-8">
              <button type="submit">欲しいものリストに追加</button>
              </form>
            </div>
            <div id="add-to-favorite-login">
              <i class="open-overlay"><button type="button" class="add-to-favorite-button">欲しいものリストに追加</button></i>
            </div>
            <p style="color:red;">
              <c:choose>
               <c:when test="${favoriteresult=='1'}">
                  このアイテムを欲しいリストに追加しました。
              </c:when>
              <c:when test="${favoriteresult=='2'}">
                  このアイテムは既に欲しいリストにありました。
              </c:when>
                <c:otherwise>
                </c:otherwise>
            </c:choose>
            </p>
            
          </div>
        </div>
        <br clear="all"/>
        <div class="product-container">
          <div class="leftcolumn" style="float: right;">
            <p style="font-weight: bold;">同じジャンルの本</p>
            
              
            <c:forEach var='book' items='${recommendedBook}'>
              <a href="bookinfo.do?book_isbn=${book.book_isbn}">
              <div class="book1">  
                <img src="https://cover.openbd.jp//${book.book_isbn}.jpg" class="pic-1" alt="${book.book_name}" style="width: 60px; float: left;">
              <p style="margin-top:40px; margin-left: 90px; padding-top: 25px;">${book.book_name}</p>
            </div>
          </a>
          </c:forEach>
          
        </div>
          <div class="product-left-container">
            <h2 class="product-page">Review</h2>
            <p class="product-body">
                <div id ="writereviewwithajax">
                    <textarea type="text" id="review_text" class="write-review-area" row='2' col='3' required placeholder="レビューを書いてください。"></textarea>
                    評価:<div>
                            <img class="star-image" src="starimage/emptystar.png" alt="review-star-1">
                            <img class="star-image" src="starimage/emptystar.png" alt="review-star-2">
                            <img class="star-image" src="starimage/emptystar.png" alt="review-star-3">
                            <img class="star-image" src="starimage/emptystar.png" alt="review-star-4">
                            <img class="star-image" src="starimage/emptystar.png" alt="review-star-5">
                            <input type="hidden" class="review-star" min="1" max="5" value="0" required>
                            <input type="button" class="write-review-button" style="width:42px; font-size:15px; border-radius: 5px; height: 32px;" value="投稿">
                            <div id="checkreview" style="color:red;"></div>
                        </div>
                </div>
                <div id="written" style="display: none;">
                  レビューを書いてくれてありがとうございます。
                </div>
                <h2 class="a-spacing-small customer-reviews-header" style="margin-top: 50px;">
                      ${result.book_name}
                </h2>
                

                <div class="a-section" id='review'>
                  <c:forEach var="review" items="${bookreviewlist}">
                      
                    <div class="a-section">
                      <hr>
                      <h4>${review.user_id}</h4>
                      <hr>
                      <div class="a-row a-spacing-micro">
                        <div class="a-icon-row a-spacing-none">
                          <a class="a-link-normal a-text-normal a-color-base"><i class="a-icon a-icon-star a-star-${review.review_star}"></i></a>
                          <span class="a-letter-space"></span>
                          <a class="a-link-normal a-text-normal a-color-base">
                          </a>
                        </div>
                        <span class="a-color-secondary">
                          ${review.review_date}
                        </span>
                      </div>
                      <div class="a-row a-spacing-small">
                        <!-- <span class="a-size-mini a-color-state a-text-bold">
                          Title
                        </span> -->
                        <div class="a-section">
                        <p>
                          ${review.review_text}
                        </p>
                        </div>
                      </div>
                      <h4 class='review-text'>${review.review_text}</h4>
                      <h4 class='review-star'>${review.review_star}</h4>
                      <h4 class='user-id'>${review.user_id}</h4>
                      <input type="button" class="appear-update-review-form-button" value="修正">
                      <input type="button" class="delete-review-button" value="削除">
                    </div>
                  </c:forEach>
                </div>
                <button class="newer-review-button" onclick="newerreview()">前のレビューへ</button>
                <button class="older-review-button" onclick="olderreview()">もっと古いレビューを見たいい</button>
              </p>
          </div>
        </div>
        <br clear="all"/>
      </div>
      <!-- footer -->
      <footer>
        <div class="footer">
            <p>東京テクニカルカレッジ２年</p>
        </div>
    </footer>


</body>
</html>
