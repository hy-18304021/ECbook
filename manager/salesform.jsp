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
</head>
<body>
    <table border="1">
        <tbody>
            <tr>
                <td align="center"  width="100">注文番号</td>
                <td align="center"  width="100">ユーザ名</td>
                <td align="center"  width="100">本名</td>
                <td align="center"  width="100">購入数</td>
                <td align="center"  width="100">単価</td>
                <td align="center"  width="100">価額</td>
                <td align="center"  width="100">購入日時</td>
            </tr>
        </tbody>
    </table>
    <input type="text" name="search" >
    <button>search</button>
</body>
</html>