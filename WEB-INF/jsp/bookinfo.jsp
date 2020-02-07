<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>main</title>
    <link rel="stylesheet" type="text/css" href="style.css">
	<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
	<script>
        $(document).ready(function(){
            var flag=document.getElementById("flag").innerText;
            if(flag=="OK"){
                document.getElementById("loginli").style.display='none';
            }else{
                document.getElementById("logoutli").style.display='none';
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
                <li><a href="mypage">マイページ</a></li>
                <li id="loginli"><a href="logincall">ログイン</a></li>
                <li id="logoutli"><a href="logout">ログアウト</a></li>
                <li><a href="mycart">カート</a></li>
            </ul>
        </div>
    </header>
    <div id="container">
        <div id="idx_top">
    </div>

    <ul>
        <li>image</li>
        <li>情報</li>
        <li>評価</li>
        <li>価額</li>
        <li><a href="#">カートに入れる</a></li>
    </ul>

    <li>説明文</li>
    
    <li>レビュー</li>
</body>
</html>