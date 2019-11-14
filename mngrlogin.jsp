<%@page pageEncoding="Windows-31J" contentType="text/html; charset=Windows-31J"%>

<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="/ecbook${requestScope.target}" method="post">
            id<input type="text" name ="name">
            password<input type="text" name="pass"><br><br>
            <input type="submit" value="Login"> 
        </form>
    </body>
</html>