<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Manager</title>
	<script src="js/jquery-1.11.0.min.js"></script>
	<script src="manager.js">
	</script>
</head>
<body>
	在庫管理
	<div id="mList">
	<ul>
			<li>商品管理
			<li><button id="registProduct">商品登録</button>
			<li><button id="updateProduct">商品修正/削除</button>
		 </ul>
	<ul>
		<li>会員情報</li>
		<li><button id ="userProduct">会員情報</button></li>
	</ul>
		 <ul>
			<li>購入した目録
			<li><button id="orderedProduct">全体購入目録確認</button>
		 </ul>

		
	</div>


</body>
</html>