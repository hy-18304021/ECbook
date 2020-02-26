<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>	
	<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="css/login.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
       
	<div class="loginbox">
		<h1>Login</h1>
		<form class="box" method='Post' action='/ecbook/logincomm.do'>
		<p>Username</p>
		<input type="text" name="id" placeholder="Username" required>
		<p>Password</p>
		<input type="password" name="pass" placeholder="Password" required>
		<input type="submit" value="Login">
		<a id="regist" href="registcall.do">Don't have an account?</a>
	</form> 	
	</div>
  <br>${result}
  <!-- <br>Target from filter: ${target} -->
</body>
</html> 