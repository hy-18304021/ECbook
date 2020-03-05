<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <!DOCTYPE html>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
   <html lang="en">
   <head>
   	<meta charset="UTF-8">
   	<title>My page</title>
    <link rel="stylesheet" type="text/css" href="css/mypage.css">
    <link rel="stylesheet" type="text/css" href="css/text.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="js/ajax.js"></script>
    <script src="js/pageload.js" type="text/javascript" charset="utf-8" async defer></script>
    <script src="js/mypage.js" type="text/javascript" charset="utf-8" async defer></script>
   </head>
   <body>
    <h1 style="display:none;" id="flag">${sessionScope.flag}</h1>
    <h1 style="display:none;" class="sessionId">${sessionScope.user.id}</h1>
    <div id="app">
        <header class="page-element">
            <div>
                <a href="indexcall.do">
                    <img src="img/logo.png" style="margin-top:8px; width:182px; height: 66px;">
                </a>
              
           <div class="book-finder">
            <ul class="book-type-list">
                <li id="booklistli"><a href="getbooktable.do">BookList</a></li>
                <li id="loginli"><a href="logincall.do">Login</a></li>
                <li id="logoutli"><a href="logout.do">Logout</a></li>
                <li id="mycart"><a href="mycart.do">Cart<div class='cartnumber'><center>${fn:length(sessionScope.mycart)}</center></div></a></li>
              </ul>
              <form class="book-search" action="searchbook.do" method="post">
                <input type="text" name="book_name">
                <input type="hidden" name="genre_id" value="0">
                <input type="submit" value="Search">
            </form>
           </div>

        </div>
    </header>
        <main>
            <div class="leftcolumn">
                <p style="font-weight: bold;" onclick="display('meminfo')">情報</p>
                <p style="font-weight: bold;" onclick="display('favorite')">欲しいリスト</p>
                <p style="font-weight: bold;"></p>
            </div>
    
    <div class="frame">        
    <div class="mypage">
    <div class="meminfo">
        <h2>マイページ</h2>        
        <ul id="mem">
            <li><a href="addressmanagementcall.do">お届け先住所管理</a></li>
            <li><a href="addresseditcall.do">お届け先住所登録</a></li>
        </ul>
        
        <hr>
        
          <table>
            <tr>
              <th>ユーザ名</th><td>${sessionScope.user.id}</td>
            </tr>
            <tr>
                <th>名前</th><td>${sessionScope.user.name}</td>
            </tr>
            <tr>
                <th>パスワード</th><td>${sessionScope.user.pass}</td>
              </tr>
            <tr>
              <th>メール</th><td>${sessionScope.user.mail}</td>
            </tr>
            <tr>
                <th>性別</th>
                <td>
                    <c:choose>
                        <c:when test="${sessionScope.user.sex=='1'}">
                            男
                        </c:when>    
                        <c:otherwise>
                            女
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>生年月日</th><td>${sessionScope.user.birth}</td>
            </tr>
            <tr>
                <th colspan="2"><button onclick="appearUpdateForm()">修正</button></th>
            </tr>
            
        </table>
        
        <div id="update" style="display:none;">
            <table style="float: right; margin-top:-243px;">
            <form action="updateuser.do" method="post" accept-charset="utf-8">
                <input type="hidden" name="id" value="${sessionScope.user.id}">
                <!-- <tr>
                    <th>ユーザ名</th>
                    <td><input type="text" name="id" id="id"></td>
                </tr> -->
                <tr>
                    <th>名前</th>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <th>パスワード</th>
                    <td><input type="text" name="pass" id="pass"></td>
                </tr>
                <tr>
                    <th>メール</th>
                    <td><input type="text" name="mail" id="mail"></td>
                </tr>
                <tr>
                    <th>性別</th>
                    <td>
                        <c:choose>
                        <c:when test="${sessionScope.user.sex=='1'}">
                            <label><input type="radio" name="sex" value="1"checked>男</label>
                            <label><input type="radio" name="sex" value="2">女</label>
                        </c:when>    
                        <c:otherwise>
                            <label><input type="radio" name="sex" value="1">男</label>
                            <label><input type="radio" name="sex" value="2" checked>女</label>
                        </c:otherwise>
                    </c:choose>
                    </td>
                </tr>
                <tr>
                <th>生年月日</th>
                <td><input type="date" name="birth" id="birth" value="2018-01-01">
                </td>
                </tr>
                <tr>
                    <th colspan="2">
                    <input type="submit" value="情報修正">
                    <button type="button" onclick="disappear()">閉じる</button>
                    </th>
                </tr>
                </form>
            
           
            </table>
        </div>
      </div>
      <div class="favorite" style="display:none;">
        <h2>欲しいリスト</h2>
        <hr>
        <c:set var="totalFavorBooks" value="${0}" />
        <c:forEach var="favor" items="${myfavorite}">
            <c:set var="totalFavorBooks" value="${totalFavorBooks}+1" />
            <i class="open-overlay">
                 <img src="https://cover.openbd.jp//${favor.book_isbn}.jpg" width="180" height="230" alt="${favor.book_isbn}">
            </i>
        </c:forEach>
        <c:choose>
            <c:when test="${totalFavorBooks=='0'}">
            <br><br>
                <p style="font-weight: 800; color:red; font-size: 20px">欲しい本がありません。</p>
            </c:when>    
            <c:otherwise>
            </c:otherwise>
        </c:choose>
      </div>
      <div class="overlay-result"  aria-hidden="true">
        <center>
          <div class="overlay-result-x">
          <div class="close-button">
            本の情報
            <i class="a-icon a-icon-close close-overlay" ></i>
          </div>
          <div id="overlay_result_image">
          </div>
          <div id="overlay_result">
              
          </div>
        </div>
        </center>
      </div>
    </div>
       
    </div>
    </main>
    </div>
   </body>
   </html>