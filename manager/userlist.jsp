<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Manager</title>
	<script src="http://code.jquery.com/jquery-1.11.0.js"> </script>
	<script src="manager/page.js"></script>
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
    <tr>
        <td align="center"  width="100">ID</td> 
        <td align="center"  width="100">Name</td> 
        <td align="center"  width="100">Password</td>
        <td align="center"  width="100">Tel</td> 
        <td align="center"  width="100">mail</td> 
        <td align="center"  width="100">sex</td>
        <td align="center"  width="100">birth</td>
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