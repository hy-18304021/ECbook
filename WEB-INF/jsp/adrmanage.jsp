<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript" src="js/adrmanage.js"></script>
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
                    <a href="indexcall.do">Logo</a>
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
            <div id="update" style="display:none;" class="leftcolumn">
                    <form action='addressupdate.do' method="Post">
                        <input type="hidden" name="address_id" id="address_id">
                        名前<br><input id="name" name="name" type="text"size="15"><br>
                        郵便番号<br><input id="code" name="code" type="text"size="15" maxlength="7"><br>
                        住所<br><input id="address" name="address" type="text"size="15"><br>
                        電話番号<br><input id="tel" name="tel" type="text"size="15" maxlength="11"><br>
                        <input type="hidden" id="book_isbn" name="book_isbn">
                        <input type="submit" value="修正">
                    </form>
                    <button type="button" onclick="disappear()">閉じる</button>
            </div>
             <div class="frame">        
                <div class="mypage">
                <div class="meminfo">
                    <h2>${sessionScope.user.id}さまの送り先住所</h2>        
                    <ul id="mem">
                        <li><a href="mypage.do">マイページ</a></li>
                    </ul>
                    
                    <hr>
                    
                    <table>
                        <tr>
                            <th>名前</th>
                            <th>郵便番号</th>
                            <th>住所</th>
                            <th>電話番号</th>
                            <th>修正</th>
                        </tr>
                        <c:forEach var="address" items="${result}">
                        <tr>
                                <th>${address.receiver_name}</th>
                                <th>${address.postal_code}</th>
                                <th>${address.address}</th>
                                <th>${address.tel}</th>
                                <th><button type="button" onclick="appearadd(${address.address_id})">修正</button></th>
                        </tr>
                        </c:forEach>
                    </table>
                    

                    
                    </div>
                  </div>
                </div> 
            </div>
                
   </body>
   </html>