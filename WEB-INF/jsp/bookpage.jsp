<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
     <link rel="stylesheet" type="text/css" href="css/bookpage.css">
     <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="js/ajax.js"></script>
    <script type="text/java" src="js/bookreview.js"></script>
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
    <div class="container">
  
        <div class="product-container main-product-container">
          
          <div class="product-left-container">
            <img src="bookimage/${result.book_isbn}" alt="" width="540"/>
          </div>
          
          <div class="product-col-container">
            <h1 class="product-page">${result.book_name}</h1>
            <p>
              <b>${result.text_content}</b><br/>
            </p>
            <p class="product-body">
                内容
            </p>
            
            <p class="product-price">
              <b>Price:</b> 
              <span class="price">${result.book_price}</span>
            </p>
            
            <div>
                <form action="addtocart.do" method="post" accept-charset="utf-8">
                    <input type="hidden" name="user_id" value="${sessionScope.user.id}">
                    <input type="hidden" name="book_isbn" value="${result.book_isbn}">
                    <input type="hidden" name="cart_amount" value="1">
              <button>Add to cart</button>
            </form>
            </div>
          </div>
          
        </div>
        <br clear="all"/>
        <div class="product-container">
          
          <div class="product-left-container">
            <h2 class="product-page">Review</h2>
            <p class="product-body">
                <div id ="writereviewwithajax">
                    内容:<input type="text" id="review_text" required>
                    評価:<input type="number" id="review_star" required>
                    <button type="button" onclick="bookreviewchange('addreview','${result.book_isbn}','${sessionScope.user.id}',null,null,null)">Ajax Review</button>
                    <div id="review">
                        <h1>REVIEW</h1>
                            <table border='1'>
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Text</th>
                                        <th>Star</th>
                                        <th>Date</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="review" items="${bookreviewlist}">
                                    <tr>
                                        <td>${review.user_id}</td>
                                        <td>${review.review_text}</td>
                                        <td>${review.review_star}</td>
                                        <td>${review.review_date}</td>
                                        <td><button id="review-delete-button" type="button" onclick="bookreviewchange('deletereview','${result.book_isbn}','${sessionScope.user.id}','${review.review_text}','${review.review_star}','${review.review_date}')">delete</button></td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                    </div>
                </div>
              </p>
          </div>

          
        </div>
    
        <br clear="all"/>
      </div>
      
    <br>
    <br>
    <br>
<!--     <div id="writereview">
        <h3>REVIEW 書きましょう</h3>
        <form action="addbookreview.do" method="post" accept-charset="utf-8">
            <input type="hidden" name="user_id" value="${sessionScope.user.id}">
            <input type="hidden" name="book_isbn" value="${result.book_isbn}">
            <input type="text" name="review_text" required>
            <input type="number" name="review_star" min="1" max="5" required>
            <input type="submit" value="Review">
        </form>
    </div> -->

    <!-- <br>
    <div id ="writereviewwithajax">
        内容:<input type="text" id="review_text" required>
        評価:<input type="number" id="review_star" required>
        <button type="button" onclick="bookreviewchange('addreview','${result.book_isbn}','${sessionScope.user.id}',null,null,null)">Ajax Review</button>
    </div> -->

</body>
</html>
