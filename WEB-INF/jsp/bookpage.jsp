<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	 <link rel="stylesheet" type="text/css" href="css/style.css">
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
    <div id="container">
        <div id="idx_top"></div>
    </div>
    <div class="memu_wrap">
        <ul class="dep1">
            <li>
                <a href="#">コミック</a>
                <ul class="dep2">
                    <li>
                        <a href="getbooktable.do">Book List</a>
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
    <br><img src="bookimage/${result.book_isbn}" height="230" width="270" alt="${result.book_name}">
    <br>${result.book_name}
	<br>${result.book_price}
	

	<br>

    <!-- Add to Cart -->
	<div>
		<form action="addtocart.do" method="post" accept-charset="utf-8">
            <input type="hidden" name="user_id" value="${sessionScope.user.id}">
            <input type="hidden" name="book_isbn" value="${result.book_isbn}">
            <input type="hidden" name="cart_amount" value="1">

            <input type="submit" value="カートに入れ">
		</form>
	</div>
	
</body>
</html>