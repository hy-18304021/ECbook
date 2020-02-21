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
    <title>${result.book_name}</title>
</head>
<body>
     
    <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
    <h1 style="display:none;" class="sessionId">${sessionScope.user.id}</h1>
    <header class="page-element">
            <div>
                <h1>
                    Logo
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
    <div class="container">
        <div class="product-container main-product-container">
          <div class="product-left-container">
            <img src="bookimage/${result.book_isbn}" alt="" width="540"/>
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
            <div>
                <form action="addtocart.do?user_id=${sessionScope.user.id}&book_isbn=${result.book_isbn}&cart_amount=1" method="post" accept-charset="utf-8">
                    <button>Add to cart</button>
                </form>
            </div>
          </div>
        </div>
        <br clear="all"/>
        <div class="product-container">
          <div class="leftcolumn" style="float: right;">
            <p style="font-weight: bold;">同じジャンルの本</p>
            
              
            <c:forEach var='book' items='${recommendedBook}'>
              <div class="book1">  
                <img src="https://cover.openbd.jp//${book.book_isbn}.jpg" class="pic-1" alt="${book.book_name}" style="width: 60px; float: left;">
              <p style="margin-top:40px; margin-left: 90px; padding-top: 25px;">${book.book_name}</p>
            </div>
          </c:forEach>
          
        </div>
          <div class="product-left-container">
            <h2 class="product-page">Review</h2>
            <p class="product-body">
                <div id ="writereviewwithajax">
                    <textarea type="text" id="review_text" row='2' col='3' required style="resize: none; width: 100%; height: 130px;" placeholder="レビューを書いてください。"></textarea>
                    評価:<input type="number" id="review_star" min="1" max="5" required>
                    <input type="button" class="write-review-button" style="width:42px; font-size:15px; border-radius: 5px; height: 32px;" value="投稿">
                </div>
                
                  <h2 class="a-spacing-small customer-reviews-header" style="margin-top: 50px;">
                      ${result.book_name}
                </h2>
                

                <div class="a-section" id='review'>
                  <c:forEach var="review" items="${bookreviewlist}">
                      <hr>
                      <h4>${review.user_id}</h4>
                      <hr>
                    <div class="a-section">
                      <div class="a-row a-spacing-micro">
                        <div class="a-icon-row a-spacing-none"><a class="a-link-normal a-text-normal a-color-base"><i class="a-icon a-icon-star a-star-${review.review_star}"></i></a>
                          
                          <span class="a-letter-space"></span>
                          <a class="a-link-normal a-text-normal a-color-base">
                          </a>
                        </div>
                        <span class="a-color-secondary">
                          ${review.review_date}
                        </span>
                      </div>
                      <div class="a-row a-spacing-small">
                        <span class="a-size-mini a-color-state a-text-bold">
                          Title
                        </span>
                        <div class="a-section">
                        <p>
                          ${review.review_text}
                        </p>
                        </div>
                      </div>
                      <h4 class='review-text'>${review.review_text}</h4>
                      <h4 class='review-star'>${review.review_star}</h4>
                      <h4 class='user-id'>${review.user_id}</h4>
                      <input type="button" class="delete-review-button" value="削除" style="width:42px; font-size:15px; border-radius: 5px; height: 32px;">
                    </div>
                      
                    </c:forEach>
                </div>
              </p>
          </div>
        </div>
        <br clear="all"/>
      </div>
      <!-- footer -->
      <footer>
        <div class="footer">
            <p>東京テクニカルカレッジ情報処理科２年</p>
        </div>
    </footer>

</body>
</html>
