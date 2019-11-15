<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
    <head>
        <title>bookregister</title>
        <!-- <script src="../js/jquery-1.11.0.min.js"></script>
	    <script src="bookregisterform.js"></script> -->
        <script type="text/javascript" language="javascript" src="js/ajax.js"></script>
    </head>
<body>
<div id="listHeader">
        <button id="bookMain">管理者メイン</button>
        <button id="bookList">目録</button>
    </div>
<ul>
        <li><label for="book_kind">大ジャンル選択</label>
            <select id="book_kind" name="book_kind">
              <option value="100">雑誌</option>
              <option value="200">専門書</option>
              <option value="300">小説</option>
              <option value="300">児童向け</option>
              <option value="300">外国書</option>
              <option value="300">成人向け</option>
            </select>
         <li><label for="book_name">本名</label>
            <input id="book_name" name="book_name" type="text" 
             size="50" placeholder="本名" maxlength="50">
         <li><label for="book_price">価額</label>
            <input id="book_price" name="book_price" type="text" 
             size="10" placeholder="価額" maxlength="9">円
         <li><label for="book_count">在庫</label>
            <input id="book_count" name="book_count" type="text" 
             size="10" placeholder="在庫" maxlength="5">冊
         <li><label for="book_image">イメージ</label>
            <input id="book_image" name="book_image" type="file">  
         <li><label for="book_isbn">ISBNコード</label>
            <input id="book_isbn" name="book_id" type="text" 
             size="50" placeholder="本名" maxlength="50">
         
        <div id="regist"></div><button type="button" onclick="regist()">登録</button>
</ul>
</body>
</html>