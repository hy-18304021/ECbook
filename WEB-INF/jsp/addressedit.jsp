<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <!DOCTYPE html>
   <html lang="en">
   <head>
   	<meta charset="UTF-8">
   	<title>My page</title>
    <link rel="stylesheet" type="text/css" href="css/addressedit.css">
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
        <div class="leftcolumn">
            <p style="font-weight: bold;">ジャンル</p>
            <p>ライトノベル</p>
            <p>少年コミック</p>
            <p>少女コミック</p>
        </div>
             <div class="frame">        
                <div class="mypage">
                <div class="meminfo">
                    <h2>送り先住所登録</h2>        
                    <ul id="mem">
                        <li><a href="mypage.do">マイページ</a></li>
                        <li><a href="">お届け住所管理</a></li>
                    </ul>
                    
                    <hr>
                    
                    <div class="registbox">
                            <form action='addressadd.do' method="Post">
                                <input type="hidden" name="user_id" value="${sessionScope.user.id}">
                                <p>名前</p>
                                <input type="text" name="reciver_name">
                                
                                <p>郵便番号</p>
                                <input type="text" name="postal_code">
                                
                                <p>住所</p>
                                <input type="text" name="address">
                                
                                <p>電話番号</p>
                                <input type="text" name="tel">
                                <br>
                                <input type="submit" value="登録">
                            
                            </form>	
                    </div>
                    
                    </div>
                  </div>
                </div>
                   
                </div>
                
   </body>
   </html>