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
    <script type="text/javascript" src="js/ajax.js"></script>
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
    <header>
        <div>
            <h1 class="logo"><a href="./">ECBook</a></h1>
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
            <h1 style="display:none;"  class="book_isbn">${result.book_isbn}</h1>
            <p>
              <b>${result.text_content}</b><br/>
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
                    内容:<textarea type="text" id="review_text" row='2' col='3' required></textarea>
                    評価:<input type="number" id="review_star" min="1" max="5" required>
                    <button type="button" onclick="bookreviewchange('addreview','${result.book_isbn}','${sessionScope.user.id}',null,null,null)">Ajax Review</button>
                </div>
<<<<<<< HEAD
                    <!-- <div id="review">
                        <h1>REVIEW</h1>
                            <table border='1'>
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th width="3000">Text</th>
                                        <th>Star</th>
                                        <th>Date</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:set var="star" value="${0}" />
                                    <c:set var="reviewcount" value="${0}" />
                                    <c:forEach var="review" items="${bookreviewlist}">
                                    <c:set var="star" value="${star+review.review_star}" />
                                    <c:set var="reviewcount" value="${reviewcount+1}" />
                                    <tr>
                                        <td class='review-user-id'>${review.user_id}</td>
                                        <td class='review-text'>${review.review_text}</td>
                                        <td class='review-star'>${review.review_star}</td>
                                        <td class='review-date'>${review.review_date}</td>
                                        <td class='changebutton'><button id="review-delete-button" type="button" onclick="bookreviewchange('deletereview','${result.book_isbn}','${sessionScope.user.id}','${review.review_text}','${review.review_star}','${review.review_date}')">delete</button></td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                    </div> -->
                    <div class="a-section" style="width:940px;">
      <br>
                        
      <h2 class="a-spacing-small customer-reviews-header">
      <!-- bookname -->
      </h2>
      
      
      
      
      
      <hr>
      <h4> 
        <!--username  -->
    </h4>
      <hr>
      
      <div class="a-section">
      <div class="a-row a-spacing-micro">
      <div class="a-icon-row a-spacing-none"><a class="a-link-normal a-text-normal a-color-base" href=""><i class="a-icon a-icon-star a-star-5"></i></a>
      <span class="a-letter-space"></span>
      <a class="a-link-normal a-text-normal a-color-base" href="">
      </a>
      </div>
      <span class="a-color-secondary">
          <!-- date -->
      </span>
      
      </div>
      
      <div class="a-row a-spacing-small">
      <span class="a-size-mini a-color-state a-text-bold">
          <!-- title -->
      </span>
      
          <div class="a-section">
      
         <!--content  -->
          </div>
      </div>
      
      </div>
=======
                <div class="a-section" style="width:940px;">
                  <h2 class="a-spacing-small customer-reviews-header">
                      ${result.book_name}
                    </h2>
                  <c:forEach var="review" items="${bookreviewlist}">
                    
                      <hr>
                    <h4>
                        ${review.user_id}
                    </h4>
                      <hr>
                    <div class="a-section">
                      <div class="a-row a-spacing-micro">
                        <div class="a-icon-row a-spacing-none"><a class="a-link-normal a-text-normal a-color-base" href=""><i class="a-icon a-icon-star a-star-${review.review_star}"></i></i></a>
                          <span class="a-letter-space"></span>
                          <a class="a-link-normal a-text-normal a-color-base" href="">
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
                          ${review.review_text}
                        </div>
                      </div>
                    </div>
                    </c:forEach>
>>>>>>> e24b753f1106018da6f505eabb3e72bd03253966
                </div>
              </p>
          </div>

          
        </div>
    
        <br clear="all"/>
      </div>

</body>
</html>
