<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="jp">
<head>
	<meta charset="UTF-8">
    <title>Manager</title>
    <script src="http://code.jquery.com/jquery-1.11.0.js"> </script>
    <script src="manager/page.js"></script>
    <script src="manager/booklist.js"></script>
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
    <tr>
        <td align="center"  width="100">本名</td> 
        <td align="center"  width="100">ジャンル</td> 
        <td align="center"  width="100">価額</td>
        <td align="center"  width="100">在庫</td> 
        <td align="center"  width="100">イメージ</td> 
        <td align="center"  width="100">ISBNコード</td>
        <td align="center"  width="100">修正</td>
        <td align="center"  width="100">削除</td>          
      </tr>
    </table>

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