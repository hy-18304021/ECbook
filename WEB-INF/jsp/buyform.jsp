<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.ArrayList, bean.EBBookBean"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="jp">
<head>
    <meta charset="UTF-8">
    <title>buyresult</title>
    <script src="http://code.jquery.com/jquery-1.11.0.js"> </script>         
</head>
<body>
    <!-- header -->

    <!-- buyform -->
    <table border="1"> 
        <tr class="cen">  
            <td width="300">商品名</td> 
            <td width="100">販売価額</td>
            <td width="50">数</td> 
            <td width="100">金額</td>
        </tr>
        <tr>
           <td colspan="4" align="right" class="b">ご請求額 : 
        </tr>
    </table>

    <br><br>

    <table border="1">
        <tr> 
            <td colspan="3"><font size="+1" ><b>住所情報</b></font></td>
        </tr>
        <tr>
            <td width="200"><input type="checkbox" name="address" value="1">住所１</td>
            <td width="200"><input type="checkbox" name="address" value="2">住所２</td>
            <td width="200"><input type="checkbox" name="address" value="3">住所３</td>
        </tr>
        <tr> 
            <td  width="200" align="left">支払い方法</td>
            <td width="400" colspan="2" align="left">
              クレジットカード
        </td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="住所を追加"></td>
        </tr>
        <tr> 
                <td colspan="3" align="center">
                 <input type="submit" value="キャンセル">
                 <button id="cancle">注文確定</button>
              </td>
            </tr>
    </table>
    
</body>
</html>