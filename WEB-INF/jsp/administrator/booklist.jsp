<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.ArrayList, bean.EbBookBean"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="jp">
<head>
	<meta charset="UTF-8">
    <title>Manager</title>
    <script src="http://code.jquery.com/jquery-1.11.0.js"> </script>

    <script><%@include file="page.js" %></script>
    <script><%@include file="../../../js/ajax.js" %></script>
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
    <a href="managercall.do"><button id="bookMain">管理者メイン</button></a>
    <a href="bookregistcall.do"><button id="bookregist">登録</button></a>
</div>
    <table border="1">
        <tbody>
            <tr>
                <th align="center"  width="100">書籍名</td> 
                <td align="center"  width="100">ジャンル</td> 
                <td align="center"  width="100">価格</td>
                <td align="center"  width="100">在庫</td> 
                <td align="center"  width="100">イメージ</td> 
                <td align="center"  width="100">ISBNコード</td>
                <td align="center"  width="100">修正</td>
            </tr>

            <c:forEach var="book" items="${result}">
            <tr>
                <td>${book.book_name}</td>
                <td>${book.genre_id}</td>
                <td>${book.book_price}</td>
                <td>${book.book_amount}</td>
                <td>
                   
                </td>
                <th>${book.book_isbn}</th>
                <td><button type="button" onclick="appear(${book.book_isbn})">修正</button></td>
            </tr>
            </c:forEach>

        </tbody>

   </table>

    <div id="result"></div>


    <ul id="paging"></ul>
        
    <div>
        <script>
            
            var page = new pager();
        
            page.buttonClickCallback = listContent;
            
            function listContent () {
                page.renderpager(1001); 
                
              
            }
        
            listContent();
        
        </script>
    </div>

    <br><br><br>

    <div id="update" style="display:none;">
        <ul>
            <form name="register" action='/ecbook/updatebook.do' method="Post">
                <li>
                    <label for="book_kind">ジャンル</label>
                    <select id="book_kind" name="book_kind">
                        <option value="1">少年</option>
                        <option value="2">少女</option>
                        <option value="3">ライトノベル</option>
                </select>
                </li>
                <li>
                    <label for="book_price">価格</label>
                    <input id="book_price" name="book_price" type="text"
                        size="10" placeholder="価格"  maxlength="9">円
                </li>
                <li>
                    <label for="book_amount">在庫</label>
                    <input id="book_amount" name="book_amount" type="text"
                        size="10" placeholder="在庫" maxlength="5">冊
                </li>
                <input type="hidden" id="book_isbn" name="book_isbn">
                <input type="submit" value="修正">
            </form>
            <button type="button" onclick="disappear()">閉じる</button>
        </ul>
        
    </div>
        
</body>
</html>