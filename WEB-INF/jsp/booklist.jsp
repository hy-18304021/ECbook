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
    <div id="container">
        <div id="idx_top"></div>
    </div>
    <div class="memu_wrap">
        <ul class="dep1">
            <li>
                <a href="#">コミック</a>
                <ul class="dep2">
                    <li>
                        <a href="#">1</a>
                    </li>
                    <li>
                        <a href="#">2</a>
                    </li>
                    <li>
                        <a href="#">3</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#">ライトノベル</a>
            </li>
        </ul>
    </div>

    <div class="list_wrap">
        <ul>
            <c:forEach var="book" items="${result}">
                <li class="item item">
                    <a href="bookinfo.do?book_isbn=${book.book_isbn}">
                        <div class="image">本
                            <img src="bookimage/${book.book_isbn}" height="230" width="270" alt="${book.book_name}">
                        </div>
                    </a>
                    <div class="cont">
                        <strong>本名:${book.book_name}</strong>
                        <p>価額:${book.book_price}</p>
                        
                    </div>
                </li>
            </c:forEach>
        </ul>
        


        <ul>



            
            <!-- <li class="item item">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li> -->

            
        <!-- </ul> -->
    </div>
</body>
</html>