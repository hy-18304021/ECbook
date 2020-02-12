<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>BookList</title>
    <link rel="stylesheet" type="text/css" href="css/booklist.css">
	<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="js/booklist.js"></script>
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

    <div class="searchbook">
        
        <form action="searchbook.do" method="post" accept-charset="utf-8">
            <h6>Search</h6>
            ジャンル:<select id="magazine_area" class="active" name="genre_id" onchange="">
                    <option value="0"></option>
                    <option value="1">少年</option>
                    <option value="2">青年</option>
                    <option value="3">少女</option>
                    <option value="4">4コママンガ</option>
                    <option value="5">BL</option>
                    <option value="6">アダルト</option>
                    <option value="7">ライトノベル</option>
                </select>
            Name:<input type="text" name="book_name">
            <input type="submit" name="">
        </form>
    </div>
    <div class="container" id='result'>
        <c:forEach var="book" items="${result}">
            <div class="bookContainer" id="book02">
                <a href="bookinfo.do?book_isbn=${book.book_isbn}">
                    <div class="bookImage" id="img02"><img src="bookimage/${book.book_isbn}" height="240px" width="150px" alt="${book.book_name}">&nbsp;</div>
                 </a>
                 <a href="#">${book.book_price}￥</a>
                 <br>
                ${book.book_name}
                
              </div>
        </c:forEach>
    </div>


    
</body>
</html>