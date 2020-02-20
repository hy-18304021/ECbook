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
    
      <ul>
          <input type="submit" value="注文履歴">
          <input type="submit" value="お届け住所変更">
      </ul>

   	
   	
       <h1>Login as: ${sessionScope.user.id}</h1>
       ${sessionScope.user.pass}
       <br>${sessionScope.user.name}
       <br>${sessionScope.user.mail}
       <br>${sessionScope.user.sex}
       <br>${sessionScope.user.birth}
      <button onclick="appearUpdateForm()">修正</button>


       <div id="update" style="display:none;">
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
        
       </div>
       <div id="result">
         
       </div>
       <h1><a href="${pageContext.request.contextPath}/">EbBook</a></h1>
       <h1><a href="logout.do">ログアウト</a></h1>
       
   </body>
   </html>