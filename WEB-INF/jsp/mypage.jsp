<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <!DOCTYPE html>
   <html lang="en">
   <head>
   	<meta charset="UTF-8">
   	<title>My page</title>
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