<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <!DOCTYPE html>
   <html lang="en">
   <head>
   	<meta charset="UTF-8">
   	<title>My page</title>
    <link rel="stylesheet" type="text/css" href="css/mypage.css">
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
                <li id="booklistli"><a href="getbooktable.do">BookList</a></li>
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
        <h2>マイページ</h2>        
        <ul id="mem">
            <li><a href="orderhistorycall.do">注文履歴</a></li>
            <li><a href="addresseditcall.do">お届け住所変更</a></li>
        </ul>
        
        <hr>
        
          <table>
            <tr>
              <th>ユーザ名</th><td>${sessionScope.user.id}</td>
            </tr>
            <tr>
                <th>名前</th><td>${sessionScope.user.name}</td>
            </tr>
            <tr>
                <th>パスワード</th><td>${sessionScope.user.pass}</td>
              </tr>
            <tr>
              <th>メール</th><td>${sessionScope.user.mail}</td>
            </tr>
            <tr>
                <th>性別</th><td>${sessionScope.user.sex}</td>
            </tr>
            <tr>
                <th>生年月日</th><td>${sessionScope.user.birth}</td>
            </tr>
            <tr>
                <th colspan="2"><button onclick="appearUpdateForm()">修正</button></th>
            </tr>
            
        </table>
        
        <div id="update" style="display:none;">
            <table style="float: right; margin-top:-243px;">
            <form action="updateuser.do" method="post" accept-charset="utf-8">
                <input type="hidden" name="id" value="${sessionScope.user.id}">
                <!-- <tr>
                    <th>ユーザ名</th>
                    <td><input type="text" name="id" id="id"></td>
                </tr> -->
                <tr>
                    <th>名前</th>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <th>パスワード</th>
                    <td><input type="text" name="pass" id="pass"></td>
                </tr>
                <tr>
                    <th>メール</th>
                    <td><input type="text" name="mail" id="mail"></td>
                </tr>
                <tr>
                    <th>性別</th>
                    <td>
                    <input type="radio" name="sex" value="1" id="sex"checked>Male
                    <input type="radio" name="sex" value="2" id="sex">Female
                    </td>
                </tr>
                <tr>
                <th>生年月日</th>
                <td><input type="date" name="birth" id="birth" value="2018-01-01">
                </td>
                </tr>
                <tr>
                    <th colspan="2">
                    <input type="submit" value="情報修正">
                    <button type="button" onclick="disappear()">閉じる</button>
                    </th>
                </tr>
                </form>
            
           
            </table>
        </div>
      </div>
       <!-- <h1>Login as: ${sessionScope.user.id}</h1>
       ${sessionScope.user.pass}
       <br>${sessionScope.user.name}
       <br>${sessionScope.user.mail}
       <br>${sessionScope.user.sex}
       <br>${sessionScope.user.birth} -->
 

       <!-- <div id="update" style="display:none;">
        <form action="updateuser.do" method="post" accept-charset="utf-8">
            <input type="hidden" name="id" value="${sessionScope.user.id}">
            Name:<input type="text" name="name" id="name">
            <br>
            Pass:<input type="text" name="pass" id="pass">
            <br>
            Mail:<input type="text" name="mail" id="mail">
            <br>
            Sex:
            <input type="radio" name="sex" value="1" id="sex"checked>Male
            <input type="radio" name="sex" value="2" id="sex">Female
            <br>
            Birth:<input type="date" name="birth" id="birth" value="2018-01-01">
            <br>
            <input type="submit" value="情報修正">
         <button type="button" onclick="disappear()">閉じる</button>
        </form>
        
       </div> -->

    </div>
       
    </div>
    </main>
    </div>
   </body>
   </html>