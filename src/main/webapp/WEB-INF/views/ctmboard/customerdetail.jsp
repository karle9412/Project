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
$(document).ready(function(){
replylist();
});



function DeleteBoard(e){
let ans = confirm("삭제하시겠습니까?");
if(ans){
if("${nickName}" != "${boardVo.writer}"){
alert("본인이 작성한 게시글만 삭제 가능합니다");
}
else{
$.ajax({
type:"get",
url:"/Board/CBoardDelete?board_number=${boardVo.board_number}&menu_id=${menu_id}",
success:function(result){
alert("삭제되었습니다");
location.href='/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10';
}

});
}
}
}




function updateReplyForm(reply_number,writer){
const writer_check =confirm("수정하시겠습니까?");
if( writer_check ===true){

if("${nickName}" != writer){
alert("본인이 작성한 댓글만 수정 가능합니다.");
}
else{

let k = document.getElementById("R"+reply_number);

   let form = "";
   form += '<div>';
   form += '<input type= "hidden" name="reply_numbery" id ="reply_number" value= '+reply_number+'>';
   form += '<input type= "hidden"  name="writer" id= "writer" value='+ writer +'>'
   form += '<textarea class = "replyclass" id= "replycontent" cols="80" rows="3">';
   form += k.textContent;
   form += "</textarea>";
   form += "<br/>";
   form +='<button type = "button" class="Updatebtn" onClick="updateReply(' + reply_number +',\'' + writer + '\')"> 완료 </button>';
   form +='<button type = "button" class="DeleteBtn" onClick="replylist()" >';
   form += '취소';
   form += '</button>';
   form += '</div>';
   form += '</br>';
   document.getElementById("R"+reply_number).innerHTML = form;
   $("[name=replyupdateBtn]").css("display", "none");
   $("[name=replydeleteBtn]").css("display", "none");




}
   }
    }

function updateReply(reply_number, writer){
let reply_content = $("#replycontent").val();
let replynumber = reply_number;
let reply_writer = writer;
let updateurl = "/Board/CtmreplyUpdate?reply_number=";
let updateurl1= "&cont="
let param = {"cont":reply_content, "reply_number":replynumber, "writer":reply_writer};



$.ajax({
 type: "POST",
   url: updateurl + replynumber + updateurl1 + reply_content,
   data: param,
   success: function(result){
    alert("댓글이  수정되었습니다");
      replylist();
},

   error: function(error_){
   if($('#replycontent').val() == ''){
         alert('댓글을 입력해주세요.')
   }
   }

});

}


function deleteReply(reply_number,writer){
let deleturl = "/Board/ReplyDelete?reply_number="
let DeleteReply_number = reply_number
console.log("writer")


let ans = confirm("삭제하시겠습니까?");
if("${nickName}" != writer){
alert("본인이 작성한 댓글만 삭제 가능합니다");
}
else{
if(ans === true){
$.ajax({
    type: "POST",
    url: deleturl + DeleteReply_number,
    success: function(deleteresult){
    alert("댓글이 삭제되었습니다");
    replylist();
}

});
}
}
}




</script>


</head>
<body>
 <table id="board_">

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
             <t r>
              <td>제목</td>
              <td colspan="3">${ boardVo.title } </td>
             </tr>
             <tr>
             <div id = "startline">
             <td>출발지</td>
             <td >${boardVo.c_start}</td>
             <td>목적지</td>
             <td>${boardVo.c_end}</td>
             <td>일자</td>
             <td>${boardVo.delivery_indate}</td>
             </tr>
             <tr>
             <td>비용</td>
             <td>${boardVo.money}</td>
             <td>수화물</td>
             <td>${boardVo.luggage}</td>
             </div>
             <tr>
             <tr>
              <td>내용</td>
              <td colspan="3">${ boardVo.cont }</td>
             </tr>
             <tr>

              <td colspan="4">
                     </td>
                [<a href="/Board/WriteForm?menu_id=${menu_id}&bnum=0&lvl=0&step=0&nref=0">새 글 쓰기</a>]
                <form name = "UpdateBoard" method = "get">
                                <input type = "hidden" name ="board_number" value= "${boardVo.board_number}"/>
                                <input type = "hidden" name = "menu_id" value= "${menu_id}"/>
                                <input type = "hidden" name=  "writer"  value = "${boardVo.writer}"/>
                                <button type = "button" id = "update" onClick = "UpdateBoard_()">수정</button>
                                </form>
                <input type = "button" id = "delete" value= "삭제" onclick = "DeleteBoard()"</button>
                [<a href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getPageNum()+1}&contentNum=${(boardPager.getPageNum()+1)*10}">목록으로</a>]
                [<a href="javascript:history.back()">이전으로</a>]
                [<a href="/">Home</a>]
              </td>
              </tr>
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
 let writer = "${nickName}"
 let param = {"cont":cont, "board_number":board_number, "menu_id":menu_id, "writer":writer};
 console.log(param)

 $.ajax({
  type: "post",
  url: "/Board/CtmreplyWrite",
  data: param,
  success: function(result){
   alert("댓글이 등록되었습니다");
    $("#replytext").val('');
     replylist();
   },
   error: function(xhr){
    if($("#replytext").val() == ''){
      alert('댓글을 입력해주세요.')
     }

  }

  });

 });


function replylist(){

 $.ajax({
 type:"GET",
 url: "/Board/CReplyList?board_number=${boardVo.board_number}&menu_id=${menu_id}&pageNum=${map.pageNum}&contentNum=${map.contentNum}",
 success: function(resultList){
 let html = "";
 let pager = "";
 let end = parseInt(resultList[0].rend_page);
 let startP = parseInt("${replyPager.getStartPage()}");
 console.log(typeof(start));
 html+= '<table>';
   for(var i=0; i<resultList.length; i++){
     html+= '<tr>';
     html+= '<td>';
     html+= resultList[i].writer;
     html+= '</td>';
     html+= '</tr>';
     html+= '<tr>';
     html+= '<td id="R'+ resultList[i].reply_number +'">';
     html+= resultList[i].cont;
     html+= '</td>';
     html+= '</tr>';
     html+= '<tr>';
     html+= '<td>';
     html+= resultList[i].indate;
     html+= '</td>';
     html+= '<td>';
     html+= '<button type="button" class="btn" name = "replyupdateBtn" onclick="updateReplyForm('+ resultList[i].reply_number + ',\'' + resultList[i].writer +'\')">수정</button>';
     html+= '</td>';
     html+= '<td>';
     html+='<button type="button" class="btndelte" name="replydeleteBtn" onclick="deleteReply('+ resultList[i].reply_number + ',\'' + resultList[i].writer +'\')">삭제</button>';
     html+= '</td>'
     html+= '</tr>';
     if ((i+1) == resultList.length){
       html += '</table>';
       html += '<table id="pager">';
       html += '<tr>';
       html += '<td>';
       html += '<c:if test="${replyPager.prev}">';
       html += '<a href="/Board/CustomerDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum=${replyPager.getStartPage()-1}&contentNum=${(replyPager.getStartPage()-1)*10}">< 이전</a>';
       html += '</c:if>';
       html += '</td>';
       html += '<td>';
       for (var j=startP; j<=end; j++){
       html += '<a href="/Board/CustomerDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum='+j+'&contentNum='+j*10+'">'+j+'</a>';
       }
       html += '</td>';
       html += '<td>';
       if("${replyPager.next}"=="true"){
         html += '<a href="/Board/CustomerDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum=${replyPager.getEndPage()+1}&contentNum=${(replyPager.getEndPage()+1)*10}">다음 ></a>';
       }
       html += '</td>';
       html += '</tr>';
       html += '</table>';
     }
   }
   $('#Replyli').html(html);
}
 });
}
function UpdateBoard_(){
if("${nickName}" != "${boardVo.writer}"){
alert("본인이 작성한 게시글만 수정 가능합니다");
}
else{
$("#update").on("click", function(){
let formobj = $("form[name='UpdateBoard']");
formobj.attr("action", "/Board/CBoardUpdateForm");
formobj.submit();
});
}
}







</script>


</body>
</html>