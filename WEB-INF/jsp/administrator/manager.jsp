<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Manager</title>
	<script src="js/jquery-1.11.0.min.js"></script>
</head>
<body>
	在庫管理
	<div id="mList">
		<ul>
			<li>商品管理
			<li><a href="bookregistcall.do"><button type="button">商品情報登録</button></a>
			<li><a href="booklistcall.do"><button type="button">商品情報修正/削除</button></a>
		</ul>
		<ul>
			<li>会員情報</li>
			<li><a href="userlist"><button type="button">会員情報一覧</button></a></li>
		</ul>
		 <ul>
			<li>購入した目録
			<li><a href="salesform"><button type="button">全体購入目録確認</button></a>
		 </ul>

		
	</div>


</body>
</html>