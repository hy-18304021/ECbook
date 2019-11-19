<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
    <head>
        <title>bookregister</title>
<<<<<<< HEAD
        <!-- <script src="../js/jquery-1.11.0.min.js"></script>
	    <script src="bookregisterform.js"></script> -->
        <script type="text/javascript" language="javascript" src="js/ajaxtest.js"></script>
=======
        <link rel="stylesheet" type="text/css" href="manager/style.css">
        <script src="http://code.jquery.com/jquery-1.11.0.js"> </script>
        <script src="manager/bookregisterform.js"></script>
        

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
        <li>
    <label for="book_kind">大カテゴリ</label>
        <input type="radio" name="target" value="m" onchange="showMagazine();" checked>コミック
        <input type="radio" name="target" value="p" onchange="showProfessional();" checked>ライトノベル
    <!--    <input type="radio" name="target" value="n" onchange="showNovel();" checked>少女コミック
        <input type="radio" name="target" value="c" onchange="showChildren();" checked>女性コミック
        <input type="radio" name="target" value="f" onchange="showForeign();" checked>4コママンガ
        <input type="radio" name="target" value="a" onchange="showAdult();" checked> -->
</li>
<li>
    <label for="book_kind">小カテゴリ</label>
        <select id="magazine_area" class="active">
                <option value="100">少年</option>
                <option value="200">青年</option>
                <option value="300">少女</option>
                <option value="300">4コママンガ</option>
                <option value="300">BL</option>
                <option value="300">アダルト</option>
        </select>

    <!--     <select id="professional_area" class="active">
                <option value="100">技術書</option>
                <option value="200">実用書</option>
                <option value="300">レシピ本</option>
                <option value="300">参考書</option>
        </select>

       <select id="novel_area" class="active">
                <option value="100">ライトノベル</option>
                <option value="200">ミステリー</option>
                <option value="300">SF</option>
                <option value="300">ショートショート</option>
        </select>

        <select id="children_area" class="active">
                <option value="100">絵本</option>
                <option value="200">昔話</option>
        </select>

        <select id="foreign_area" class="active">
                <option value="100">原本</option>
        </select>

        <select id="adult_area" class="active">
                <option value="100">官能小説</option>
                <option value="200">グラビア</option>
                <option value="300">同人誌</option>
                <option value="300">漫画</option>
        </select>-->
</li>
            
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
            <input id="book_isbn" name="book_idbn" type="text" 
             size="50" placeholder="本名" maxlength="50">
         
        <div id="result"></div><button type="button" onclick="regist()">登録</button>
</ul>
</body>
</html>