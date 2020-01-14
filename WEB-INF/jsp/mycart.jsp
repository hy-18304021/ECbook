<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
 	  <meta charset="UTF-8">
   	<title>My Cart</title>
    <script src="../../js/ajaxtest.js"></script>
  </head>
  <body>
    <h1>${sessionScope.user.id}様のカート</h1>
  <table border="1">
    <tr>
      <th>ブック名前</th>
      <td name="cart_amount">数</td>
    </tr>
    <c:forEach var="cart" items="${sessionScope.mycart}">
      <tr>
        <th>${cart.book_name}</th>
        <td><input type="number" name="cart_amount" value="${cart.cart_amount}" min='1' ><button type="button" onclick="updateUserCart()" name="update">修正</button></td>
        <td><button type="button" onclick="deleteData()" name="delete">削除</button></td>
      </tr>
    </c:forEach>
  </table>
  <div id="result">
    
  </div>
  
  </body>
</html>