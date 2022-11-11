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

<script>
window.onload = function(){
    let form = document.querySelector('form');
    form.addEventListener('submit', function(e) {
       if( $('#cont').val() == ''){
        alert('댓글을 입력하세요');
        e.preventDefault();
       }
    });
}
</script>

</head>
<body>
 <table id="board">

             <caption><h2>내용 보기</h2></caption>
             <tr>
              <td>번호</td>
              <td>${ boardVo.board_number } </td>
             <tr>
              <td>작성일</td>
              <td>${ boardVo.indate } </td>
              <td>작성자</td>
              <td>${ boardVo.writer } </td>
             </tr>
             <tr>
              <td>제목</td>
              <td colspan="3">${ boardVo.title } </td>
             </tr>
             <tr>
              <td>내용</td>
              <td colspan="3">${ boardVo.cont }</td>
             </tr>
             <tr>

              <td colspan="4">
                [<a href="/Board/CBoardWriteForm?menu_id=MENU_01">새 글 쓰기</a>]
                [<a href="/Board/CBoardUpdateForm?board_number=${boardVo.board_number}&menu_id=${menu_id}">수정</a>]
                [<a href="/Board/CBoardDelete?board_number=${boardVo.board_number}&menu_id=${menu_id}">삭제</a>]
                [<a href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getPageNum()+1}&contentNum=${(boardPager.getPageNum()+1)*10}">목록으로</a>]
                [<a href="javascript:history.back()">이전으로</a>]
                [<a href="/">Home</a>]
              </td>

<table id="reply1">
<div id="reply">
  <ol class="replyList">
    <c:forEach items="${replylist}" var="replylist">
        <p>
        작성자 : ${replylist.writer}<br />
        작성 날짜 :${replylist.indate}
        </p>
        <p>${replylist.cont}</p>
    </c:forEach>
  </ol>
</div>
</table>


<form id="replyForm"name = "replyForm" method= "post">
<input type = "hidden"  id = "board_number" name ="board_number" value = "${boardVo.board_number}"/>
<input type = "hidden"  id = "writer"       name ="writer"       value = "${boardVo.writer}"/>
<div>
<label for="content">댓글 내용</label><input type="text" id="cont" name="cont" />
  </div>
  <div>
   	 <button type="submit" id="replyWriteBtn" class="replyWriteBtn">작성</button>
   	 <span id = "test"> </span>
    </div>
  </form>


<script>
$(".replyWriteBtn").on("click", function(){
   console.log("click")
  var formObj = $("form[name='replyForm']");
  formObj.attr("action", "/Board/CtmreplyWrite");
});
</script>



</body>
</html>