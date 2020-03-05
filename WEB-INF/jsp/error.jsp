<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.ArrayList, bean.EbBookBean"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="jp">
<head>
	<meta charset="UTF-8">
    <title>errorpage</title>
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
                        <img src="img/logo.png" style="margin-top:8px; width:182px; height: 66px;">
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
            <form action='searchbook.do' method="Post">
                <input type="hidden" name="genre_id" value="1">
                <input type="hidden" name="book_name" value="">
                <button>少年コミック</button>
            </form>
            <br>
            <form action='searchbook.do' method="Post">
                <input type="hidden" name="genre_id" value="2">
                <input type="hidden" name="book_name" value="">
                <button>少女コミック</button>
            </form>
            <br>
            <form action='searchbook.do' method="Post">
                <input type="hidden" name="genre_id" value="3">
                <input type="hidden" name="book_name" value="">
                <button>ライトノベル</button>
            </form>
        
        </div>
    <h1>${result.get(0)}</h1>
    <a href="${result.get(1)}">${result.get(2)}</a>
    </main>
</body>
</html>