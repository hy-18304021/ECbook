<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="jp">
<head>
	<meta charset="UTF-8">
    <title>product</title>
    <script src="http://code.jquery.com/jquery-1.11.0.js"> </script>         
</head>
<body>
    <!-- header -->

    <!-- product -->
    <ul>
        商品
        <li><img src="${result}" width="300px" height="283px" crossorigin="anonymous"></li>
        <li><img src="img?jpg=9784088820743" width="300px" height="283px"></li>
        <li><img src="https:\/\/cover.openbd.jp\/9784088820743.jpg" width="300px" height="283px"></li>
        <li><img src="img/book/9784088820743.jpg" width="300px" height="283px"></li>
        <li>タイトル</li>
        <li>著者</li>
        <li>ISBNコード</li>
        <li>評価</li>
        <li>価額</li>
        <button>カートに入れる</button>
    </ul>
    <ul>
        説明文
        <li>内容</li>
    </ul>

    <ul>
        レビュー
        <li>レビュの内容</li>
        <form>
            <table>
                <tbody>
                    <tr>
                        <input type="text" placeholder="タイトル" maxlength="50">
                    </tr>
                    <tr>
                        <td><textarea placeholder="レビュー内容" maxlength="100" style="width:600px; height:200px;"></textarea></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="レビューを書く">
        </form>
    </ul>
</body>
</html>