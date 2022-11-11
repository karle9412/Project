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
replylist();
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
                     </td>
                [<a href="/Board/WriteForm?menu_id=${menu_id}&bnum=0&lvl=0&step=0&nref=0">새 글 쓰기</a>]
                [<a href="/Board/CBoardUpdateForm?board_number=${boardVo.board_number}&menu_id=${menu_id}">수정</a>]
                [<a href="/Board/CBoardDelete?board_number=${boardVo.board_number}&menu_id=${menu_id}">삭제</a>]
                [<a href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getPageNum()+1}&contentNum=${(boardPager.getPageNum()+1)*10}">목록으로</a>]
                [<a href="javascript:history.back()">이전으로</a>]
                [<a href="/">Home</a>]
              </td>
              </table>

<div id = Replyli>

</div>

<div style="width:700px; text-align:center;">

       <br>
      <textarea rows ="5" cols="80" id="replytext"
      placeholder="댓글을 작성하세요"></textarea>
       <button type="button" id="btnReply" class="btnReply">작성</button>
       </br>





<script>



$("#btnReply").click(function(){
 let cont  = $("#replytext").val();
 let board_number = "${boardVo.board_number }";
 let menu_id = "${menu_id}";
 let writer = "${boardVo.writer}"
 let param = {"cont":cont, "board_number":board_number, "menu_id":menu_id, "writer":writer};

 $.ajax({
  type: "post",
  url: "/Board/CtmreplyWrite",
  data: param,
  success: function(result){
   alert("댓글이 등록되었습니다");
    $("#replytext").val('');
     replylist();

  }
  });
 });

function replylist(){


 $.ajax({
 type:"get",
 url: "/Board/CReplyList?board_number=${boardVo.board_number}&menu_id=${menu_id}",
 success: function(resultList){
 let html = "";
 html+= '<table>';

     for(var i =0; i<resultList.length; i++){

          html+= '<tr>';
          html+= '<td>';
          html+= resultList[i].writer;
          html+= '</td>';
          html+= '</tr>';
          html+= '<tr>';
          html+= "<td id = \"resultList[i].reply_number\">";
          html+= resultList[i].cont;
          html+= '</td>';
          html+= '</tr>';
          html+= '<tr>';
          html+='<td>';
          html+= resultList[i].indate;
          html+='</td>';
          html+='<td>';
          html+="<button type=\"button\" class=\"btn\" id = \"replyupdateBtn\" onclick=\"updatereply("+ resultList[i].reply_number + ")\" >수정</button>";
          html+= '</td>';
          html += "<td>삭제</td>";
          html+= '</tr>';
    }

    html+='</table>';
    $('#Replyli').html(html);




}
 });
}

function updatereply(reply_number){


    }



</script>


</body>
</html>