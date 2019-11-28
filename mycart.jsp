<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
 	  <meta charset="UTF-8">
   	<title>My Cart</title>
    <script src="js/ajaxtest.js"></script>
  </head>
  <body>
    <h1>${sessionScope.user.id}様のカート</h1>
  <table border="1">
    <tr>
      <th>ブック名前</th>
      <td>数</td>
    </tr>
    <c:forEach var="cart" items="${sessionScope.mycart}">
      <tr>
        <th>${cart.book_name}</th>
        <td>${cart.cart_amount}</td>
        <td><button type="button" onclick="deleteData()" name="delete">削除</button></td>
      </tr>
    </c:forEach>
  </table>
  <div id="result">
    
  </div>
  
  </body>
</html>