<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
    <head>
        <title>bookregister</title>

        <!-- <script src="../js/jquery-1.11.0.min.js"></script>
	    <script src="bookregisterform.js"></script> -->
        <script type="text/javascript" language="javascript" src="js/ajaxtest.js"></script>

        <link rel="stylesheet" type="text/css" href="manager/style.css">
        <script src="http://code.jquery.com/jquery-1.11.0.js"> </script>
        <script src="bookregisterform.js"></script>
        

    </head>
<body>
    <div id="listHeader">
        <a href="managercall"><button id="bookMain">管理者メイン</button></a>
        <a href="booklistcall"><button id="bookList">目録</button></a>
    </div>
    <ul>
    <form name="register" action='/ecbook/bookregistcomm' method="Post">
        <li>ISBNコード:
        <input id="book_isbn" name="book_isbn" type="text" size="50" placeholder="ISBNコード" maxlength="50">
        </li>

        <li>
            ジャンル:
                <select id="magazine_area" class="active" name="genre_id">
                    <option value="21">少年</option>
                    <option value="22">青年</option>
                    <option value="23">少女</option>
                    <option value="24">4コママンガ</option>
                    <option value="25">BL</option>
                    <option value="26">アダルト</option>
                    <option value="27">ライトノベル</option>
            </select>
        </li>
         
        <li>価額:
        <input id="book_price" name="book_price" type="text" size="10" placeholder="価額" maxlength="9">円
        </li>
        <li>在庫:
        <input id="book_count" name="book_amount" type="text" size="10" placeholder="在庫" maxlength="5">冊
        </li>
        <li>イメージ:
        <input id="book_image" name="book_image" type="file" accept="image/*">
        </li>

        <input type="submit" value="登録">
    </form>
    </ul>
</body>
</html>