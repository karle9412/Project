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

function DeleteBoard(){
let ans = confirm("삭제하시겠습니까?");
if(ans){
if("${nickName}" != "${reviewBoardVo.writer}"){
alert("본인이 작성한 게시글만 삭제 가능합니다");
}
else{
$.ajax({
type:"get",
url:"/Board/RVBoardDelete?board_number=${reviewBoardVo.board_number}&menu_id=${menu_id}",

success:function(result){
alert("삭제되었습니다");
location.href='/Board/reviewList?menu_id=MENU_03&pageNum=1&contentNum=10';
}


});
}
}
}
</script>




</head>
<body>
 <table id="board">
 <table>

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
              </td>
                     <form name = "RVUpdateBoard" method = "get">
                                         <input type = "hidden" name ="board_number" value= "${reviewBoardVo.board_number}"/>
                                         <input type = "hidden" name = "menu_id" value= "${menu_id}"/>
                                         <input type = "hidden" name=  "writer"  value = "${reviewBoardVo.writer}"/>
                                          <button type = "button" id = "update" onClick = "UpdateBoard_()">수정</button>
                                         </form>
                     <input type = "button" id = "delete" value= "삭제" onclick = "DeleteBoard()"</button>
                     [<a href="/Board/reviewList?menu_id=MENU_02&pageNum=${boardPager.getPageNum()+1}&contentNum=${(boardPager.getPageNum()+1)*10}">목록으로</a>]
                     [<a href="javascript:history.back()">이전으로</a>]
                     [<a href="/">Home</a>]
                     </td>
                     </tr>
                     </table>

<script>
function UpdateBoard_(){
if("${nickName}" != "${reviewBoardVo.writer}"){
alert("본인이 작성한 게시글만 수정 가능합니다");
}
else{
$("#update").on("click", function(){
let formobj = $("form[name='RVUpdateBoard']");
formobj.attr("action", "/Board/RVUpdateForm");
formobj.submit();
});
}
}
</script>


</body>
</html>