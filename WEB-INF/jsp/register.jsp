<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>register</title>
    <style>
		<%@ include file = "regist.css" %>
	</style>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">

        function passwordCheckFunction(){
            var pass = $('#pass').val();
            var pass2 = $('#pass2').val();
            if(pass != pass2){
                $('#passwordCheckMessage').html('パスワードがちがいます');
            }else{
                $('#passwordCheckMessage').html('');		
            }
            
        }
        
    </script>            
</head>
<body>
    <header>
        <div>
            <h1 class="logo"><a href="./">ECBook</a></h1>
        </div>
    </header>
    <div class="registbox">
        <h1>Sign up</h1>
            <form name="register" action='/ecbook/registcomm.do' method="Post">
                <p>UserID</p>
                <input type="text" name="id">
                <p>Username</p>
                <input type="text" name="name">
                <p>Userpass</p>
                <input type="password" id="pass" name="pass" onkeyup="passwordCheckFunction()">
                <input type="password" id="pass2" name="pass2" onkeyup="passwordCheckFunction()">
                    <h5 style="color: red;"  id="passwordCheckMessage"></h5>
                <p>Usermail</p>
                <input type="text" name="mail">
                <p>gender</p>
                <div class="radio-group">
                    <label class="radio">
                        <input type="radio" value="1"name="sex">male
                        <span></span>
                    </label>
                    <label class="radio">
                        <input type="radio" value="2" name="sex">female
                        <span></span>
                    </label>
                </div>
                <p style="margin-top: 30px;">Userbirth</p>
                <input type="date" name="birth">
            
                <input type="submit" value="Sign up">
            
            </form>	
    </div>
</body>
</html>