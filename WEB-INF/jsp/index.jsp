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
    <script type="text/javascript" src="js/ajax.js"></script>
	<script src="js/pageload.js" type="text/javascript" charset="utf-8" async defer></script>
    <style>

    </style>

</head>
<body>
    <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
    
        <header class="page-element">
            <div>
                    <a href="indexcall.do">
                        <img src="img/logo.png" style="margin-top:8px; width:250px; height: 80px;">
                    </a>
           <div class="book-finder">
              <ul class="book-type-list">
                <li id="booklistli"><a href="getbooktable.do">BookList</a></li>
                <li id="mypage"><a href="mypage.do">MyPage</a></li>
                <li id="loginli"><a href="logincall.do">Login</a></li>
                <li id="logoutli"><a href="logout.do">Logout</a></li>
                <li id="mycart"><a href="mycart.do">Cart</a></li>
              </ul>
           </div>
     
        </div>
    </header>
    <div id="navigation">
        <form class="book-search" action="searchbook.do" method="post">
            <input type="text" name="book_name">
            <input type="hidden" name="genre_id" value="0">
            <input type="submit" value="Search">
         </form>    
        
    </div>
        <main>
            <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
            <div class="leftcolumn">
                <p style="font-weight: bold;">ジャンル</p>
                <a href="searchbook.do?genre_id=3&book_name="><p>ライトノベル</p></a>
                <a href="searchbook.do?genre_id=1&book_name="><p>少年コミック</p></a>
                <a href="searchbook.do?genre_id=2&book_name="><p>少女コミック</p></a>
            
            </div>
            <div id="content" class="page-element">
                <div>
                    <div id="popular-books">
                        <h3>Popular Books</h3>

                        <div class="container">
                            <div class="row">
                                <!-- recommendedBooks -->
                                <c:forEach var="book" items="${recommendedBooks}">
                                    <div class="col3">
                                    <a href="bookinfo.do?book_isbn=${book.book_isbn}">
                                        <div class="product-grid" style="width: 221px;">
                                            <div class="product-image">
                                                
                                                    <img src="https://cover.openbd.jp//${book.book_isbn}.jpg" onclick="bookinfo.do" class="pic-1" alt="${book.book_name}">
                            
                                                <span class="product-discount-label">${book.genre_name}</span>
                                            </div>
                                            <div class="product-content">
                                                <div class="price" style="margin: 0px 0px 10px -10px;">${book.book_price}円</div>
                                                <h3 class="title">
                                                    <a href="bookinfo.do?book_isbn=${book.book_isbn}">${book.book_name}</a>
                                                </h3>
                                            
                                            </div>
                                        </a>
                                            <!-- <ul class="social">
                                                <li>
                                                    <a href="bookinfo.do?book_isbn=${book.book_isbn}" data-trip="quick view">
                                                        <i class="fa fa-eye"></i>
                                                    </a>
                                                </li>
                                                <li>
                                                   <form href="addtocart.do" method="post" data-trip="add to cart">
                                                    <a>
                                                        <input type="hidden" name="user_id" value="${sessionScope.user.id}">
                                                        <input type="hidden" name="book_isbn" value="${book.book_isbn}">
                                                        <input type="hidden" name="cart_amount" value="1">
                                                       <i class="fa fa-shopping-cart">
                                                       </i>
                                                   </a>
                                                </form>
                                                    
                                               </li>

                                            </ul> -->
                                        </div>
                                </div>
                            </c:forEach>
                            </div>
                            <!-- shounen -->
                            <h3>Shounen Books</h3>
                            <br>
                                <div class="row">
                            <c:forEach var="book" items="${recommendedShounen}">
                                    <div class="col3">
                                    <a href="bookinfo.do?book_isbn=${book.book_isbn}">
                                        <div class="product-grid" style="width: 221px;">
                                            <div class="product-image">
                                                
                                                    <img src="https://cover.openbd.jp//${book.book_isbn}.jpg" class="pic-1" alt="${book.book_name}">
                                                </a>
                                                <span class="product-discount-label">${book.genre_name}</span>
                                            </div>
                                            <div class="product-content">
                                                <div class="price" style="margin: 0px 0px 10px -10px;">${book.book_price}円</div>
                                                <h3 class="title">
                                                    <a href="bookinfo.do?book_isbn=${book.book_isbn}">${book.book_name}</a>
                                                </h3>
                                            
                                            </div>
                                           </a> 
                                        </div>                             
                                </div>
                            </c:forEach>
                            </div>

                            <!-- Shoujo -->
                            <h3>Shoujo Books</h3>
                            <br>
                            <!-- <div class="container"> -->
                            <div class="row">
                            <c:forEach var="book" items="${recommendedShoujo}">
                                    <div class="col3">
                                    <a href="bookinfo.do?book_isbn=${book.book_isbn}">
                                        <div class="product-grid" style="width: 221px;">
                                            <div class="product-image">
                                                
                                                    <img src="https://cover.openbd.jp//${book.book_isbn}.jpg" class="pic-1" alt="${book.book_name}">
                                                </a>
                                                <span class="product-discount-label">${book.genre_name}</span>
                                            </div>
                                            <div class="product-content">
                                                <div class="price" style="margin: 0px 0px 10px -10px;">${book.book_price}円</div>
                                                <h3 class="title">
                                                    <a href="bookinfo.do?book_isbn=${book.book_isbn}">${book.book_name}</a>
                                                </h3>
                                            
                                            </div>
                                        </a>
                                        </div>                             
                                </div>
                            </c:forEach>
                            </div>
                            <!-- </div> -->
                            <!-- LightNovel -->
                            <h3>LightNovel Books</h3>
                            <br>
                            <!-- <div class="container"> -->
                                <div class="row">
                            <c:forEach var="book" items="${recommendedLightNovel}">
                                    <div class="col3">
                                    <a href="bookinfo.do?book_isbn=${book.book_isbn}">
                                        <div class="product-grid" style="width: 221px;">
                                            <div class="product-image">
                                                
                                                    <img src="https://cover.openbd.jp//${book.book_isbn}.jpg" class="pic-1" alt="${book.book_name}">
                                                </a>
                                                <span class="product-discount-label">${book.genre_name}</span>
                                            </div>
                                            <div class="product-content">
                                                <div class="price" style="margin: 0px 0px 10px -10px;">${book.book_price}円</div>
                                                <h3 class="title">
                                                    <a href="bookinfo.do?book_isbn=${book.book_isbn}">${book.book_name}</a>
                                                </h3>
                                            
                                            </div>
                                        </a>
                                        </div>                             
                                </div>
                            </c:forEach>
                            </div>
                            <!-- </div> -->
                            </div>
                        </div>
                     </div>
                 </div>
             </main>
           
            <!-- footer -->
            <footer>
                <div class="footer">
                    <p>東京テクニカルカレッジ情報処理科２年</p>
                </div>
            </footer>
        
        
   
</body>
</html>