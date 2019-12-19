<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>register</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/register.js"></script>
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
    <h1>会員登録</h1>
    <ul>
	<form name="register" action='/Layers/registcomm' method="Post">
    <li>ID:<input type="text" name="id">
    <li>Name:<input type="text" name="name">
    <li>Password:<input type="password" id="pass" name="pass" onkeyup="passwordCheckFunction()">
    <li>PasswordCheck<input type="password" id="pass2" name="pass2" onkeyup="passwordCheckFunction()">
        <br><h5 style="color: red;"  id="passwordCheckMessage"></h5>
    <li>Mail:<input type="text" name="mail">
    <li>
        Sex:
        男<input type="radio" value="1"name="sex">
        女<input type="radio" value="2" name="sex">
    
    <li>birth:<input type="date" name="birth">
        
        <input type="submit" value="Send....">
        
    </form>	
</ul>
</body>
</html>