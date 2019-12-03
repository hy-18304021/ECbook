<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.ArrayList, bean.EBBookBean"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="jp">
<head>
	<meta charset="UTF-8">
    <title>Manager</title>
    <script src="http://code.jquery.com/jquery-1.11.0.js"> </script>

    <script src="manager/page.js"></script>
    <script src="manager/booklist.js"></script>
    <script src="js/ajax.js"></script>
    <!-- <link rel="stylesheet" type="text/css" href="css/booklist.css"> -->

    <style>
            #paging {
                list-style-type:none;
        }
            #paging li {      
                margin:3px;
                cursor:pointer;
                float:left;
                color: #666;
                font-size: 1.1em;
        }
            #paging li.selected {      
                color: #0080ff;
                font-weight:bold;
        }
            #paging li:hover {      
                color: #0080ff;
        }
        
    </style>
         
</head>
<body>

<div id="listHeader">
    <button id="bookMain">管理者メイン</button>
</div>
    <table border="1">
        <tbody>
            <tr>
                <th align="center"  width="100">本名</td> 
                <td align="center"  width="100">ジャンル</td> 
                <td align="center"  width="100">価額</td>
                <td align="center"  width="100">在庫</td> 
                <td align="center"  width="100">イメージ</td> 
                <td align="center"  width="100">ISBNコード</td>
                <td align="center"  width="100">修正</td>
                <td align="center"  width="100">削除</td>
            </tr>

            <c:forEach var="book" items="${sessionScope.books}">
            <tr>
                <td>${book.book_name}</td>
                <td>${book.book_kind}</td>
                <td>${book.book_price}</td>
                <td>${book.book_count}</td>
                <td>
                    <img src="${pageContext.request.contextPath}/img/book/${book.book_image}" alt="${book.book_image}">
                </td>
                <th>${book.book_isbn}</th>
                <td><button type="button" onclick="appear()">修正</button></td>
                <td><button type="button" onclick="deleteData()" name="delete">削除</button></td>
            </tr>
            </c:forEach>

        </tbody>

   </table>

    <div id="result"></div>
    <div id="update" style="display:none;">
        <ul>
            <li>
                <label for="book_kind">大ジャンル選択</label>
                    <select id="book_kind" name="book_kind">
                      <option value="100">雑誌</option>
                      <option value="200">専門書</option>
                      <option value="300">小説</option>
                      <option value="300">児童向け</option>
                      <option value="300">外国書</option>
                      <option value="300">成人向け</option>
                    </select>
            </li>
            <li>
                <label for="book_name">本名</label>
                <input id="book_name" name="book_name" type="text"
                    size="50" placeholder="本名" maxlength="25">
            </li>
            <li>
                <label for="book_price">価額</label>
                <input id="book_price" name="book_price" type="text"
                    size="10" placeholder="価額"  maxlength="9">円
            </li>
            <li>
                <label for="book_count">在庫</label>
                <input id="book_count" name="book_count" type="text"
                    size="10" placeholder="在庫" maxlength="5">冊
            </li>
            <li>
                <label for="book_image">イメージ</label>
                <input id="book_image" name="book_image" type="file">
            </li>

            <li><button type="button" onclick="updateBookData()">修正</button></li>
            <br>
            <button type="button" onclick="disappear()">閉じる</button>
        </ul>
        
    </div>
<br><a href="manager"><<<<</a>
            

    <ul id="paging">
        </ul>
        
        <script>
            
            var page = new pager();
        
            page.buttonClickCallback = listContent;
            
            function listContent () {
                page.renderpager(1001); 
                
              
            }
        
            listContent();
        
        </script>
        
        
</body>
</html>