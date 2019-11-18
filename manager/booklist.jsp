<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="jp">
<head>
	<meta charset="UTF-8">
    <title>Manager</title>
    <script src="http://code.jquery.com/jquery-1.11.0.js"> </script>
	<script src="manager/page.js"></script>
    <script src="js/ajax.js"></script>
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
            <th>${book.book_name}</td>
            <td>${book.book_kind}</td>
            <td>${book.book_price}</td>
            <td>${book.book_count}</td>
            <td></td>
            <td>${book.book_isbn}</td>
            <td><button type="button" onclick="updateData()">修正</button></td>
            <td><button type="button" onclick="deleteData()" name="delete">削除</button></td>
        </tr>
        </c:forEach>

    </tbody>
    

</table>
    <div id="update">
        
    </div>

<div id="result"></div>

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