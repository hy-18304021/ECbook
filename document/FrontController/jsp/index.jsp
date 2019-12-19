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
            <h1 class="logo"><a href="#">ECBook</a></h1>
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
            <li class="item item1">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item2">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item3">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item4">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item5">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item6">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item7">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item8">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>
            <li class="item item9">
                <div class="image">本</div>
                <div class="cont">
                    <strong>本名</strong>
                    <p>価額</p>
                    <a href="#">購入</a>
                </div>
            </li>

            
        </ul>
    </div>
</body>
</html>