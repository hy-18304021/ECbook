<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <!DOCTYPE html>
   <html lang="en">
   <head>
   	<meta charset="UTF-8">
   	<title>My page</title>
    <link rel="stylesheet" type="text/css" href="css/orderhistory.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
    
        <!-- <div class="container">
            <c:forEach var="sales" items="${result}">
                <%--1 rowに1 EBSalesの情報を入れる --%>
                <div class="row">
                    <c:forEach var="book" items="${sales}">
                        <div class="col-md-8">
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
                        </div>
                        <div class="col-md-4">
                            <div class="col-md-4">
                                <button>商品レビューを書く</button>
                                <button>再度購入</button>
                            </div>
                        </div>
                    </forEach>
                </div>
            </forEach>
             -->
             <div class="frame">        
                <div class="mypage">
                <div class="meminfo">
                    <h2>${sessionScope.user.name}さまの購入履歴</h2>        
                    <ul id="mem">
                        <li><a href="mypage.do">マイページ</a></li>
                        <li><a href="addresseditcall.do">お届け住所変更</a></li>
                    </ul>
                    
                    <hr>
                    
                    <table>
                        <tr>
                            <th>商品名</th>
                            <th>イメージ</th>
                            <th>値段</th>
                            <th>購入日時</th>
                            <th>数量</th>
                            <th>金額</th>
                        </tr>
                        <tr>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                    </table>
                    
                    </div>
                  </div>
                </div>
                   
                </div>
                
   </body>
   </html>