<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/common.css" />
<style>
  .td1 { width:150px; text-align: center; }
  .td2 { width:400px; text-align: left; }
  .td3 { width:150px; text-align: center; }
  .td4 { width:400px; text-align: left; }

  [type=text]  { width:100%;  }
  textarea     { width:100%; height: 300px;  }
</style>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  <div id="main">
    <form action="/Board/RBoardUpdate" method="POST">
    <input type="hidden" name="board_number" value="${ riderBoardVo.board_number}" />
    <input type="hidden" name="menu_id" value="${ menu_id } " />

    <table  id="boardUpdate">
     <caption><h2>${ menu_id } 게시물 수정</h2></caption>
       <td class="td3">날짜</td>
       <td class="td4">${ riderBoardVo.indate }</td>
     </tr>
     <tr>
       <td class="td1">글쓴이</td>
       <td class="td2">${ riderBoardVo.writer }</td>
     </tr>
     <tr>
       <td class="td1">제목</td>
       <td class="td2"  colspan="3">
       	 <input type="text" name="title" value="${ riderBoardVo.title }" />
       </td>
     </tr>
     <tr>
       <td class="td1">내용</td>
       <td class="td2"  colspan="3">
       	 <textarea name="cont">${ riderBoardVo.cont }</textarea>
       </td>
     </tr>
     <tr>
       <td class="td1" colspan="4">
         <input type="submit"  value="수정" />
         <a href="/Board/riderList?menu_id=${menu_id}">글 목록</a>
       </td>
     </tr>
    </table>
    </form>

  </div>
</body>
</html>














