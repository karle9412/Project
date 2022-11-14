<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
  #board  td:nth-of-type(1) { width:150px; text-align:center;}
  #board  td:nth-of-type(2) { width:400px; text-align:left;}
  #board  td:nth-of-type(3) { width:150px; text-align:center;}
  #board  td:nth-of-type(4) { width:400px; text-align:left;}
  #board  tr:nth-of-type(4) { height : 400px; vertical-align: top; }
  #board  input     { width:100%; }
  #board  textarea  { width:100%; height: 400px;  }
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>





</head>
<body>
 <table id="board">

             <caption><h2>내용 보기</h2></caption>
             <tr>
              <td>번호</td>
              <td>${ reviewBoardVo.board_number } </td>
             <tr>
              <td>작성일</td>
              <td>${ reviewBoardVo.indate } </td>
              <td>작성자</td>
              <td>${ reviewBoardVo.writer } </td>
             </tr>
             <tr>
              <td>제목</td>
              <td colspan="3">${ reviewBoardVo.title } </td>
             </tr>
             <tr>
              <td>내용</td>
              <td colspan="3">${ reviewBoardVo.cont }</td>
             </tr>
             <tr>

              <td colspan="4">
                     [<a href="/Board/WriteForm?menu_id=${menu_id}&bnum=0&lvl=0&step=0&nref=0">새 글 쓰기</a>]
                     [<a href="/Board/RVUpdateForm?board_number=${reviewBoardVo.board_number}&menu_id=${menu_id}">수정</a>]
                     [<a href="/Board/Delete?board_number=${boardVo.board_number}&menu_id=${menu_id}">삭제</a>]
                     [<a href="/Board/reviewList?menu_id=MENU_02&pageNum=${boardPager.getPageNum()+1}&contentNum=${(boardPager.getPageNum()+1)*10}">목록으로</a>]
                     [<a href="javascript:history.back()">이전으로</a>]
                     [<a href="/">Home</a>]
                     </td>



</body>
</html>